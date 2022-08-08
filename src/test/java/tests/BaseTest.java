package tests;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub";
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        //Configuration.browserCapabilities = capabilities;
    }
}
