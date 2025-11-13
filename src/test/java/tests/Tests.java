package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
        String userLogin = "standard_user";
        String password = "secret_sauce";

@BeforeAll
        public static void setUp() {
            open("https://www.saucedemo.com/");
        }

 @Test
        public void LoginTest() {
            LoginPage.waitForPageIsLoaded();
            LoginPage.enterUsername(userLogin);
            LoginPage.enterPassword(password);
            LoginPage.clickLoginButton();
        }

    @Test
    public void AddToCartTest() {
        ProductPage.waitForProductPageIsLoaded();
        ProductPage.checkProductCard();
        ProductPage.addToCart();
    }
}
