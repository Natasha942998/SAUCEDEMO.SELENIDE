package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;

public class LoginPage {
    private static final SelenideElement title = $(cssSelector(".login_logo"));
    private static final SelenideElement userName = $(cssSelector("#user-name"));
    private static final SelenideElement password = $(cssSelector("#password"));
    private static final SelenideElement loginButton = $(cssSelector("#login-button"));

    public static void waitForPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Swag Labs"));
    }

    public static void enterUsername(String value) {
        userName.setValue(value);
    }

    public static void enterPassword(String value) {
        password.setValue(value);
    }

    public static void clickLoginButton() {
        loginButton.click();
    }
}
