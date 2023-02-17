package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ForgotPassword {
    //Кнопка Вoйти
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enter;
    // метод клика по кнопке Войти
    public void clickEnterButton(){
        enter.click();
    }
}