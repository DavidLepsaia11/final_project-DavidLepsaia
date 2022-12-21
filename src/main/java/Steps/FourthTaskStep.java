package Steps;

import Pages.AuthorizedUserPage;
import Pages.BookStorePage;
import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

public class FourthTaskStep {
    private LoginPage _loginPage;
    private AuthorizedUserPage _authorizedUserPage;
    private BookStorePage _bookStorePage;

    public FourthTaskStep()
    {
        _loginPage = new LoginPage();
        _authorizedUserPage = new AuthorizedUserPage();
        _bookStorePage = new BookStorePage();
    }


    public FourthTaskStep SetValuesInLogin(String username, String password )
    {
        _loginPage.userNameEditText.setValue(username);
        _loginPage.passwordEditText.setValue(password);
        return this;
    }

    public FourthTaskStep ClickLoginBtn()
    {
        _loginPage.loginBtn.click();
        return this;
    }

    public FourthTaskStep ClickBackToBookStoreBtn(String buttonText)
    {
        _bookStorePage.backToStoreBtn.shouldHave(Condition.exactText(buttonText)).click();
        return this;
    }

    public FourthTaskStep ClickGoStoreBtn()
    {
        _authorizedUserPage.goBookStoreBtn.click();
        return this;
    }

    public FourthTaskStep InputDataInSearchField(String bookTitle)
    {
        _bookStorePage.search.sendKeys(bookTitle);
        return this;
    }
    public FourthTaskStep ClickOnBookLink (String bookTitle)
    {
        _bookStorePage.link.findBy(Condition.exactText(bookTitle)).click();
        return this;
    }

    public FourthTaskStep AssertEquals(String bookTitle)
    {
        assertEquals(bookTitle, _bookStorePage.label.findBy(Condition.exactText(bookTitle)).innerHtml());
        return this;
    }

}
