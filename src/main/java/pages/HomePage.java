package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
public class HomePage extends _TestBase {

    private SelenideElement fillExpertsApplicationButton = $(By.xpath("//button[@id='j_idt123:j_idt128:0:j_idt139']"));
    private SelenideElement deleteFirstApplicationButton = $(By.xpath("//button[@id='j_idt122:applicationTable:0:j_idt162']"));
    private SelenideElement confirmDeleteApplicationButton = $(By.xpath("//button[@id='j_idt122:j_idt143']"));

    @Step("Wypelnij aplikacje ekspercka")
    public void clickFillExpertsApplication() {
        System.out.println("klik ex");
        fillExpertsApplicationButton.click();
    }

    @Step("Usun pierwszy wniosek")
    public void clickDeleteFirstApplication() {
        deleteFirstApplicationButton.click();
    }

    @Step("Potwierdzenie usuniecia wniosku")
    public void clickConfirmDeleteApplication() {
        confirmDeleteApplicationButton.click();
    }

}


