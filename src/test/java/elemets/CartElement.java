package elemets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartElement {
    private static final SelenideElement shoppingCart = $( ".shopping_cart_link");
    private static final SelenideElement cardBadge = shoppingCart.$( ".shopping_cart_badge");

    public static void verifyCart() {
        cardBadge.shouldBe(visible).shouldHave(text("1"));
    }

    public static void openCart() {
        shoppingCart.click();
    }
}