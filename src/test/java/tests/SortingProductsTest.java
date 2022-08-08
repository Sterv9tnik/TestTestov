package tests;

import org.junit.Test;
import pages.HomePage;
import pages.WearPage;

public class SortingProductsTest extends BaseTest {

//    @Test()
    public void checkingSortProductsByCost() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
        wearPage.selectSortProduct("price:asc")
                .checkFirstPrice("1 000")
                .checkSortProduct();
    }
}
