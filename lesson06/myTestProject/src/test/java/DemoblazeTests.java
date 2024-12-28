import com.codeborne.selenide.Configuration;
import org.pages.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class DemoblazeTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoblazeTests.class);

    @BeforeMethod
    void initBeforeMethod() {
        logger.info("Открываем страницу");
        open("/");
    }

    @Test(description = "Проверяем начальное состояние login окна и включаем его")
    public void loginModalTriggering() {
        page(MainPage.class).checkLoginWindowHidden()
                .showLoginModal()
                .toMainPage()
                .checkLoginWindowVisible()
                .toLoginModal()
                .hideLoginModal()
                .checkLoginWindowHidden();
    }

    @Test(description = "Проверяем операцию входа пользователя")
    public void loginWithFakeParams() {
        page(MainPage.class).checkLoginWindowHidden()
                .showLoginModal()
                .toMainPage()
                .checkLoginWindowVisible()
                .toLoginModal()
                .checkUserNameAndTypeText("sa")
                .checkPasswordAndTypeText("as")
                .checkLoginButtonAndClick();
    }
}
