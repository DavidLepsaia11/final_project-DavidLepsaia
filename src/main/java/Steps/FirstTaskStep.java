package Steps;

import Pages.LoginPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Condition;

public class FirstTaskStep {
    private RegistrationPage _registrationPage;
    private LoginPage _loginPage;

    public FirstTaskStep()
    {
        _registrationPage = new RegistrationPage();
        _loginPage = new LoginPage();
    }

    public FirstTaskStep ClickNewUserBtn()
    {
        _loginPage.newUserBtn.click();
        return this;
    }

    public FirstTaskStep SetValuesInRegistration(String firstName, String lastName, String userName, String password )
    {
        _registrationPage.firstNameEditText.setValue(firstName);
        _registrationPage.lastNameEditText.setValue(lastName);
        _registrationPage.userNameEditText.setValue(userName);
        _registrationPage.passwordEditText.setValue(password);

        return this;
    }

    public FirstTaskStep ClickRegisterBtn()
    {
        _registrationPage.registerBtn.click();
        return this;
    }

    public FirstTaskStep AssertEquals(String text)
    {
        _registrationPage.reCaptcha.shouldHave(Condition.exactText("Please verify reCaptcha to register!"));
        return this;
    }
}
