import Steps.*;
import TestData.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class TaskTest {

    // Steps
    private FirstTaskStep _firstTaskStep;
    private SecondTaskStep _secondTaskStep;
    private ThirdTaskStep _thirdTaskStep;
    private FourthTaskStep _fourthTaskStep;
    private FifthTaskStep _fifthTaskStep;


    // Test Datas
    private AuthanthicatedUserTestData _AuthanthicatedUserTestData;
    private FirstBookTestData _firstBookTestData;
    private LoginTestData _loginTestData;
    private NewUsersTestData _newUsersTestData;
    private RegistrationTestData _registrationTestData;

    private ButtonTextTestData _buttonTextTestData;

    public TaskTest()
    {
        _firstTaskStep = new FirstTaskStep();
        _secondTaskStep = new SecondTaskStep();
        _thirdTaskStep = new ThirdTaskStep();
        _fourthTaskStep = new FourthTaskStep();
        _fifthTaskStep = new FifthTaskStep();
        _AuthanthicatedUserTestData = new AuthanthicatedUserTestData();
        _firstBookTestData = new FirstBookTestData();
        _loginTestData = new LoginTestData();
        _newUsersTestData = new NewUsersTestData();
        _registrationTestData = new RegistrationTestData();
        _buttonTextTestData = new ButtonTextTestData();
    }

    @BeforeClass
    public void configs() {
        Configuration.timeout = 20000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://demoqa.com/login";
    }

    //1

    @Test(priority = 1,dataProvider = "NewUsersTestData", dataProviderClass = NewUsersTestData.class)
    public void TestRegistration(String firstName, String lastName, String userName, String password )
    {
        open(baseUrl);

        _firstTaskStep.ClickNewUserBtn()
                .SetValuesInRegistration(firstName, lastName, userName, password)
                .ClickRegisterBtn()
                .AssertEquals(_registrationTestData.reCaptchaText);
    }

    //2
    @Test(priority = 2)
    public void TestLogin()
    {
        open(baseUrl);
        _secondTaskStep.SetValuesInLogin(_AuthanthicatedUserTestData.userName, _AuthanthicatedUserTestData.password)
                .ClickLoginBtn()
                .AssertEquals(_AuthanthicatedUserTestData.userName);
    }

    //3
    @Test(priority = 3, dependsOnMethods="TestLogin")
    public void TestTask3()
    {
        //gotoStore
        _thirdTaskStep
                .ClickGoStoreBtn()
                .ClickOnBookLink(_firstBookTestData.Title)
                .CompareToAPIResponse(_firstBookTestData.Title, _firstBookTestData.ISBNValue);
    }

    //4
    @Test(priority = 4)
    public void TestSearch()
    {
        _fourthTaskStep
                .ClickBackToBookStoreBtn(_buttonTextTestData.ButtonText)
                .InputDataInSearchField(_firstBookTestData.Title)
                .ClickOnBookLink(_firstBookTestData.Title)
                .AssertEquals(_firstBookTestData.Title);
    }

    //5
    @Test(priority = 5)
    public void TestLogout()  {
        _fifthTaskStep
                .ClickLogoutBtn().
                IsVisible(_loginTestData.someText);
    }
}
