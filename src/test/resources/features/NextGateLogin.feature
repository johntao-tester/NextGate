Feature: Test NextGate MatchMetrix software
  Testing login and home page

  Background:
    Given user is on NextGate login page

  @loginWithValidCredentials
  Scenario: Login with valid credentials
    When user inputs valid userName
    And user inputs valid password
    And user clicks login button
    Then user should see message "Welcome" in homePage
    And user logs out


  @loginWithWrongPassword
  Scenario: Login using valid userName and invalid password
    When user inputs valid userName
    And user inputs invalid password "password"
    Then user should see "The username or password is invalid."

  @loginWithWrongUsername
  Scenario: Login using invalid username and valid password
    When user input invalid userName "username"
    And user inputs valid password
    Then user should see "The username or password is invalid."













