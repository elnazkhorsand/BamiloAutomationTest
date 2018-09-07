package test;

import test.home.CatalogCheckPrice;
import test.home.Login;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/elnaz/Downloads/chromedriver");

        CatalogCheckPrice catalogCheckPrice = new CatalogCheckPrice();

        //Instantiate Classes and Do the Tests and Check If the Results are Passed or Not.
        Login login = new Login(args[0],args[1]);
        if (login.doTest()) {
            System.out.println("Login test passed sucessfully.");
        } else {
            System.out.println("Oops, Login test failed!!!!!");
        }

        //Instantiate Classes and Do the Tests and Check If the Results are Passed or Not.
        if (catalogCheckPrice.doTest()) {
            System.out.println("CatalogCheck test passed sucessfully.");
        } else {
            System.out.println("Oops, CatalogCheck test failed!!!!!");
        }
    }
}
