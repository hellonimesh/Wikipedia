package WikiStepsDefinations;

import Util.TestBase;
import WikiPages.LandingPage;
import WikiPages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchPageStepDefination extends TestBase {

    //  All the steps definations are created as a one liner to make code neat, clean and readable.
    //  All methods are defined in seperate Pages relevant to their Page specific functionalities

    @Then("^User see \"(.*)\" on Search Result Page$")
    public void userCanSeeRelevantResultsOnSearchPage(String keyword) {
        SearchPage.validate_Search_String(keyword);
    }

    @Then("^User can validate that the first heading of the search results page matches the search string \"(.*)\" - ignoring case$")
    public void userCanValidateThatTheFirstHeadingOfTheSearchResultsPageMatchesTheSearchStringIgnoringCase(String keyword) throws Throwable {
        SearchPage.validate_Search_String_Ignoring_Case(keyword);
    }

    @And("^User verify that the search results page is available in other languages$")
    public void userCanVerifyThatTheSearchResultsPageIsAvailableInOtherLanguages() {
        SearchPage.validating_Other_Language_Option_Available();

    }

    @And("^User verify that there are more then one language available on Search Result Page$")
    public void userCanVerifyThatThereAreMoreThenOneLanguageAvailableOnSearchResultPage() {
        SearchPage.validate_More_Then_One_Language_Available();
    }

    @And("^User navigate back$")
    public void userCanNavigateBack() {
        SearchPage.navigate_back();
    }

    @And("^User quite the browser$")
    public void userCanQuiteTheBrowser() {
        quite_browser();
    }

    @Given("^User is on Search Result Page of the word \"(.*)\"$")
    public void userIsOnSearchResultPageOfTheWord(String keyword) throws Throwable {
        TestBase.browser_initialization();
        LandingPage.searchForKeyword(keyword);
    }

    @And("^User verify that there is an English language option on Search result page$")
    public void userVerifyThatThereIsAnEnglishLanguageOptionOnSearchResultPage() {
        SearchPage.verify_english_language_link_available();
    }
}
