package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this); // нужно для работы аннотации @FindBy
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[1]/nav/div[2]/div/div/div/a")
    private WebElement writeBtn;

    @FindBy(xpath = "//*[@id=\"compose-field-1\"]")
    private WebElement whoField;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendMessage;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[3]/div/div/a[1]/div/img")
    private WebElement profileBtn;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[3]/div/div/div/ul/ul/li[6]/a/span")
    private WebElement quit;


    public void inputWhoField(String who) {
        whoField.sendKeys(who);
    }

    public void inputMessage(String newMessage) {
        message.sendKeys(newMessage);
    }

    public void clickSendMessage() {
        sendMessage.click();
    }

    public void clickProfileBtn() {
        profileBtn.click();
    }

    public void writeClickBtn() {
        writeBtn.click();
    }

    public void clickQuit() {
        quit.click();
    }
}