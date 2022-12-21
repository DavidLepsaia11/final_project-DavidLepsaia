package Steps;

import Pages.AuthorizedUserPage;
import Pages.LoginPage;
import TestData.LoginTestData;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;
import static junit.framework.Assert.assertTrue;

public class FifthTaskStep {

    private LoginPage _loginPage;
    private AuthorizedUserPage _authorizedUserPage;

    public FifthTaskStep()
    {
        _loginPage = new LoginPage();
        _authorizedUserPage = new AuthorizedUserPage();

    }

    public FifthTaskStep SetValuesInLogin(String username, String password)
    {
        _loginPage.userNameEditText.setValue(username);
        _loginPage.passwordEditText.setValue(password);
      return this;
    }

    public FifthTaskStep ClickLoginBtn()
    {
        _loginPage.loginBtn.click();
        return this;
    }
    public FifthTaskStep ClickLogoutBtn()
    {
        _authorizedUserPage.logoutBtn.click();
        return this;
    }
    public FifthTaskStep IsVisible(String text)
    {
        Boolean isVisible =_loginPage.h2.findBy(Condition.exactText(text)).isDisplayed();
        assertTrue(isVisible);

        return this;
    }

}
