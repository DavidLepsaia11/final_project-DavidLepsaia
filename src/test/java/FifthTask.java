import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FifthTask {
    public FifthTask()
    {
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";

        baseUrl="https://demoqa.com/login";
    }

    @Test
    public void TestLogout() throws InterruptedException {
        open(baseUrl);

        $(By.id("userName")).setValue("testAutomation");
        $(By.id("password")).setValue("Automation@1234");

        //Button login
        $(By.id("login")).click();

        // Button logout
        $(By.id("submit")).click();

        Boolean isVisible =$$("h2").findBy(Condition.exactText("Welcome,")).isDisplayed();

        assertTrue(isVisible);
    }
}
