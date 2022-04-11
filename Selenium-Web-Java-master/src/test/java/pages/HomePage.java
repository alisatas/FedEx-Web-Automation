package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class HomePage {

    private WebDriver driver;
    private ElementUtil elementUtil;
    private By button_acceptCookies = By.xpath("(//*[contains(text(),'ACCEPT ALL COOKIES')])[2]");
    private By button_SignUpLogin = By.xpath("//*[contains(text(),'Sign Up/Log In ')]");
    private By button_closePopUp = By.xpath("//*[@title='close']");
    private By text_loginOptions = By.cssSelector(".wlgnlink-class.bound");
    private By button_login = By.xpath("(//*[contains(text(),'Log In')])[2]");
    private By button_chatBot = By.xpath("(//*[@class='va_icon'])[1]");
    private By text_botAnswer = By.cssSelector(".nw_Welcome");
    private By text_sendMessageArea = By.cssSelector(".nw_UserInputField");
    private By text_firstCustomerMessage = By.xpath("(//*[@class='nw_UserSays'])[1]");
    private By button_submit = By.cssSelector(".nw_UserSubmit");
    private By button_searchIcon = By.xpath("(//*[@alt='Search'])[1]");
    private By text_searchArea = By.id("fxg-search-text");
    private By text_searchText = By.xpath("(//*[@class='search-text'])[2]");
    private By button_trackID = By.id("btnSingleTrack");
    private By text_trackingID = By.xpath("//*[@name='trackingnumber']");
    private By text_invalidMessage = By.cssSelector(".notification.notification--error");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void waitByMilliSeconds(long waitMilliseconds) {
        elementUtil.waitByMilliSeconds(waitMilliseconds);
    }

    public void elementDisplayed(String key) {
        elementUtil.elementIsDisplayed(button_SignUpLogin, key);
    }

    public void checkURLContains(String title) throws InterruptedException {elementUtil.checkURLContains(title);}

    public void clickLoginButton(String loginButton) throws InterruptedException {elementUtil.click(button_SignUpLogin, loginButton);}

    public void checkOptionsOnLoginMenu(String options) {elementUtil.checkTextFromElements(text_loginOptions, options);}

    public void clickLoginButtonAsFirstOption(String loginAsFirstOption) throws InterruptedException {elementUtil.click(button_login, loginAsFirstOption);}

    public void chatBotDisplayed(String chatBot) {
        elementUtil.elementIsDisplayed(button_chatBot, chatBot);
    }

    public void clickChatBot(String clickChatBot) throws InterruptedException {elementUtil.click(button_chatBot, clickChatBot);}

    public void checkAnswerContains(String answer) {elementUtil.getText(text_botAnswer, answer);}

    public void acceptCookiesPopUp() throws InterruptedException {elementUtil.clickElement(button_acceptCookies);}

    public void closePopUp() throws InterruptedException {elementUtil.clickElement(button_closePopUp);}

    public void sendMessageToBot(String sendMessage) {
        elementUtil.sendKey(text_sendMessageArea, sendMessage);
    }

    public void controlSentMessage(String controlMessage) {elementUtil.getText(text_firstCustomerMessage, controlMessage);}

    public void clickSubmitButton() throws InterruptedException {elementUtil.clickElement(button_submit);}

    public void searchButtonDisplayed(String searchButtonDisplayed) {elementUtil.elementIsDisplayed(button_searchIcon, searchButtonDisplayed);}

    public void searchAreaDisplayed(String searchArea) {
        elementUtil.elementIsDisplayed(text_searchArea, searchArea);
    }

    public void searchWordSearchingArea(String trackingID) {
        elementUtil.sendKey(text_searchArea, trackingID);
    }

    public void controlSearchedText(String searchedID) {
        elementUtil.getText(text_searchText, searchedID);
    }

    public void clickSearchButton() throws InterruptedException {elementUtil.clickElement(button_searchIcon);}

    public void trackButtonIsDisplayed(String trackButton) {elementUtil.elementIsDisplayed(button_trackID, trackButton);}

    public void writeInvalidTrackID(String invalidTrackID) {
        elementUtil.sendKey(text_trackingID, invalidTrackID);
    }

    public void controlMessageForInvalid(String invalidMessage) {elementUtil.getText(text_invalidMessage, invalidMessage);}

    public void clickTrackButton() throws InterruptedException {elementUtil.clickElement(button_trackID);}
}