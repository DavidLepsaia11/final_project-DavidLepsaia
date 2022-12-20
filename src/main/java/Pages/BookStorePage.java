package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookStorePage {

    // General components
    public ElementsCollection link;
    public ElementsCollection label;

    public SelenideElement search;

    public BookStorePage()
    {
        link = $$("a");
        label = $$("label");
        search = $(By.id("searchBox"));
    }
}
