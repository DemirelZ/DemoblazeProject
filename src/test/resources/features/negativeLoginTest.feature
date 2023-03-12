Feature: Negative Login Test - The user should NOT be able to login with invalid credentials

  Background: Go to home page login
    Given The user is on the login page

    @negativeLoginTest
  Scenario Outline: Negative scenerio - the user should NOT be able to login with invalid credentials
    When The user enters "<invalidUsername>" and "<invalidPassword>" and click login button
    Then Verify that invalid "<invalidMessage>"


    Examples:
      | invalidUsername | invalidPassword | invalidMessage                         |
      | zafer           |                 | Please fill out Username and Password. |
      |                 | 123456789       | Please fill out Username and Password. |
      |                 | wrongpassword   | Please fill out Username and Password. |
      | wrongusername   | 123456789       | User does not exist.                   |
      | zafer           | wrongpassword   | Wrong password.                        |
      |                 |                 | Please fill out Username and Password. |
