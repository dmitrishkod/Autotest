package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // нужно для работы аннотации @FindBy
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[1]/div[2]/a[2]")
    private WebElement entryBtn;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement nextBtnLog;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement nextBtnPas;

    public void entryBtnLog() {
        entryBtn.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickNextBtnLog() {
        nextBtnLog.click();
    }

    public void inputPasswd(String passwd) {
        passField.sendKeys(passwd);
    }

    public void clickNextBtnPas() {
        nextBtnPas.click();
    }

}