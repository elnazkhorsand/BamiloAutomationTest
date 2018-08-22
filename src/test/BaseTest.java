package test;

import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    protected WebDriverWait webDriverWait;

    public BaseTest(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public abstract boolean doTest();
}
