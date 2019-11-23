package WikiPages;

import Util.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends TestBase {

    public static void validatePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Wikipedia", title);
    }

    public static void selectLanguage(String language) {
        WebElement languageOption = driver.findElement(By.id("searchLanguage"));
        languageOption.click();
        Select select = new Select(languageOption);
        select.selectByValue(language);
        languageOption.click();
    }

    public static void searchForKeyword(String keyword) {
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }
}
