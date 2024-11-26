import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Test
public class DemoblazeTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoblazeTest.class);
    @Test
    public void loginModalTriggering() {
        logger.info("demoblaze loginModalTriggering start");
        logger.info("открываем страницу");
        // сайт был в списке специальных сайтов для отработки автотестирования
        // https://www.software-testing.ru/component/content/article/3806-qa-tester-beginner-series-a-beginners-guide-to-page-object-model-pom-and-page-factory?ysclid=m3q8d57nez138871063
        open("https://www.demoblaze.com/");

        logger.info("ищем модальный элемент, он должен быть невидимым изначально");
        $(By.cssSelector("div[id='logInModal']"))
                .shouldBe(hidden);

        logger.info("ищем кнопку login и жмем на нее");
        $(By.cssSelector("a[id='login2']"))
                .shouldBe(visible)
                .shouldHave(text("Log in"))
                .click();

        logger.info("ищем модальный элемент, он должен стать видимым");
        $(By.cssSelector("div[id='logInModal']"))
                .shouldBe(visible);

        logger.info("demoblaze loginModalTriggering stop");
    }
    @Test
    public void loginWithParams() {
        logger.info("demoblaze loginWithParams start");
        logger.info("открываем страницу");
        open("https://www.demoblaze.com/");

        logger.info("ищем кнопку login и жмем на нее");
        $(By.cssSelector("a[id='login2']"))
                .click();

        sleep(2000);

        logger.info("ищем модальный элемент, он должен стать видимым");
        $(By.cssSelector("div[id='logInModal']"))
                .shouldBe(visible);

        logger.info("ищем textbox с именем пользователя");
        WebElement textBoxLoginUsername = $(By.id("loginusername"));
        textBoxLoginUsername.sendKeys("sa");

        WebElement textBoxLoginPassword = $(By.id("loginpassword"));
        textBoxLoginPassword.sendKeys("as");

        $(By.cssSelector("div[id='logInModal'] button.btn-primary"))
                .shouldBe(visible)
                .shouldHave(text("Log in"))
                .click();

        sleep(2000);

        $(By.id("nameofuser")).shouldBe(visible).shouldHave(text("Welcome sa"));

        logger.info("demoblaze loginWithParams stop");
    }
}
