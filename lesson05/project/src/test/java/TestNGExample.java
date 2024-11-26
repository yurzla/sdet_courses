import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

@Test
public class TestNGExample {
    private int number;
    private final String USER_NAME = "Zoidberg";
    private final String USER_PASSWORD = "doctor";

    @BeforeClass
    public void setup() {
        number = 2;
    }

    @AfterClass
    public void tearDown() {
        number = 0;
    }

    @Test(groups="regress")
    public void simple_calc_test() {
        assertEquals(2+2, 4, "Wrong message");
    }

    @Test(groups="regress")
    public void simple_calc_test2() {
        assertEquals(number+2, 4, "Wrong message");
    }

    @Test(description = "Simple params test")
    @Parameters({"name", "password"})
    public void parameterized_test(String name, String password) {
        assertEquals(name, USER_NAME, "Wrong user name");
        assertEquals(password, USER_PASSWORD, "Wrong password");
    }

    @Test(dataProvider = "credits")
    public void data_provider_test(String name, String password)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, USER_NAME, "Wrong user name");
        softAssert.assertEquals(password, USER_PASSWORD, "Wrong password");
        softAssert.assertAll();
    }

    @DataProvider(name="credits")
    public static Object[][] creditsProvider() {
        return new Object[][]{
                {"Zoidberg", "doctor"},
                {"Zoidberg", "capo"},
                {"Leela", "capo"}
        };
    }
}
