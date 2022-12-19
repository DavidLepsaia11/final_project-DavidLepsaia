import Providers.FirstTestData;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.Assert.assertEquals;

public class FirstTask {

    public FirstTask()
    {
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";

        baseUrl="https://demoqa.com/login";
    }


    @Test(dataProvider = "FirstTestdata", dataProviderClass = FirstTestData.class)
    public void TestRegistration(String firstName, String lastName, String userName, String password )  throws InterruptedException {
        open(baseUrl);

        //Button
         $(By.id("newUser")).click();

        $(By.id("firstname")).setValue(firstName);
        $(By.id("lastname")).setValue(lastName);
        $(By.id("userName")).setValue(userName);
        $(By.id("password")).setValue(password);

        //Button
         $(By.id("register")).click();

        assertEquals("Please verify reCaptcha to register!",$(By.id("name")).innerHtml());
    }

}
