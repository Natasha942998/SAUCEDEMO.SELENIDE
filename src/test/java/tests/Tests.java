package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductPage;

@Epic("Web Interface")
@Feature("Essential features")
@Story("Login and Product pages")

public class Tests {
    LoginPage loginPage;
    ProductPage productPage;
    WebDriver driver;

    String userLogin = "standard_user";
    String password = "secret_sauce";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        loginPage = new LoginPage(driver);
        productPage = new ProductPage();
    }

    @Test
    @Description("Тест проверки авторизации на сайте")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Natalia Sotnikova")
    @TmsLink("Jira-1234")
    public void LoginTest() {

        Allure.step("Дождаться загрузки страницы", step -> {
            loginPage.waitForPageIsLoaded();
        });
        Allure.step("Ввести логин", step -> {
            loginPage.enterUserName(userLogin);
        });
        Allure.step("Ввести пароль", step -> {
            loginPage.enterPassword(password);
        });
        Allure.step("Нажать логин", step -> {
            loginPage.clickLoginButton();
        });
        Allure.step("Дождаться загрузки страницы Products", step -> {
            productPage.waitForProductPageIsLoaded();
        });
        Allure.step("проверка видимости товара", step -> {
            productPage.checkProductCard();
        });
    }

    @Test
    public void AddToCartTest() {
        // Авторизация (чтобы попасть на Products)
        loginPage.waitForPageIsLoaded();
        loginPage.enterUserName(userLogin);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        productPage.waitForProductPageIsLoaded();

        productPage.checkProductCard();
        productPage.addToCart();
    }

    //  переход на страницу товара по клику на название
    @Test
    public void NavigateToProductDetailTest() {
        // Авторизация
        loginPage.waitForPageIsLoaded();
        loginPage.login(userLogin, password);
        productPage.waitForProductPageIsLoaded();

        // Переход на страницу детали товара по клику на название
        productPage.navigateToProductDetail();

        // Проверка, что мы попали на страницу детали и видим корректный заголовок
        productPage.verifyProductDetailPage();
    }
}