package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.home.Login;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/elnaz/Downloads/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 3);

        webDriver.get("http://www.bamilo.com");

        //Instantiate Classes and Do the Tests and Check If the Results are Passed or Not.
        Login login = new Login(webDriverWait, "", "");
        if (login.doTest()) {
            System.out.println("Login test passed sucessfully.");
        } else {
            System.out.println("Oops, Login test failed!!!!!");
        }

        webDriver.close();
    }
}
