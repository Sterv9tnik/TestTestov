package pages.mts;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;

public class CardPage {

    private final By CARDS_NAMES = By.cssSelector("h2");

    public void checkCardsNamesContainsText(String cardName) {
        int expectedSize = $$(CARDS_NAMES).size();
        int actualSize = $$(CARDS_NAMES).filterBy(text(cardName)).size();

        assertEquals(expectedSize, actualSize);
    }
}
