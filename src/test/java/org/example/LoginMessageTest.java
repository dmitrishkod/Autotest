package org.example;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginMessageTest extends TestCase {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static String goodMessage;

    @Override
    @BeforeClass
    protected void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver")); // запускаем хромдрайвер
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        goodMessage = "Добрый день.\n" + "Простейший автотест готов.\n" + "Шкодовский Дмитрий Борисович";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page")); // заходим на страницу
    }

    @Test
    public void testLoginMessage(){

        //жмем войти
        loginPage.entryBtnLog();
        // логинимся
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем Далее
        loginPage.clickNextBtnLog();
        // вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        // жмем далее/входим
        loginPage.clickNextBtnPas();
        // нажимаем на иконку "написать"
        profilePage.writeClickBtn();
        // Открывается окно, заполняем поле Кому
        profilePage.inputWhoField(ConfProperties.getProperty("who"));
        // Заполняем сообщение в поле сообщения
        profilePage.inputMessage(goodMessage);
        // Отправляем сообщение
        profilePage.clickSendMessage();


    }

    @AfterClass
    @Override
    protected void tearDown() throws Exception {
        profilePage.clickProfileBtn();
        profilePage.clickQuit();
        driver.quit();
    }
}
