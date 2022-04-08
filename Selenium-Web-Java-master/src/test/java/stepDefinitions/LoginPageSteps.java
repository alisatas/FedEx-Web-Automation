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

    @Given("User expect the title of the login page url contains {string}")
    public void userExpectTheTitleOfTheLoginPageContains(String url) throws InterruptedException {loginPage.checkLoginPageURL(url);}

    @Given("User expect element {string} link displayed")
    public void userExpectElementCreateUserIdForExistingAccountLinkDisplayed(String existingaccount) {loginPage.createUserExistingAccount(existingaccount);}

    @When("User click {string} link")
    public void userClickLink(String existingAccount) {loginPage.clickCreateExistingAccount(existingAccount);}

    @Then("user expect the title of existing account url contains {string}")
    public void userExpectTheTitleOfExistingAccountUrlContains(String existingAccountUrl) throws InterruptedException {loginPage.checkExistingAccountURL(existingAccountUrl);}

    @Given("User expect element {string} id area exist")
    public void userExpectElementIdAreaExist(String idAreaDisplayed) {
        loginPage.checkIdAreaExist(idAreaDisplayed);
    }

    @Given("User expect element {string} password area exist")
    public void userExpectElementPasswordAreaExist(String passwordAreaDisplayed) {loginPage.checkPasswordAreaExist(passwordAreaDisplayed);}

    @Given("User expect element {string} area exist")
    public void userExpectElementAreaExist(String rememberID) {
        loginPage.checkRememberIdExist(rememberID);
    }

    @Given("User expect element {string} button exist")
    public void userExpectElementButtonExist(String loginButton) {
        loginPage.checkLoginButton(loginButton);
    }

    @And("User clicks {string} button to see warning message")
    public void userClicksButtonToSeeWarningMessage(String clickLogin) {
        loginPage.clickToLoginButton(clickLogin);
    }

    @Then("user expect to see warning message {string}")
    public void userExpectToSeeWarningMessage(String checkMessage) {loginPage.checkWarningMessageLoginArea(checkMessage);}

    @Given("User write {string} password to password area")
    public void userWritePasswordToPasswordArea(String writePassword) {loginPage.writePassword(writePassword);}

    @Given("User write {string} Id to Id area")
    public void userWriteEmailToEmailArea(String writeId) {loginPage.writeId(writeId);}

    @And("user click {string} button")
    public void userClickButton(String remindMeLater) {
        loginPage.clickRemindMeLater(remindMeLater);
    }

    @Then("User expect to see name {string} placed loginButton")
    public void userExpectToSeeNamePlacedLoginButton(String accountName) {loginPage.checkUserIDArea(accountName);}

    @And("User clicks {string} button to login")
    public void userClicksButtonToLogin(String loginButtonToLogin) {
        loginPage.succesfullLogin(loginButtonToLogin);
    }
}
