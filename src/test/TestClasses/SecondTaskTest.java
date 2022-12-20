import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SecondTaskTest {

    public SecondTaskTest()
    {
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";

        baseUrl="https://demoqa.com/login";
    }

    @Test
    public void TestLogin() throws InterruptedException {
        open(baseUrl);

        $(By.id("userName")).setValue("testAutomation");
        $(By.id("password")).setValue("Automation@1234");

        //Button
        $(By.id("login")).click();

       Boolean isVisible =  $(By.id("userName-value")).isDisplayed();

           assertTrue(isVisible);
           assertEquals("testAutomation",$(By.id("userName-value")).innerHtml());
    }
}
