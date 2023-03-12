Feature: Login Test - The user should be able to login with valid credentials

  Background: Go to home page login
    Given The user is on the login page

  @loginWithoutParameters
  Scenario: Positive Scenario 1 - user shold be able to login
    Given The user is on the login page
    When The user enters valid credentials
    Then Verify "Welcome zafer"


  @loginWithParameters
  Scenario: Positive Scenario 2 - user should be able to login
    When The user enters "zafer" and "123456789" and click login button
    Then Verify "Welcome zafer"

  @LoginWithSceneraioOutline
  Scenario Outline: Positive Scenario 3 - user should be able to login
    When The user enters "<username>" and "<password>" and click login button
    Then Verify "<messageWelcome>"

    Examples:
      | username | password  | messageWelcome |
      | zafer    | 123456789 | Welcome zafer  |


  @WithDataTable
  Scenario Outline: Positive Scenario 4 - user should be able to login

    When The user enters valid username and password
      | username | <user>     |
      | password | <password> |
    Then Verify "<messageWelcome>"

    Examples:
      | user         | password  | messageWelcome       |
      | zafer        | 123456789 | Welcome zafer        |
      | KayitOlArtik | 123456AA  | Welcome KayitOlArtik |



