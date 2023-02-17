import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalAccount;
import static com.codeborne.selenide.Selenide.*;
public class EnterConstructorTest {
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
    @DisplayName("Проверить, что работает переход по клику на «Конструктор»")
    public void EnterConstructor() {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("fdgv@fd.er", "123456");
        mainPage.clickPersonalAccount();
        //Test bоdy
        PersonalAccount personalAccount = page(PersonalAccount.class);
        personalAccount.clickСonstructor();
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Проверить, что работает переход по клику на логотип Stellar Burgers")
    public void EnterStellarBurgersLogo() {
        //Setup
        MainPage mainPage = open(Config.STELLARBURGERS_BASE_URL, MainPage.class);
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("fdgv@fd.er", "123456");
        mainPage.clickPersonalAccount();
        //Test body
        PersonalAccount personalAccount = page(PersonalAccount.class);
        personalAccount.clickStellarBurgers();
        //Assertions
        mainPage.checkMakeUpBurgerIsVisible();
    }
}