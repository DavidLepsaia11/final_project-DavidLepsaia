import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

public class ThirdTask {

    public ThirdTask ()
    {
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";

        baseUrl="https://demoqa.com/login";
    }

    @Test
    public void TestTask3() throws InterruptedException
    {
        //gotoStore
        open(baseUrl);

        $(By.id("userName")).setValue("testAutomation");
        $(By.id("password")).setValue("Automation@1234");

        //Button
        $(By.id("login")).click();

        //button
        $(By.id("gotoStore")).click();

        // first book's title
        $$("a").findBy(Condition.exactText("Git Pocket Guide")).click();

        String title =  $$("label").findBy(Condition.exactText("Git Pocket Guide")).innerHtml();
        String ISBNValue = $$("label").findBy(Condition.exactText("9781449325862")).innerHtml();

        Response response =given()
                .queryParam("ISBN",ISBNValue).
                when().
                get("https://bookstore.toolsqa.com/swagger/#/BookStore/BookStoreV1BookGet").
                then().
                statusCode(200).
                log().
                all().
                extract().
                response();

        ResponseBody body = response.getBody();

         String responseBody = body.asString();

        //JSON Representation from Response Body
        JsonPath jsnPath = body.jsonPath();

        System.out.print(responseBody);

        //Get value of Location Key
        //String s = jsnPath.get("Title");

        //System.out.print(s);

        //JsonPath jsonPath = new JsonPath(response.asString());
        //String titleFromApi = jsonPath.getString("Book.title");

        //assertEquals(title,titleFromApi);

    }

}
