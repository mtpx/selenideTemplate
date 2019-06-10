import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;
import utils.Constants;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    public WebDriver driver;
    Faker faker = new Faker();


    @BeforeClass
    public void setUp() throws Exception {
        Configuration.browser="chrome";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @BeforeMethod
    public void beforeTest() {
//        driver.manage().deleteAllCookies();
        //      driver.get(Constant.testurl);

    }

    @Test(enabled=true, priority=1, description="Logowanie")
    //  @Description("Logowanie: bez danych/logowanie poprawne")
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test001_logowanie(/*String name, String password, String password*/) throws Exception {

        //1. Przejscie na strone logowania
        open(Constants.testurl);
        new _TestBase().clickLogin();



        // 2. Logowanie bez danych
        Login objLogin = new Login();
        objLogin.login("","");
        objLogin.getErrorMessage();
        Assert.assertEquals(objLogin.getErrorMessage(), "Pole Email jest wymagane.");
        Assert.assertEquals(objLogin.getSecondErrorMessage(), "Pole Hasło jest wymagane.");

        // 3. Poprawne logowanie

        objLogin.login("matpanx@gmail.com","Bmxheni@1");

        //   Thread.sleep(4000);


    }

    @Test(enabled=true, priority=1)
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test002_fillExpertsApplication(/*String name, String password, String password*/) throws Exception {

        //  1. Przejście do programow
        new _TestBase().clickPrograms();




        //2. przejscie do expert application
        HomePage objHomePage =new HomePage();
        objHomePage.clickFillExpertsApplication();

        //3. Uzupelnianie formularza


        ExpertsApplication objExpertsApplication = new ExpertsApplication();
        objExpertsApplication.clickPolishLanguageCheckbox();
        objExpertsApplication.clickSubmitApplicationButton();
        objExpertsApplication.clickSavingDraftTitleCloseButton();
        Assert.assertEquals(objExpertsApplication.getValidationErrorDialogBoxLabelText(),"Występują błędy walidacji. Proszę sprawdzić, czy wszystkie pola zostały wypełnione poprawnie.");
        objExpertsApplication.clickOkOnValidationErrorDialogBox();

        Assert.assertEquals(objExpertsApplication.getBottomErrorHeaderText(),"Twój formularz zawiera 1 lub więcej błędów");
        objExpertsApplication.clickInterestedInNawaCheckbox();
        objExpertsApplication.selectRandomNawaProgram();
        objExpertsApplication.selectSecondRandomNawaProgram();

        objExpertsApplication.setAcademicTitle(faker.streetSuffix());
        objExpertsApplication.setPhoneNumber("123456987");
        objExpertsApplication.selectRandomThematicScopeProgram();
        objExpertsApplication.selectRandomEnglishLevel();
        objExpertsApplication.clickRequiredCheckboxes();



        objExpertsApplication.clickSaveAsCopyButton();
        objExpertsApplication.waitForDraftSavedTitleToDisappear();
        objExpertsApplication.clickMyApplications();
        objHomePage.clickDeleteFirstApplication();
        objHomePage.clickConfirmDeleteApplication();

        //   Thread.sleep(4000);

    }
/*

    @Tests (enabled=true, priority=1)
    //@Parameters({ "name", "phone", "password", "001regFeedback", "blankValidationError" })
    public void test003_fillPolishLanguagePromotion(/*String name, String password, String password) throws Exception {

        // 1. Przejście do programow
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickPrograms();

        Applications objApplications = new Applications(driver);
        objApplications.clickFillPolishLanguagePromotion();

        PolishLanguagePromotion objPolishLanguagePromotion = new PolishLanguagePromotion(driver);
        objPolishLanguagePromotion.setProjectRealizationPlace(faker.streetSuffix());
        objPolishLanguagePromotion.clickNextPageOfApplication();

        objPolishLanguagePromotion.selectRandomUnitStatus();
        objPolishLanguagePromotion.selectRandomUnitFullName();
        objPolishLanguagePromotion.setNip("1165830299");
        objPolishLanguagePromotion.setUnitForm(faker.streetSuffix());
        objPolishLanguagePromotion.setDetailsOfPersonSubmittingApplication(faker.country(), "794350654");
        objPolishLanguagePromotion.selectRandomAuthorizationToSendApplication();
        objPolishLanguagePromotion.setContactPerson(faker.firstName(), faker.lastName(), faker.country(),"xxx@asd.pl","794350654");
        objPolishLanguagePromotion.setFinanceContactPerson(faker.firstName(), faker.lastName(), faker.country(),"xxx@asd.pl","794350654");
        objPolishLanguagePromotion.setDescriptionOfApplicant(getLongDescription());
        objPolishLanguagePromotion.setExperienceOfApplicant(generateRandomString(1010));
        objPolishLanguagePromotion.clickNextPageOfApplication();

        objPolishLanguagePromotion.clickNextPageOfApplication();
        objPolishLanguagePromotion.setProjectTitle(generateRandomString(15));
        objPolishLanguagePromotion.setProjectStartDate("2019-10-09");
        objPolishLanguagePromotion.setProjectEndDate("2020-02-09");
        objPolishLanguagePromotion.setShortProjectDescription(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectAnalysis(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectInnovation(generateRandomString(1010));
        objPolishLanguagePromotion.setTargetGroupDescription(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectResults(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectSchedule(generateRandomString(1010));
        objPolishLanguagePromotion.setProjectManagement(generateRandomString(15));
        objPolishLanguagePromotion.setProjectEquality(generateRandomString(15));
        objPolishLanguagePromotion.setProjectMonitoring(generateRandomString(15));
        objPolishLanguagePromotion.setProjectEvaluation(generateRandomString(15));
        objPolishLanguagePromotion.setRiskDescription(generateRandomString(15));
        objPolishLanguagePromotion.selectRandomRiskProbability();
        objPolishLanguagePromotion.selectRandomRiskImpact();
        objPolishLanguagePromotion.setRiskPrevention(generateRandomString(15));
        objPolishLanguagePromotion.setRiskImpactMinimalization(generateRandomString(15));




        Thread.sleep(4000);

    }

*/

    @AfterClass
    public void teardown() {
        SelenideLogger.removeListener("allureSelenide");
        if (driver != null) {
            driver.quit();
        }
    }

}
