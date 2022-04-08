package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By text_enterUserIDPassword = By.xpath("//*[contains(text(),' Enter your user ID and password to log in ')]");
    private By link_createUserExistingAcount = By.id("createUserId");
    private By text_userId = By.id("userId");
    private By text_password = By.id("password");
    private By checkbox_rememberMyID = By.id("checkBoxLabel");
    private By button_login = By.id("login-loading-btn");
    private By warningMessageLoginPage = By.xpath("//*[contains(text(),' Both user ID and password are required to log in. ')]");
    private By button_remindMeLater = By.id("cancelBtn");
    private By button_userIDArea = By.cssSelector(".fxg-user-options__sign-in-text.sessioncamhidetext");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void enterUserPassword(String enterPassowrID) {elementUtil.getText(text_enterUserIDPassword, enterPassowrID);}

    public void checkLoginPageURL(String url) throws InterruptedException {
        Thread.sleep(5000);
        elementUtil.checkURLContains(url);
    }

    public void createUserExistingAccount(String existingaccount) {elementUtil.elementIsDisplayed(link_createUserExistingAcount, existingaccount);}

    public void clickCreateExistingAccount(String existingAccount) {elementUtil.click(link_createUserExistingAcount, existingAccount);}

    public void checkExistingAccountURL(String existingAccountUrl) throws InterruptedException {elementUtil.checkURLContains(existingAccountUrl);}

    public void checkIdAreaExist(String idAreaDisplayed) {elementUtil.elementIsDisplayed(text_userId, idAreaDisplayed);}

    public void checkPasswordAreaExist(String passwordAreaDisplayed) {elementUtil.elementIsDisplayed(text_password, passwordAreaDisplayed);}

    public void checkRememberIdExist(String rememberID) {elementUtil.elementIsDisplayed(checkbox_rememberMyID, rememberID);}

    public void checkLoginButton(String loginButton) {
        elementUtil.elementIsDisplayed(button_login, loginButton);
    }

    public void clickToLoginButton(String clickLogin) {elementUtil.click(button_login, clickLogin);}

    public void checkWarningMessageLoginArea(String checkMessage) {elementUtil.getText(warningMessageLoginPage, checkMessage);}

    public void writePassword(String writePassword) {
        elementUtil.sendKey(text_password, writePassword);
    }

    public void writeId(String writeId) {elementUtil.sendKey(text_userId, writeId);}

    public void clickRemindMeLater(String remindMeLater) {elementUtil.click(button_remindMeLater, remindMeLater);}

    public void checkUserIDArea(String accountName) {
        elementUtil.getText(button_userIDArea, accountName);
    }

    public void succesfullLogin(String loginButtonToLogin) {
        elementUtil.click(button_login, loginButtonToLogin);
    }
}
