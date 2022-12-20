import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


public class FourthTaskTest {
    public FourthTaskTest()
    {
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";

        baseUrl="https://demoqa.com/login";
    }

    @Test
    public void TestSearch() throws InterruptedException
    {
        //gotoStore
        open(baseUrl);

        $(By.id("userName")).setValue("testAutomation");
        $(By.id("password")).setValue("Automation@1234");

        //Button
        $(By.id("login")).click();

        //button
        $(By.id("gotoStore")).click();

       String firstTitle =  $$("a").findBy(Condition.exactText("Git Pocket Guide")).innerHtml();


       Thread.sleep(3000);

        // search field
        SelenideElement search = $(By.id("searchBox"));
        search.setValue(firstTitle);
        search.submit();

    }
}
