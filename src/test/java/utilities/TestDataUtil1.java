package utilities;


import org.testng.annotations.DataProvider;

public class TestDataUtil1 {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
                {"annu@gmail.com", "12345"},
                {"test@gmail.com", "wrongpass"}
        };
    }
}