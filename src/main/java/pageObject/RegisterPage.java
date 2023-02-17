package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    //Поле ввода Имя
    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div/div/input")
    private SelenideElement nameInput;
    //Поле ввода Email
    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div/div/input")
    private SelenideElement emailInput;
    //Поле ввода Пароль
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordInput;
    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;
    //Подсказка Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Некорректный')]")
    private SelenideElement wrongPassword;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    //Mетод который кликает по кнопке Зарегистрироваться
    public void clickRegisterButton(){
        registerButton.click();
    }
    //Mетод который кликает пo кнопке Зарегистрироваться
    public void clickEnterButton(){
        enterButton.click();
    }
    //Mетoд регистрации пользователя с невалидными данными
    public void unsuccessfulRegisterUser() {
        nameInput.setValue("Иосиф");
        emailInput.setValue(RandomStringUtils.randomAlphanumeric(4) + "@ru.ru");
        passwordInput.setValue(RandomStringUtils.randomAlphanumeric(5));
        clickRegisterButton();
    }
    //Mетод регистрации пользователя с валидными данными
    public void successfulRegisterUser() {
        nameInput.setValue("Нелли");
        emailInput.setValue(RandomStringUtils.randomAlphanumeric(4) + "@ru.ru");
        passwordInput.setValue(RandomStringUtils.randomAlphanumeric(7));
        clickRegisterButton();
    }
    //Метод который проверяет видимость на странице подсказки Некорректный пароль
    public void checkWrongPasswordIsVisible(){
        wrongPassword.shouldBe(visible, Duration.ofSeconds(10));
    }
}