package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static tests.BaseTest.cfg;

public class WearPage {

    private final By SORT_BUTTON = By.cssSelector(".t-store__sort-select");
    private final By PRODUCTS_PRICE_TEXT = By.cssSelector(".js-product-price[data-product-price-def]");
    private final By STORE_PROD_NAME = By.cssSelector(".js-store-prod-name");
    private final By OPTION = By.cssSelector("option");

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }

    public WearPage selectSortProduct(String value) {
        $(SORT_BUTTON).click();
        $(SORT_BUTTON).$$(OPTION).filterBy(attribute("value", value)).first().click();
        return this;
    }

    public WearPage checkFirstPrice(String expectedPrice) {
        $$(PRODUCTS_PRICE_TEXT).first().shouldHave(text(expectedPrice));
        return this;
    }

    @Step("Открыть продукт с названием '{0}'")
    public WearPage clickStoreProduct(String productName) {
        $$(STORE_PROD_NAME).shouldHave(sizeGreaterThan(0)).filterBy(text(productName)).first().click();
        return this;
    }

    public WearPage checkSortProduct() {
        List<Integer> actualPrices = $$(PRODUCTS_PRICE_TEXT).stream().map(x -> Integer.parseInt(Objects.requireNonNull(x.getAttribute("data-product-price-def"))))
                .collect(Collectors.toList());

        List<Integer> expectedPrices = actualPrices.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedPrices, actualPrices);
        return this;
    }

    public WearPage checkProductSize(int expectedSize) {
        $$(PRODUCTS_PRICE_TEXT).shouldHave(size(expectedSize));
        return this;
    }
}
