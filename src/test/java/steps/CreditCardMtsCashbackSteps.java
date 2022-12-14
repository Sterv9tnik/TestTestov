package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entity.User;
import io.qameta.allure.Step;
import pages.CreditCardMtsCashback;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;


public class CreditCardMtsCashbackSteps {

    @Step("Навести курсор на поле Карты")
    public void hoverToCards(CreditCardMtsCashback creditCardMtsCashback){
        $(creditCardMtsCashback.getCARDS()).shouldBe(visible, Duration.ofSeconds(30)).hover();
    }

    @Step("Нажать на поле Кредитные карты")
    public void clickOnCreditCards(CreditCardMtsCashback creditCardMtsCashback){
        $(creditCardMtsCashback.getCREDIT_CARDS()).shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Навести на кнопку Оформить карту")
    public void clickOnCreditCardMtsCashbackButton(CreditCardMtsCashback creditCardMtsCashback){
        $(creditCardMtsCashback.getCREDIT_CARD_MTS_CASHBACK_BUTTON()).shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    @Step("Нажать на кнопку далее")
    public void clickOnNextButton(CreditCardMtsCashback creditCardMtsCashback){
        $(creditCardMtsCashback.getBUTTON_NEXT()).shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Отправить полные данные клиента")
    public void sendClientData(CreditCardMtsCashback creditCardMtsCashback, User user){
        $(creditCardMtsCashback.getFIO()).shouldBe(visible, Duration.ofSeconds(30)).sendKeys(user.getFio());
        $(creditCardMtsCashback.getBIRTH_DATE()).shouldBe(visible, Duration.ofSeconds(30)).sendKeys(user.getBirthDate());
        $(creditCardMtsCashback.getPHONE_NUMBER()).shouldBe(visible, Duration.ofSeconds(30)).sendKeys(user.getPhoneNumber());
        $(creditCardMtsCashback.getEMAIL()).shouldBe(visible, Duration.ofSeconds(30)).sendKeys(user.getEmail());
    }

    @Step("Проверка предупрежедений о незаполненных полях")
    public void checkAttentions(CreditCardMtsCashback creditCardMtsCashback){
        List<SelenideElement> attentionElements = $$(creditCardMtsCashback.getATTENTION_TEXT());

        assertEquals("Введите ФИО полностью", attentionElements.get(0).getText());
        assertEquals("Обязательное поле", attentionElements.get(1).getText());
        assertEquals("Обязательное поле", attentionElements.get(2).getText());
    }

    @Step("Проверить некорректный ввод ФИО")
    public void checkFioAttention(CreditCardMtsCashback creditCardMtsCashback){
        SelenideElement attentionFio = $(creditCardMtsCashback.getATTENTION_TEXT()).shouldBe(visible, Duration.ofSeconds(30));

        assertEquals("Используйте только кириллицу", attentionFio.getText());
    }

    @Step("Проверить некорректный ввод даты рождения")
    public void checkInvalidBirthDateAttention(CreditCardMtsCashback creditCardMtsCashback){
        SelenideElement attentionBirthDate = $(creditCardMtsCashback.getATTENTION_TEXT()).shouldBe(visible, Duration.ofSeconds(30));

        assertEquals("Возраст клиента должен быть не менее 20 лет", attentionBirthDate.getText());
    }

    @Step("Проверить некорректный ввод почты")
    public void checkInvalidEmailAttention(CreditCardMtsCashback creditCardMtsCashback){
        SelenideElement attentionEmail = $(creditCardMtsCashback.getATTENTION_TEXT()).shouldBe(visible, Duration.ofSeconds(30));

        assertEquals("Введите верный электронный адрес", attentionEmail.getText());
    }

    @Step("Проверка ожидания смс на телефон")
    public void checkSuccesGetCard(CreditCardMtsCashback creditCardMtsCashback){
        String smsText = $(creditCardMtsCashback.getCONFIRM_PHONE_NUMBER()).shouldBe(visible, Duration.ofSeconds(30)).getText();

        assertEquals("Подтвердите номер телефона", smsText);
    }
}
