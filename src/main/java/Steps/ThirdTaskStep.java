package Steps;

import Pages.AuthorizedUserPage;
import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static junit.framework.Assert.assertEquals;
import static io.restassured.RestAssured.given;

public class ThirdTaskStep {

    private LoginPage _loginPage;
    private AuthorizedUserPage _authorizedUserPage;

    public ThirdTaskStep()
    {
        _loginPage = new LoginPage();
        _authorizedUserPage = new AuthorizedUserPage();
    }

    public ThirdTaskStep SetValuesInLogin(String username, String password )
    {
        _loginPage.userNameEditText.setValue(username);
        _loginPage.passwordEditText.setValue(password);
        return this;
    }

    public ThirdTaskStep ClickLoginBtn()
    {
        _loginPage.loginBtn.click();
        return this;
    }
    public ThirdTaskStep ClickGoStoreBtn()
    {
        _authorizedUserPage.goBookStoreBtn.click();
        return this;
    }
    public ThirdTaskStep ClickOnBookLink(String bookTitle)
    {
        _authorizedUserPage.link.findBy(Condition.exactText(bookTitle)).click();
        return this;
    }

    public ThirdTaskStep CompareToAPIResponse(String bookTitle, String bookISBN)
    {
        String title =  _authorizedUserPage.label.findBy(Condition.exactText(bookTitle)).innerHtml();
        String ISBNValue = _authorizedUserPage.label.findBy(Condition.exactText(bookISBN)).innerHtml();

        Response response = given()
                .queryParam("ISBN",ISBNValue).
                when().
                get("https://bookstore.toolsqa.com/BookStore/v1/Book").
                then().
                statusCode(200).
                extract().
                response();

        ResponseBody body = response.getBody();

        JsonPath jsnPath = body.jsonPath();
        String titleFromApi = jsnPath.get("title");

        assertEquals(title,titleFromApi);
        return this;
    }

}
