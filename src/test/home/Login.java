package test.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

public class Login extends BaseTest {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * This test is:
     * 1. Close the Popup voucher by clicking on close button
     * 2. Click on Login/Register button
     * 3. Enter a registered Email
     * 4. Click on continue button
     * 5. Enter the password
     * 6. Click on submit button
     * 7. You should see the hello text at the top right
     *
     * @author Elnaz Khorsand
     * @since aug-22-2018
     */




    public boolean doTest() {

            WebDriver webDriver;
        webDriver= new ChromeDriver();

        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
            webDriver.get("https://www.bamilo.com/");
            //1. Close the Popup voucher by clicking on close button
            WebElement elementPopupCloseButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/i")));
            if (elementPopupCloseButton.isDisplayed()) {
                elementPopupCloseButton.click();
            }

            //2. Click on Login/Register button
            WebElement elementLoginRegisterLink = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button-single")));
            if (elementLoginRegisterLink.isDisplayed()) {
                elementLoginRegisterLink.click();
            } else {
                System.out.println("Login/Register link is not visible!");
            }

            //3. Enter a registered Email
            WebElement elementEmail = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            if (elementEmail.isDisplayed()) {
                elementEmail.sendKeys(username);
            } else {
                System.out.println("Username/Email field is not accessible!");
            }

            //4. Click on continue button
            WebElement elementContinueFirstStepLoginButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("osh-opc-btn-account")));
            if (elementContinueFirstStepLoginButton.isDisplayed()) {
                elementContinueFirstStepLoginButton.click();
            } else {
                System.out.println("Username/Email submission button is not accessible");
            }

            //5. Enter the password
            WebElement elementPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            if (elementPassword.isDisplayed()) {
                elementPassword.sendKeys(password);
            } else {
                System.out.println("Password field is not accessible!");
            }

            //6. Click on submit button
            WebElement elementContinueLastStepLoginButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("osh-opc-btn-customer")));
            if (elementContinueLastStepLoginButton.isDisplayed()) {
                elementContinueLastStepLoginButton.click();
            } else {
                System.out.println("Password submission button is not accessible!");
            }

            //7. You should see the hello text at the top right
            WebElement elementHelloText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account\"]/div[1]/a/span[1]")));
            if (!elementHelloText.isDisplayed()) {
                System.out.println("Hello text is not shown in welcome page!");
            }
            return elementHelloText.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An exception has happened: " + e.getLocalizedMessage());
            return false;
        } finally {
            webDriver.close();
        }
    }
}
