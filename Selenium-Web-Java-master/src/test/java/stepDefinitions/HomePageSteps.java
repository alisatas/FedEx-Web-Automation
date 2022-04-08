package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import util.DriverFactory;

public class HomePageSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Then("User expect the title of the page contains {string}")
    public void iExpectTheTitleOfThePageContains(String title) throws InterruptedException {
        homePage.checkURLContains(title);
    }

    @Given("^\"([^\"]*)\" wait milliseconds$")
    public void waitMilliseconds(long waitMilliseconds) {
        homePage.waitByMilliSeconds(waitMilliseconds);
    }

    @Given("User expect element {string} displayed")
    public void userExpectElementDisplayed(String key) {
        homePage.elementDisplayed(key);
    }

    @When("User clicks {string} button")
    public void userClicksButton(String loginButton) {
        homePage.clickLoginButton(loginButton);
    }

    @Then("user should see {string} after click login button")
    public void userShouldSeeRestaurantOnFavoritePage(String options) {
        homePage.checkOptionsOnLoginMenu(options);
    }

    @And("User clicks loginIn {string} button")
    public void userClicksLoginInButton(String loginAsFirstOption) {
        homePage.clickLoginButtonAsFirstOption(loginAsFirstOption);
    }

    @Given("User expect to see {string} chatbot")
    public void userExpectToSeeChatbot(String chatBot) {
        homePage.chatBotDisplayed(chatBot);
    }

    @When("User click {string} chat bot")
    public void userClickChatBot(String clickChatBot) {
        homePage.clickChatBot(clickChatBot);
    }

    @Then("User expect to see {string} assistant answer")
    public void userExpectToSeeAssistantAnswer(String answer) {
        homePage.checkAnswerContains(answer);
    }

    @When("User accept cookies")
    public void userAcceptCookies() throws InterruptedException {
        homePage.acceptCookiesPopUp();
    }

    @When("User clicks close button for popUP")
    public void userClicksCloseButtonForPopUP() throws InterruptedException {
        homePage.closePopUp();
    }

    @And("User writes text to assistant {string}")
    public void userWritesTextToAssistant(String sendMessage) {
        homePage.sendMessageToBot(sendMessage);
    }

    @Then("User controls if text is sent {string}")
    public void userControlsIfTextIsSent(String controlMessage) {
        homePage.controlSentMessage(controlMessage);
    }

    @And("User click submit button")
    public void userClickSubmitButton() throws InterruptedException {
        homePage.clickSubmitButton();
    }

    @Given("User expect element search button {string} displayed")
    public void userExpectElementSearchButtonDisplayed(String searchButtonDisplayed) {
        homePage.searchButtonDisplayed(searchButtonDisplayed);
    }

    @And("User expect element search area text {string} displayed")
    public void userExpectElementSearchAreaTextDisplayed(String searchArea) {
        homePage.searchAreaDisplayed(searchArea);
    }

    @When("User writes text {string} to search area")
    public void userWritesTextToSearchArea(String trackingID) {
        homePage.searchWordSearchingArea(trackingID);
    }

    @Then("User controls if searched text {string} is on page")
    public void userControlsIfSearchedTextIsOnPage(String searchedID) {
        homePage.controlSearchedText(searchedID);
    }

    @When("User click searchICon")
    public void userClickSearchICon() throws InterruptedException {
        homePage.clickSearchButton();
    }

    @Given("User expect element Track button {string} displayed")
    public void userExpectElementTrackButtonDisplayed(String trackButton) {
        homePage.trackButtonIsDisplayed(trackButton);
    }

    @When("user enter invalid {string} number to tracking")
    public void userEnterInvalidNumberToTracking(String invalidTrackID) {
        homePage.writeInvalidTrackID(invalidTrackID);
    }

    @Then("User expect to see warning message {string}")
    public void userExpectToSeeWarningMessage(String invalidMessage) {
        homePage.controlMessageForInvalid(invalidMessage);
    }

    @And("User clicks track button")
    public void userClicksTrackButton() throws InterruptedException {
        homePage.clickTrackButton();
    }
}

