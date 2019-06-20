package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Applications extends _TestBase {
    private SelenideElement fillExpertsApplication = $(By.xpath("//button[@id='j_idt123:j_idt128:0:j_idt139']"));
    private SelenideElement fillPolishLanguagePromotion = $(By.xpath("//button[@id='j_idt208:j_idt213:0:j_idt224']"));


    @Step("Wypelnij wniosek: Promocja Jezyka Polskiego")
    public void clickFillPolishLanguagePromotion() throws InterruptedException {
        fillPolishLanguagePromotion.click();
        Thread.sleep(2000);
        if (fillPolishLanguagePromotion.isDisplayed()){
            fillPolishLanguagePromotion.click();
        }
    }

    @Step("Wypelnij wniosek: Experci")
    public void clickFillExpertsApplication() throws InterruptedException {
        fillExpertsApplication.click();
        Thread.sleep(100);
        if (fillExpertsApplication.isDisplayed()){
            fillExpertsApplication.click();
        }
    }


}
