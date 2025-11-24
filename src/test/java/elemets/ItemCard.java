package elemets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ItemCard {
    private static final SelenideElement item = $x("(//div[@class='inventory_item'])[1]");
    private static final SelenideElement itemName = $("#item_4_title_link");

    private static final SelenideElement addToCartButton = item.$("#add-to-cart-sauce-labs-backpack");
    private static final SelenideElement cancelAdd = item.$("#remove-sauce-labs-backpack");

    public static void checkItemName(String value) {
        item.shouldBe(visible);
        itemName.$(".inventory_item_name").shouldHave(text(value));
    }

    public static void addToCartButtonClick() {
        addToCartButton.click();
        cancelAdd.shouldBe(visible);
    }
}