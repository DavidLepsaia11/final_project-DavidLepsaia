package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    // Buttons
    public SelenideElement registerBtn;

    // Edit Texts
    public SelenideElement firstNameEditText;
    public SelenideElement lastNameEditText;
    public SelenideElement userNameEditText;
    public SelenideElement passwordEditText;

    public SelenideElement reCaptcha;

    public RegistrationPage()
    {
        registerBtn =  $(By.id("register"));
        firstNameEditText = $(By.id("firstname"));
        lastNameEditText = $(By.id("lastname"));
        userNameEditText = $(By.id("userName"));
        passwordEditText = $(By.id("password"));
        reCaptcha = $(By.id("name"));

    }
}
