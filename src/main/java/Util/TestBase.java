package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    private static Properties prop;

     // Constructor who initializ the prop object and exception handelling
     // Here I consider only Chrome Browser as a scope of the test
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/nsoni/iCloud Drive/Desktop/Wikipedia/src/main/java/Config/config.properties");
            prop.load(fis);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void browser_initialization() {

        String browserName = prop.getProperty("chrome");
        System.setProperty("webdriver.chrome.driver", "/Users/nsoni/iCloud Drive/Desktop/Wikipedia/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    protected static void quite_browser() {
        driver.quit();
    }
}
