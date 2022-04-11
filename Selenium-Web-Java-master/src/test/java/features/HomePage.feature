@HomePageTestCases
Feature: Checking login page test cases

  Background: Checking SignUp button
    Given "1000" wait milliseconds
    Given User expects the title of the page contains "https://www.fedex.com/en-gb/home.html"
    When User clicks close button for popUP
    When User accepts cookies

  @ControlLoginButtonOptions
  Scenario Outline:Checking loginOptions
    Given User expects element "SignUp" displayed
    When User clicks "SignInLogin" button
    Then user should see "<options>" after click login button
    Examples:
      | options |
      |LOG IN|
      |CREATE USER ID (FOR EXISTING CUSTOMERS)|
      |OPEN AN ACCOUNT|

  @ControlChatBotArea
  Scenario: Clicking chat button and check if user see assistant
    Given User expects to see "chatBot" chatbot
    When User clicks "chatBot" chat bot
    Then User expects to see "Hello, I'm the FedEx Virtual Assistant. I'm here to help you with your questions regarding FedEx services." assistant answer

  @SendingTextToBot
  Scenario: User tries to send answer to assistant bot
    When User clicks "chatBot" chat bot
    Then User expects to see "Hello, I'm the FedEx Virtual Assistant. I'm here to help you with your questions regarding FedEx services." assistant answer
    And User writes text to assistant "Hi I need help"
    And User clicks submit button
    Then User checks if text is sent "You: Hi I need help"


  @SearchingWithSearchArea
  Scenario: User uses search area to search needs
    Given User expects element search button "searchIcon" displayed
    When User clicks searchICon
    And User expects element search area text "searcArea" displayed
    When User writes text "tracking" to search area
    When "1000" wait milliseconds
    When User clicks searchICon
    Then User checks if searched text "tracking" is on page

  @ControllingTrackIDArea
  Scenario: User tries to search invalid TrackID
    Given User expects element Track button "TRACK" displayed
    When user enters invalid "random tracking IDD" number to tracking
    And User clicks track button
    Then User expects to see warning message "Unfortunately, we are unable to retrieve your tracking results at this time. Please try again later."