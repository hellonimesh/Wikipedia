package WikiStepsDefinations;

import Util.TestBase;
import WikiPages.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

//  All the steps definations are created as a one liner to make code neat, clean and readable.
//  All methods are defined in seperate Pages relevant to their Page specific functionalities

public class LandingPageStepDefination extends TestBase {

    @Given("^User opens browser$")
    public void user_Opens_Browser() {
        TestBase.browser_initialization();
    }

    @When("^User is on Landing Page$")
    public void user_Is_On_Landing_Page() {
        LandingPage.validatePageTitle();
    }

    @When("^User select \"(.*)\" as a Language$")

    public void user_Select_Language(String language) {
        LandingPage.selectLanguage(language);
    }

    @When("^User enter any keyword like \"(.*)\"$")
    public void user_Enter_Keyword(String keyword) {
        LandingPage.searchForKeyword(keyword);
    }
}
