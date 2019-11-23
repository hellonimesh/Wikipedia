Feature: Landing Page functionality validation - Wikipedia

  Scenario: User should be able to perform various operation on Wikipedia Landing Page
    Given User opens browser
    When User is on Landing Page
#    en = English language
    When User select "en" as a Language
    When User enter any keyword like "Selenium"
    Then User see "Selenium" on Search Result Page
    And User quite the browser

  Scenario: User should be able to perform various test on Search Page
    Given User is on Search Result Page of the word "Cucumber"
    Then User can validate that the first heading of the search results page matches the search string "Cucumber" - ignoring case
    And User verify that the search results page is available in other languages
    And User verify that there are more then one language available on Search Result Page
    And User quite the browser

  Scenario: User should be able to perform other tests on Search Page like navigate back and more
    Given User is on Search Result Page of the word "London"
    When  User navigate back
    Then User is on Landing Page
#    hi = Hindi language
    When User select "hi" as a Language
    When User enter any keyword like "पृथ्वी"
    Then User see "पृथ्वी" on Search Result Page
    And User quite the browser




