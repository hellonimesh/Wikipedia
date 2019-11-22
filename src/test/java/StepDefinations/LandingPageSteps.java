package StepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LandingPageSteps {

    WebDriver driver = new ChromeDriver();

    @Given("^should be able to navigate to wiki landing page$")
    public void iAmOnWikiLandingPage() {
        System.setProperty("webdriver.chrome.driver", "//Users//nsoni//iCloud Drive//Desktop//Wikipedia//chromedriver");
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^I type in any string \"(.*)\" in search field using English as a language$")
    public boolean i_enter_Selenium_in_search_field(String keyword) {

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(keyword);
        WebElement language = driver.findElement(By.id("searchLanguage"));
        Select select = new Select(language);
        select.selectByValue("en"); // Selecting English language
        searchBox.submit();

        //Verify that first search page is the mathches the search string

        WebElement firstElement = driver.findElement(By.id("firstHeading"));
        assertTrue(keyword.equalsIgnoreCase(firstElement.getText())); // 3.	Validate that the first heading of the search results page matches the search string (ignoring case).

        //4.	Verify that the search results page is available in other languages

        WebElement languageOption = driver.findElement(By.id("p-lang-label"));
//        String languageAvailable = "Languages";
//        String text = languageOption.getAttribute("innerText");
        if (languageOption.getAttribute("innerText").equals("Languages")) {

            return true;
        }

        return false;
    }

    @Then("^I should be able to see relevant search result based on the string I entered$")
    public boolean iShouldSeeRelevantSearchResult() {
        // Verif that there are more then one language available

        WebElement parentElementOfLanguage = driver.findElement(By.id("p-lang"));

        List<WebElement> childElements = parentElementOfLanguage.findElements(By.tagName("li"));

        int count = childElements.size();
        if (count > 1) {
            return true;
        }
        return false;
    }

    @When("^I navigate back$")
    public void iNavigateBack() {
        driver.navigate().back();
    }

    @And("^I search using \"(.*)\" in \"(.*)\" language$")
    public void i_search_using_Selenium_in_Cymraeg_language(String keyword, String language) {
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(keyword);
        WebElement languageElement = driver.findElement(By.id("searchLanguage"));
        Select select = new Select(languageElement);
        select.selectByVisibleText(language); // Selecting English language
        searchBox.submit();
    }


}