Feature: Test Data Quality Manager App
  I will perform a person demographic search on Liz Smith,
  I will perform EUID search,
  lastly will test potential duplicate search.

  Background:
    Given user is on NextGate login page
    When user inputs valid userName
    And user inputs valid password
    And user clicks login button
    And clicks on Data Quality Manager app
    And user logs out


  @SelectDQMAndSearchLizSmith
  Scenario: Select DQM and perform demographic search on Liz Smith
    When performs a person demographic search on patient's full name
      | firstname | lastname |
      | Liz       | Smith    |
    Then user should see records contained patient's name with EUID number
      | EUID       | fullname        |
      | 1000004798 | elizabeth smith |
    And user logs out



  @PickEuidAndDoEuidSearch
  Scenario: Pick EUID from list and do an EUID search
    When performs a person demographic search on patient's full name
      | firstname | lastname |
      | Liz       | Smith    |
    And user selects Person ID from search type
    And user inputs EUID from records
    Then user should be able to access records by validating page URL "http://44.224.32.250:8181/web/#/dqm-app/person/details/1000004798/general"
    And user should be able to get record details
      | fullname        | ID         | dob        | phone          | address                                          |
      | ELIZABETH SMITH | 1000004798 | 09/06/1916 | (303) 458-2385 | 267 KITTIWAKE CIRCLE IMPERIAL Pennsylvania 15126 |
    And user should be able to read all available demographics
      | firstname | lastname | ssn         | dob        |
      | ELIZABETH | SMITH    | 446-37-1173 | 09/06/1916 |
    And user logs out


  @PotentialDuplicateSearch
  Scenario: Potential duplicate search
    When user selects Person Potential Duplicates
    And user clicks search
    Then user should be abe to see "Showing 100 potential duplicate groups"
    And user logs out



  @CompareScreen
  Scenario: Potential duplicate search, picking dup group, and ho to compare screen
    When user selects Person Potential Duplicates
    And user clicks search
    And picks a potential dup group
    Then user can compare potential duplicates
    And user can navigate through page
    And user logs out



