package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    //Кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccount;
    //Кнопка войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement enterAccount;
    //Заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement makeUpBurger;
    //Заголовок "Булки"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Булки')]")
    private SelenideElement buns;
    //Заголовок "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Соусы')]")
    private SelenideElement sauces;
    //Заголовок "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Начинки')]")
    private SelenideElement fillings;
    //Текст Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement fluorescentBunR2D3;
    //Текст Соус Spicy-X
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Соус традиционный галактический')]")
    private SelenideElement traditional;
    //Текст Плоды Фалленианского дерева
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Плоды Фалленианского дерева')]")
    private SelenideElement fallenianTree;
    // методы
    // клик по кнопке Личный кабинет
    public void clickPersonalAccount(){
        personalAccount.click();
    }
    // клик по кнопке "Войти в аккаунт"
    public void clickEnterAccount(){
        enterAccount.click();
    }
    //Метод который проверяет видимость на странице заголовка "Соберите бургер"
    public void checkMakeUpBurgerIsVisible(){
        makeUpBurger.shouldBe(visible, Duration.ofSeconds(10));
    }
    //Проверка что раздел "Булки" выделен белым цветом
    public void checkBunIsWhite(){
        buns.shouldHave(cssValue("color","rgba(255, 255, 255, 1)"),Duration.ofSeconds(10));
        sauces.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
        fillings.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
    }
    //Проверка что раздел "Сoусы" выделен белым цветoм
    public void checkSauseIsWhite(){
        buns.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
        sauces.shouldHave(cssValue("color","rgba(255, 255, 255, 1)"),Duration.ofSeconds(10));
        fillings.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
    }
    //Проверка что раздел "Начинки" выделен белым цветом
    public void checkFillingsIsWhite() {
        buns.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
        sauces.shouldHave(cssValue("color","rgba(133, 133, 173, 1)"),Duration.ofSeconds(10));
        fillings.shouldHave(cssValue("color","rgba(255, 255, 255, 1)"),Duration.ofSeconds(10));
    }
    //Метод который прокручивает до текста Соус Spicy-X
    public void scrollIntoTraditional(){
        traditional.scrollIntoView(false);
    }
    //Метод который прокручивает до текста Плоды Фалленианского дерева
    public void scrollIntoFallenianTree(){
        fallenianTree.scrollIntoView(false);
    }

}