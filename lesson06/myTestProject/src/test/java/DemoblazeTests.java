import com.codeborne.selenide.Configuration;
import org.pages.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class DemoblazeTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoblazeTests.class);

    /**
     * метод выполняется перед остальными тестирующими методами
     */
    @BeforeMethod
    void initBeforeMethod() {
        logger.info("Открываем страницу");
        open("/");
    }

    /**
     * проверка окошка логина
     * 1. что логин окошко невидно
     * 2. показывает логин окошко
     * 3. проверяет что логин окошко теперь видно
     * 4. прячет логин окошко
     * 5. проверяет что окошко спряталось
     */
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

    /**
     * проверка окошка логина
     * 1. что логин окошко невидно
     * 2. показывает логин окошко
     * 3. проверяет что логин окошко теперь видно
     * 4. проверяем наличие элемента ввода и вводим имя пользователя
     * 5. проверяем наличие элемента ввода и вводим пароль в логин окошко
     * 6. проверяем видимость кнопки логин и жмем на нее
     */
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
