package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ProductPage {

    private static final SelenideElement title = $(cssSelector(".title")); // 1 usage
    private static final SelenideElement item = $x("(//div[@class='inventory_item'])[1]"); // 3 usages
    private static final SelenideElement itemName = $(cssSelector("#item_4_title_link")); // 1 usage

    private static final SelenideElement addToCartButton = item.$(cssSelector("#add-to-cart-sauce-labs-backpack")); // 1 usage
    private static final SelenideElement cancelAdd = item.$(cssSelector("#remove-sauce-labs-backpack")); // 1 usage

    private static final SelenideElement shoppingCard = $(cssSelector(".shopping_cart_link")); // 1 usage
    private static final SelenideElement cardBadge = shoppingCard.$(cssSelector(".shopping_cart_badge")); // 1 usage

    public static void waitForProductPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Products"));
    }

    public static void checkProductCard() {
        item.shouldBe(visible);
        itemName.$(cssSelector(".inventory_item_name")).shouldHave(text("Sauce Labs Backpack"));
    }

    public static void addToCart() {
        addToCartButton.click();
        cancelAdd.shouldBe(visible);
        cardBadge.shouldBe(visible).shouldHave(text("1"));
    }
}
