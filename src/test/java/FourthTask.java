import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


public class FourthTask {
    public FourthTask()
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
        $(By.id("searchBox")).sendKeys(firstTitle);


    }
}
