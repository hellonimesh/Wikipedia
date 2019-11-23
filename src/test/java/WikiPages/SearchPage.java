package WikiPages;

import Util.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends TestBase {

    // Validate that the title of the search results page containing the search string
    public static void validate_Search_String(String keyword) {
        String title = driver.getTitle();
        Assert.assertTrue("Selenium - Wikipedia", title.contains(keyword));
    }

    // Validate that the first heading of the search results page matches the search string (ignoring case).
    public static void validate_Search_String_Ignoring_Case(String keyword) {
        WebElement firstElement = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue(keyword.equalsIgnoreCase(firstElement.getText()));
    }

    public static void validating_Other_Language_Option_Available() {

        WebElement languageOption = driver.findElement(By.id("p-lang-label"));
        Assert.assertEquals("Languages", languageOption.getAttribute("innerText"));
    }

    public static void validate_More_Then_One_Language_Available() {

        WebElement parentElementOfLanguage = driver.findElement(By.id("p-lang"));
        List<WebElement> childElements = parentElementOfLanguage.findElements(By.tagName("li"));

        int count = ((List) childElements).size();
        Assert.assertTrue(count > 1);
    }

    public static void navigate_back() {
        driver.navigate().back();
    }

    public static void verify_english_language_link_available() {
        WebElement language = driver.findElement(By.linkText("English"));
        language.click();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Earth"));
    }
}