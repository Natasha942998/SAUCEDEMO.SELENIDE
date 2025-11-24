package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(className = ".login_logo")
    private static WebElement title;

    @FindBy(id = "user-name")
    private static WebElement userName;

    @FindBy(id = "password")
    private static WebElement password;

    @FindBy(id = "login-button")
    private static WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void waitForPageIsLoaded() {
        if (title.isDisplayed() && title.getText().equals("Swag Labs")) {
            System.out.println("Page is open");
        } else {
            System.out.println("Page is not displayed");
        }
    }

    public void enterUserName(String value) {
        userName.sendKeys(value);
    }

    public void enterPassword(String value) {
        password.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String name, String password) {
        enterUserName(name);
        enterPassword(password);
        loginButton.click();
    }
}