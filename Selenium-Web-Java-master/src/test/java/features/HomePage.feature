@HomePageTestCases
Feature: Controlling login page test cases

  Background: Controlling SignUp button
    Given "1000" wait milliseconds
    Given User expect the title of the page contains "https://www.fedex.com/en-gb/home.html"
    When User clicks close button for popUP
    When User accept cookies

  @ControlLoginButtonOptions
    Scenario Outline:Controlling loginOptions
    Given User expect element "SignUp" displayed
    When User clicks "SignInLogin" button
    Then user should see "<options>" after click login button
    Examples:
      | options |
      |LOG IN|
      |CREATE USER ID (FOR EXISTING CUSTOMERS)|
      |OPEN AN ACCOUNT|

  @ControlChatBotArea
  Scenario: Clicking chat button and control if user see assistant
    Given User expect to see "chatBot" chatbot
    When User click "chatBot" chat bot
    Given "2000" wait milliseconds
    Then User expect to see "Hello, I'm the FedEx Virtual Assistant. I'm here to help you with your questions regarding FedEx services." assistant answer







