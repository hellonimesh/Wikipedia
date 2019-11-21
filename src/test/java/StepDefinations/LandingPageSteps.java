package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageSteps {

        WebDriver driver = new ChromeDriver();

    @Given("^I am on wiki landing page$")
    public void iAmOnWikiLandingPage() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Users/nsoni/iCloud Drive/Desktop/Wikipedia/chromedriver");
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        driver.quit();
    }

    @When("^I enter Selenium in search field$")
    public void iEnterSeleniumInSearchField() {
    }
}

