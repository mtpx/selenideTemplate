package pages;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static utils.Utils.*;
import java.util.List;

public class Login extends _TestBase {

    private SelenideElement email = $("#email");
    private SelenideElement password = $("#password");
    private SelenideElement loginButton = $("#loginButton");
    private SelenideElement registerButton = $("##j_idt60");
    private SelenideElement rememberMeCheckbox = $("#remember-me");
    private List<SelenideElement> errorMessages = $$(By.xpath("//div[@id='messages_container']//span[@class='ui-growl-title']"));

    @Step("Logowanie za pomoca: user: {1}, pass: {2}")
    public void login(String login, String password) {
        $(this.email).clear();
        $(this.password).clear();
        $(this.email).sendKeys(login);
        $(this.password).sendKeys(password);
        $(this.loginButton).click();
    }

    @Step("Pobieranie wiadomosci z bledem logowania")
    public String getErrorMessage(){
        return errorMessages.get(0).getText();
    }

    @Step("Pobieranie drugiej wiadomosci z bledem logowania")
    public String getSecondErrorMessage(){
        return errorMessages.get(1).getText();
    }

}
