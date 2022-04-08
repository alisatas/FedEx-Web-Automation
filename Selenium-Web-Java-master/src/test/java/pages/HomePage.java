package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

import static org.junit.Assert.assertTrue;

public class HomePage {

    private WebDriver driver;
    private ElementUtil elementUtil;
    private By button_acceptCookies=By.xpath("(//*[contains(text(),'ACCEPT ALL COOKIES')])[2]");
    private By button_SignUpLogin = By.xpath("//*[contains(text(),'Sign Up/Log In ')]");
    private By button_closePopUp = By.xpath("//*[@title='close']");
    private By text_loginOptions = By.cssSelector(".wlgnlink-class.bound");
    private By button_login = By.xpath("(//*[contains(text(),'Log In')])[2]");
    private By button_chatBot=By.xpath("(//*[@class='va_icon'])[1]");
    private By text_botAnswer=By.cssSelector(".nw_Welcome");

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

    public void clickLoginButton(String loginButton){ elementUtil.click(button_SignUpLogin, loginButton); }

    public void checkOptionsOnLoginMenu(String options) {elementUtil.checkTextFromElements(text_loginOptions, options);}

    public void clickLoginButtonAsFirstOption(String loginAsFirstOption){elementUtil.click(button_login, loginAsFirstOption);}

    public void chatBotDisplayed(String chatBot) {
        elementUtil.elementIsDisplayed(button_chatBot,chatBot);
    }

    public void clickChatBot(String clickChatBot) {
        elementUtil.click(button_chatBot,clickChatBot);
    }

    public void checkAnswerContains(String answer) {
        elementUtil.getText(text_botAnswer,answer);
    }

    public void acceptCookiesPopUp() {elementUtil.clickElement(button_acceptCookies);}

    public void closePopUp() {elementUtil.clickElement(button_closePopUp);
    }
}
