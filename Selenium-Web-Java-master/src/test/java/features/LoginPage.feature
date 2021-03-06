@LoginPageTestCases
Feature: Controlling login page test cases

  Background: Navigate to  Login page
    Given User expects the title of the page contains "https://www.fedex.com/en-gb/home.html"
    When User clicks close button for popUP
    When User accepts cookies
    Then User expects element "SignUp" displayed
    And User clicks "SignInLogin" button
    And User clicks loginIn "LogIn" button
    Given User expects the title of the login page url contains "https://www.fedex.com/secure-login/en-gb/#/login-credentials"
    Then User should see "Enter your user ID and password to log in" message

   @CREATEAUSERIDFORANEXISTINGACCOUNTLINK
    Scenario: Checking CREATE A USER ID FOR AN EXISTING ACCOUNT link
     Given User expects element "create user id for existing account" link displayed
     When User clicks "create user id for existing account" link
     Then user expects the title of existing account url contains "https://www.fedex.com/fcl/web/jsp/contactInfo.jsp?appName=fclfsm&locale=gb_en&step3URL=https%3A%2F%2Fwww.fedex.com%2Fship%2FshipEntryAction.do%3Fmethod%3DdoRegistration%26link%3D1%26locale%3Dgb_gb%26urlparams%3Din%26sType%3DF&afterwardsURL=https%3A%2F%2Fwww.fedex.com%2Fship%2FshipEntryAction.do%3Fmethod%3DdoEntry%26link%3D1%26locale%3Den_gb%26urlparams%3Din%26sType%3DF&programIndicator=0"

   @ControllinguserIDDandPasswordArea
   Scenario: Checking userid/password/RememberUserId/loginButton and click login button check messgae
     Given User expects element "userIDArea" id area exist
     Given User expects element "passwordArea" password area exist
     Given User expects element "RememberMyUserId" area exist
     Given User expects element "loginButton" button exist
     And User clicks "loginIn" button to see warning message
     Then user expects to see warning message "Both user ID and password are required to log in."

   @EmptyIDWithWrongPassword
   Scenario: enter password without ID and checking warning message
     Given User writes "123addfgrt" password to password area
     And User clicks "loginIn" button to see warning message
     Then user expects to see warning message "Both user ID and password are required to log in."

  @EmptyPasswordWithWrongId
  Scenario Outline: enter Id without password and checking warning message
    Given User writes "<Id>" Id to Id area
    And User clicks "loginIn" button to see warning message
    Then user expects to see warning message "<warningMessage>"
    Examples:
      | Id                          | warningMessage                                    |
      | a@b@c.com                   | Both user ID and password are required to log in. |
      | test@domaincom              | Both user ID and password are required to log in. |
      | ab(c)defgi[j\k]l;!          | Both user ID and password are required to log in. |

  @CorrectUserNamePasswordd
  Scenario: enter correct password and email
    Given User writes "testuserfedex@gmail.com" Id to Id area
    Given User writes "123123Tek" password to password area
    And User clicks "loginIn" button to login
    And "6000" wait milliseconds
    And user clicks "remind me later" button
    #There are an error on website thats why last THEN steps doesnt work
    Then User expects to see name "FF" placed loginButton