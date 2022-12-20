package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthorizedUserPage {

    public SelenideElement userName;

    // General components
    public ElementsCollection link;
    public ElementsCollection label;

    //Buttons
    public SelenideElement goBookStoreBtn;
    public SelenideElement logoutBtn;

    public AuthorizedUserPage()
    {
        userName = $(By.id("userName-value"));
        goBookStoreBtn = $(By.id("gotoStore"));
        logoutBtn = $(By.id("submit"));
        link = $$("a");
        label = $$("label");
    }
}
