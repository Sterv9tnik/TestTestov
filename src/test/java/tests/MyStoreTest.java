package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class MyStoreTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://homebrandofficial.ru/wear");
    }

//    @Test
    public void test() throws InterruptedException {
        String productName = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";
        String productCost = "2 800";
        driver.findElement(By.cssSelector(".t-store__search-wrapper input")).sendKeys(productName);
        driver.findElement(By.cssSelector(".t-store__search-icon")).click();

        sleep(1000);
        int productCount = Integer.parseInt(driver.findElement(By.cssSelector(".js-store-filters-prodsnumber")).getText());
        String actualProductName = driver.findElement(By.cssSelector(".js-store-prod-name")).getText();
        String actualProductCost = driver.findElement(By.cssSelector(".t-store__card__price .js-product-price")).getText();

        assertEquals(1, productCount);
        assertEquals(productName, actualProductName);
        assertEquals(productCost, actualProductCost);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
