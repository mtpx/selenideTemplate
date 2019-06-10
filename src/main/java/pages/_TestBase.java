package pages;

import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;




public class _TestBase {


    //lokalizatory

    private SelenideElement login = $(".c-programs > a");
    private List<SelenideElement> applicationsMenu = $$(By.xpath("//div[@class='grid__item -inline-flex']//a"));

    @Step("Przejście na stronę logowania")
    public void clickLogin() {
        login.click();
    }

    @Step("Przejscie na podstrone 'programy'")
    public void clickPrograms() {
        applicationsMenu.get(0).click();
    }


    public void clickMyApplications() {
        applicationsMenu.get(1).click();
    }

    public void clickDocuments() {
        applicationsMenu.get(2).click();
    }

    public void clickProfile() {
        applicationsMenu.get(3).click();
    }

    public void clickNotification() {
        applicationsMenu.get(4).click();
    }

}