package test.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

import java.util.List;

public class CatalogCheckPrice extends BaseTest {

    @Override
    public boolean doTest() {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 3);

        webDriver.get("https://www.bamilo.com/fashion_for_men/?special_price=1");
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/i")).click();
        //        webDriver.navigate().refresh();

        int mainPrice;
        int comparisonPrice;
        int i = 0;
        String productLink;
        boolean result = true;

        List<WebElement> list = webDriverWait.until
                (ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("sku")));
        for (WebElement product : list) {
            productLink = product.findElement(By.className("link")).getAttribute("href");
            product = product.findElement(By.className("price")).findElement(By.tagName("span"));
            mainPrice = Integer.parseInt(product.getAttribute("data-price"));

            WebDriver newWindow = new ChromeDriver();
            newWindow.get(productLink);
//            newWindow.navigate().refresh();
            newWindow.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/i")).click();

            product = new WebDriverWait(newWindow, 3).until(ExpectedConditions.presenceOfElementLocated(By.className("price")))
                    .findElement(By.tagName("span"));
            comparisonPrice = Integer.parseInt(product.getAttribute("data-price"));

            if (comparisonPrice == mainPrice) {
                System.out.println("Product " + i + " main value and comparison value are the same and is: " + comparisonPrice);
            } else {
                result = false;
                System.out.println("Product " + i + " main value is: " + mainPrice + " and comparison value is: " + comparisonPrice + "!!!!!!!!!!!!!");
            }
            i++;
            newWindow.close();
        }
        System.out.println("Number of product is: " + list.size());
        webDriver.close();
        return result;
    }
}
