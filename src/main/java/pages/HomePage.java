package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
public class HomePage extends _TestBase {

    private SelenideElement searchQuery = $(By.xpath("//input[@name='q']"));
    private SelenideElement searchButton = $(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));

    @Step("Search")
    public void search(String searchQuery) {
        this.searchQuery.sendKeys(searchQuery);
        searchButton.click();
    }



}


