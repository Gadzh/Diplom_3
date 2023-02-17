import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterAccountTest {
    @Before
    public void setup() {
        // for testing in Yandex Browser
        //System.setProperty("webdriver.chrome.driver","/Users/gadzhi/Downloads/chromedriver");
        //Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
    }
    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверить, что работает вход по кнопке «Войти в аккаунт» на главной")
    public void EnterAccountMainPage () {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        //Test body
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("fdgv@fd.er", "123456");
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Проверить, что работает ввход через кнопку «Личный кабинет»")
    public void EnterPersonalArea () {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        //Test bоdy
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("fdgv@fd.er", "123456");
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Проверить, что работает вход через кнопку в форме регистрации")
    public void EnterRegistrationForm () {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();
        //Test body
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickEnterButton();
        loginPage.login("fdgv@fd.er", "123456");
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Проверить, что работает вход через кнопку в форме восстановления пароля")
    public void EnterRestorePasswordForm () {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRestorePasswordr();
        //Test body
        ForgotPassword forgotPassword = page(ForgotPassword.class);
        forgotPassword.clickEnterButton();
        loginPage.login("fdgv@fd.er", "123456");
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }
}