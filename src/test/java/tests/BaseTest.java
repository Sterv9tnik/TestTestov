package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        WebDriverManager.chromedriver().driverVersion("103").setup();
        System.setProperty("chromeoptions.args", "--no-sandbox");
        Configuration.browser = "chrome";
        Configuration.headless = true;
        //Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub";
/*        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;*/
    }
}
