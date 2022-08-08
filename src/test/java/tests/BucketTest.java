package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BucketPage;
import pages.HomePage;
import pages.ProductPage;
import pages.WearPage;

public class BucketTest extends BaseTest {

    @Test
    @DisplayName("Некорректный номер при заказе товара")
    public void checkingIncorrectNumber() {
        HomePage homePage = new HomePage();
        homePage
                .openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
        wearPage.clickStoreProduct("Футболка поло черная (м)");

        ProductPage productPage = new ProductPage();
        productPage.clickAddToBucketButton();

        BucketPage bucketPage = new BucketPage();
        bucketPage
                .sendName("Тест Тестов Тестович")
                .sendPhone("(000) 000-00-00")
                .sendRegion("Республика Татарстан")
                .sendAddress("г. Казань, ул. Уютная, д.8")
//                .sendReceiverName("Иванов Иван Иванович")
//                .sendStreet("Уютная")
//                .sendHouse("2")
//                .sendOffice("1")
                .clickOrderButton()
                .checkMainErrorText("Укажите, пожалуйста, корректный номер телефона")
                .checkPhoneErrorText("Укажите, пожалуйста, корректный номер телефона");
    }
}
