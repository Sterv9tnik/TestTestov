package tests;

import entity.User;
import helper.DateFormatter;
import io.qameta.allure.Description;
import org.junit.Test;
import pages.CreditCardMtsCashback;
import steps.CreditCardMtsCashbackSteps;

import java.time.LocalDate;

public class CreditCardTest extends BaseTest {

    CreditCardMtsCashback creditCardMtsCashback = new CreditCardMtsCashback();

    CreditCardMtsCashbackSteps creditCardMtsCashbackSteps = new CreditCardMtsCashbackSteps();

    @Test
    @Description("Ввести корректные данные пользователя и оформить карту")
    public void succesGetCreditCard(){
        creditCardMtsCashback.openPage("https://www.mtsbank.ru/");

        User user = User.builder()
                .setFio("Антонов Антон Антонович")
                .setBirthDate("01.01.1990")
                .setPhoneNumber("7777777777")
                .setEmail("alo@ya.ru")
                .build();

        creditCardMtsCashbackSteps.hoverToCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCardMtsCashbackButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.sendClientData(creditCardMtsCashback, user);
        creditCardMtsCashbackSteps.clickOnNextButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.checkSuccesGetCard(creditCardMtsCashback);
    }

    @Test
    @Description("Не вводить никаких данных пользователя и оформить карту")
    public void failureGetCreditCard(){

        creditCardMtsCashback.openPage("https://www.mtsbank.ru/");

        creditCardMtsCashbackSteps.hoverToCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCardMtsCashbackButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnNextButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.checkAttentions(creditCardMtsCashback);
    }

    @Test
    @Description("Ввести ФИО латиницей и оформить карту")
    public void failureGetCreditCardInvalidFio(){

        creditCardMtsCashback.openPage("https://www.mtsbank.ru/");

        User user = User.builder()
                .setFio("Anton Antonov Antonovich")
                .setBirthDate("01.01.1990")
                .setPhoneNumber("7777777777")
                .setEmail("alo@ya.ru")
                .build();

        creditCardMtsCashbackSteps.hoverToCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCardMtsCashbackButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.sendClientData(creditCardMtsCashback, user);
        creditCardMtsCashbackSteps.checkFioAttention(creditCardMtsCashback);
    }

    @Test
    @Description("Ввести в качестве даты рождения сегодняшнюю дату и оформить карту")
    public void failureGetCreditCardInvalidDateBirth(){

        creditCardMtsCashback.openPage("https://www.mtsbank.ru/");

        User user = User.builder()
                .setFio("Антонов Антон Антонович")
                .setBirthDate(DateFormatter.formatDate(LocalDate.now()))
                .setPhoneNumber("7777777777")
                .setEmail("alo@ya.ru")
                .build();

        creditCardMtsCashbackSteps.hoverToCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCardMtsCashbackButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.sendClientData(creditCardMtsCashback, user);
        creditCardMtsCashbackSteps.checkInvalidBirthDateAttention(creditCardMtsCashback);
    }

    @Test
    @Description("Ввести некорректный почтовый адрес и оформить карту")
    public void failureGetCreditCardInvalidDateEmail(){

        creditCardMtsCashback.openPage("https://www.mtsbank.ru/");

        User user = User.builder()
                .setFio("Антонов Антон Антонович")
                .setBirthDate("01.01.1990")
                .setPhoneNumber("7777777777")
                .setEmail("alo")
                .build();

        creditCardMtsCashbackSteps.hoverToCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCards(creditCardMtsCashback);
        creditCardMtsCashbackSteps.clickOnCreditCardMtsCashbackButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.sendClientData(creditCardMtsCashback, user);
        creditCardMtsCashbackSteps.clickOnNextButton(creditCardMtsCashback);
        creditCardMtsCashbackSteps.checkInvalidEmailAttention(creditCardMtsCashback);
    }
}
