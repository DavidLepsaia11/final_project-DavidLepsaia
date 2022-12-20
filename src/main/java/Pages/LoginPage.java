package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    // Buttons
    public SelenideElement newUserBtn;
    public SelenideElement loginBtn;

    // Edit Texts
    public SelenideElement userNameEditText;
    public SelenideElement passwordEditText;

    // General elements
    public ElementsCollection h2;

    public LoginPage()
    {
        newUserBtn = $(By.id("newUser"));
        loginBtn =  $(By.id("login"));
        userNameEditText = $(By.id("userName"));
        passwordEditText = $(By.id("password"));
        h2 = $$("h2");
    }

}
