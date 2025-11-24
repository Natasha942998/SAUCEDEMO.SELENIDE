package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.selector.ByDeepShadow.cssSelector;

public class ProductPage {
    private static final SelenideElement title = $(cssSelector(".title"));
    private static final SelenideElement item = $x("(//div[@class='inventory_item'])[1]");
    private static final SelenideElement itemNameLink = $(cssSelector("#item_4_title_link"));
    private static final SelenideElement addToCartButton = item.$(cssSelector("#add-to-cart-sauce-labs-backpack"));
    private static final SelenideElement cancelAdd = item.$(cssSelector("#remove-sauce-labs-backpack"));
    private static final SelenideElement shoppingCard = $(cssSelector(".shopping_cart_link"));
    private static final SelenideElement cardBadge = shoppingCard.$(cssSelector(".shopping_cart_badge"));

    private static final SelenideElement productDetailTitle = $(cssSelector(".inventory_details_name"));

    public ProductPage() {

    }

    public void waitForProductPageIsLoaded() {
        title.shouldBe(visible).shouldHave(text("Products"));
    }

    public void checkProductCard() {
        item.shouldBe(visible);
        itemNameLink.$(cssSelector(".inventory_item_name")).shouldHave(text("Sauce Labs Backpack"));
    }

    public void addToCart() {
        addToCartButton.click();
        cancelAdd.shouldBe(visible);
        cardBadge.shouldBe(visible).shouldHave(text("1"));
    }

    //  переход на страницу детали товара по клику на название
    public void navigateToProductDetail() {
        itemNameLink.click();
    }

    // Проверка, что мы на странице детали товара
    public void verifyProductDetailPage() {
        productDetailTitle.shouldBe(visible).shouldHave(text("Sauce Labs Backpack"));
    }
}