package tests.mts;

import org.junit.Test;
import pages.mts.CardPage;
import pages.mts.HomePage;
import tests.BaseTest;

public class MTSTest extends BaseTest {

    @Test
    public void test() {
        HomePage homePage = new HomePage();
        homePage
                .openPage()
                .hoverOnCardsLink()
                .clickOnCreditLink();

        CardPage cardPage = new CardPage();
        cardPage.checkCardsNamesContainsText("КРЕДИТНАЯ");
    }
}
