package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().driverVersion("104").setup();
        System.setProperty("chromeoptions.args", "--no-sandbox");
        Configuration.browser = "chrome";
        Configuration.headless = true;
        //Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub";
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        //Configuration.browserCapabilities = capabilities;
    }
}
