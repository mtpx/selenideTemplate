package pages;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static utils.Utils.*;
import java.util.List;

public class Login extends _TestBase {

    private static SelenideElement email = $("#email"),
            password = $("#password"),
            loginButton = $("#loginButton"),
            registerButton = $("##j_idt60"),
            rememberMeCheckbox = $("#remember-me");
    private static List<SelenideElement> errorMessages = $$(By.xpath("//div[@id='messages_container']//span[@class='ui-growl-title']"));

    @Step("Logowanie za pomoca: user: {1}, pass: {2}")
    public void login(String login, String password) throws InterruptedException {
        $(this.email).clear();
        $(this.password).clear();
        $(this.email).setValue(login);
        $(this.password).setValue(password);
        Thread.sleep(200);
        $(this.loginButton).click();
    }

    @Step("Pobieranie wiadomosci z bledem logowania")
    public SelenideElement getErrorMessage(){
        return errorMessages.get(0);
    }

    @Step("Pobieranie drugiej wiadomosci z bledem logowania")
    public SelenideElement getSecondErrorMessage(){
        return errorMessages.get(1);
    }

}
