package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import util.DriverFactory;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());


    @Then("User should see {string} message")
    public void userShouldSeeMessage(String enterPassowrID) {
        loginPage.enterUserPassword(enterPassowrID);
    }

    @Given("User expects the title of the login page url contains {string}")
    public void userExpectTheTitleOfTheLoginPageContains(String url) throws InterruptedException {loginPage.checkLoginPageURL(url);}

    @Given("User expects element {string} link displayed")
    public void userExpectElementCreateUserIdForExistingAccountLinkDisplayed(String existingaccount) {loginPage.createUserExistingAccount(existingaccount);}

    @When("User clicks {string} link")
    public void userClickLink(String existingAccount) throws InterruptedException {loginPage.clickCreateExistingAccount(existingAccount);}

    @Then("user expects the title of existing account url contains {string}")
    public void userExpectTheTitleOfExistingAccountUrlContains(String existingAccountUrl) throws InterruptedException {loginPage.checkExistingAccountURL(existingAccountUrl);}

    @Given("User expects element {string} id area exist")
    public void userExpectElementIdAreaExist(String idAreaDisplayed) {
        loginPage.checkIdAreaExist(idAreaDisplayed);
    }

    @Given("User expects element {string} password area exist")
    public void userExpectElementPasswordAreaExist(String passwordAreaDisplayed) {loginPage.checkPasswordAreaExist(passwordAreaDisplayed);}

    @Given("User expects element {string} area exist")
    public void userExpectElementAreaExist(String rememberID) {
        loginPage.checkRememberIdExist(rememberID);
    }

    @Given("User expects element {string} button exist")
    public void userExpectElementButtonExist(String loginButton) {
        loginPage.checkLoginButton(loginButton);
    }

    @And("User clicks {string} button to see warning message")
    public void userClicksButtonToSeeWarningMessage(String clickLogin) throws InterruptedException {
        loginPage.clickToLoginButton(clickLogin);
    }

    @Then("user expects to see warning message {string}")
    public void userExpectToSeeWarningMessage(String checkMessage) {loginPage.checkWarningMessageLoginArea(checkMessage);}

    @Given("User writes {string} password to password area")
    public void userWritePasswordToPasswordArea(String writePassword) {loginPage.writePassword(writePassword);}

    @Given("User writes {string} Id to Id area")
    public void userWriteEmailToEmailArea(String writeId) {loginPage.writeId(writeId);}

    @And("user clicks {string} button")
    public void userClickButton(String remindMeLater) throws InterruptedException {
        loginPage.clickRemindMeLater(remindMeLater);
    }

    @Then("User expects to see name {string} placed loginButton")
    public void userExpectToSeeNamePlacedLoginButton(String accountName) {loginPage.checkUserIDArea(accountName);}

    @And("User clicks {string} button to login")
    public void userClicksButtonToLogin(String loginButtonToLogin) throws InterruptedException {
        loginPage.succesfullLogin(loginButtonToLogin);
    }
}
