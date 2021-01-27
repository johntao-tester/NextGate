Feature: Verify Apps in homePage

  @VerifyAppsInHomePage
  Scenario: Verify Applications
    Given user is on NextGate login page
    When user inputs valid userName
    And user inputs valid password
    And user clicks login button
    And user should see message "Welcome" in homePage
    Then user should see that apps are available
      | appName              |
      | Data Quality Manager |
      | Codeset Manager      |
      | REST API Toolkit     |
    And user logs out
