package Providers;

import org.testng.annotations.DataProvider;

public class FirstTestData {
    @DataProvider(name = "FirstTestdata")
    public Object[][] dpData() {
        return new Object[][]{
                {"David", "Lepsaia", "D.Lepsaia","123456"},
                {"User99", "LastName99", "Useer99","159874"}
        };
    }
}
