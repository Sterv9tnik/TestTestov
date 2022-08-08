package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final By ADD_TO_BUCKET_BUTTON = By.cssSelector(".js-store-prod-popup-buy-btn-txt");

    @Step("Добавить товар в корзину")
    public ProductPage clickAddToBucketButton() {
        $(ADD_TO_BUCKET_BUTTON).click();
        return this;
    }
}
