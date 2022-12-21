package Steps;

import Pages.AuthorizedUserPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Condition;

public class SecondTaskStep {

    private LoginPage _loginPage;
    private AuthorizedUserPage _authorizedUserPage;

    public SecondTaskStep()
    {
        _loginPage = new LoginPage();
        _authorizedUserPage = new AuthorizedUserPage();
    }


    public SecondTaskStep SetValuesInLogin(String username, String password )
    {
        _loginPage.userNameEditText.setValue(username);
        _loginPage.passwordEditText.setValue(password);

        return this;
    }
    public SecondTaskStep ClickLoginBtn()
    {
        _loginPage.loginBtn.click();
        return this;
    }
    public SecondTaskStep AssertEquals(String text)
    {
        _authorizedUserPage.userName.shouldHave(Condition.exactText(text));
        return this;
    }
}
