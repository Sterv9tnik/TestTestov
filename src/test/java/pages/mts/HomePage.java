package pages.mts;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private final By OPEN_MAP_BUTTON = By.cssSelector(".styled__Wrapper-sc-1dvfuui-0 [data-testid='flexbox']");
    private final By CARDS_LINKS = By.cssSelector("[href='/chastnim-licam/karti/']");
    private final By CREDIT_LINK = By.cssSelector("[href='/chastnim-licam/karti/all/credit/']");

    public HomePage clickOpenMapButton() {
        $(OPEN_MAP_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Открыть домашнюю страницу")
    public HomePage openPage() {
        open("https://www.mtsbank.ru/");
        return this;
    }

    public HomePage hoverOnCardsLink() {
        $(CARDS_LINKS).hover();
        return this;
    }

    public HomePage clickOnCreditLink() {
        $(CREDIT_LINK).click();
        return this;
    }
}
