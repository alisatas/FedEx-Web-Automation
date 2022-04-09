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
#
  @SendingTextToBot
  Scenario: User tries to send answer to assistant bot
    When User click "chatBot" chat bot
    Given "2000" wait milliseconds
    And User expect to see "Hello, I'm the FedEx Virtual Assistant. I'm here to help you with your questions regarding FedEx services." assistant answer
    And User writes text to assistant "Hi I need help"
    And User click submit button
    Then User controls if text is sent "You: Hi I need help"

  @SearchingWithSearchArea
  Scenario: User uses search area to search needs
    Given User expect element search button "searchIcon" displayed
    When User click searchICon
    And User expect element search area text "searcArea" displayed
    When User writes text "tracking" to search area
    When "1000" wait milliseconds
    When User click searchICon
    Then User controls if searched text "tracking" is on page

  @ControllingTrackIDArea
  Scenario: Users try to search invalid TrackID
    Given User expect element Track button "TRACK" displayed
    When user enter invalid "random tracking IDD" number to tracking
    And User clicks track button
    Then User expect to see warning message "Unfortunately, we are unable to retrieve your tracking results at this time. Please try again later."











