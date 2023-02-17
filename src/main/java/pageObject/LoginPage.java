package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement register;
    //Поле ввoда email
    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div[1]/div[1]/input[1]")
    private SelenideElement emailInput;
    //Поле ввода пароль
    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div[1]/div[1]/input[1]")
    private SelenideElement passwordInput;
    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement enter;
    //Кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement restorePassword;

    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String email, String password){
        emailInput.setValue(email);
        passwordInput.setValue(password);
        enter.click();
    }
    //Mетод который кликает по кнопке Зарегистрироваться
    public void clickRegister(){
        register.click();
    }
    //Mетод который кликает по кнопке "Восстановить пароль"
    public void clickRestorePasswordr(){
        restorePassword.click();
    }
    //Метод который проверяет видимость на странице поля ввода для емэйла
    public void checkEmailInputIsVisible(){
        emailInput.shouldBe(visible, Duration.ofSeconds(10));
    }
    //Метод который проверяет видимость на странице кнопки Зарегистрироваться
    public void checkRegisterVisible(){
        register.shouldBe(visible, Duration.ofSeconds(10));
    }
}