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
        homePage.checkURLContains(title);}

    @Given("^\"([^\"]*)\" wait milliseconds$")
    public void waitMilliseconds(long waitMilliseconds) { homePage.waitByMilliSeconds(waitMilliseconds);}

    @Given("User expect element {string} displayed")
    public void userExpectElementDisplayed(String key) {
        homePage.elementDisplayed(key);
        }

    @When("User clicks {string} button")
    public void userClicksButton(String loginButton){
        homePage.clickLoginButton(loginButton);
    }

    @Then("user should see {string} after click login button")
    public void userShouldSeeRestaurantOnFavoritePage(String options) {
        homePage.checkOptionsOnLoginMenu(options);
    }

    @And("User clicks loginIn {string} button")
    public void userClicksLoginInButton(String loginAsFirstOption){ homePage.clickLoginButtonAsFirstOption(loginAsFirstOption); }

    @Given("User expect to see {string} chatbot")
    public void userExpectToSeeChatbot(String chatBot) {
        homePage.chatBotDisplayed(chatBot);
    }

    @When("User click {string} chat bot")
    public void userClickChatBot(String clickChatBot) { homePage.clickChatBot(clickChatBot);}

    @Then("User expect to see {string} assistant answer")
    public void userExpectToSeeAssistantAnswer(String answer) {
        homePage.checkAnswerContains(answer);
    }

    @When("User accept cookies")
    public void userAcceptCookies() { homePage.acceptCookiesPopUp();}

    @When("User clicks close button for popUP")
    public void userClicksCloseButtonForPopUP() { homePage.closePopUp(); }

    @And("User writes text to assistant {string}")
    public void userWritesTextToAssistant(String sendMessage) {
        homePage.sendMessageToBot(sendMessage);
    }

    @Then("User controls if text is sent {string}")
    public void userControlsIfTextIsSent(String controlMessage) {
        homePage.controlSentMessage(controlMessage);
    }
}

