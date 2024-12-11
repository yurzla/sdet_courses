package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Класс проверки главной страницы
 */
public class MainPage {
    @FindBy(css = "div[id='logInModal']")
    private SelenideElement loginModal;

    @FindBy(id = "nameofuser")
    private SelenideElement loggedInUserName;

    @Step("Проверить, что модальное окно login видно")
    public MainPage checkLoginWindowVisible() {
        loginModal.shouldBe(visible);
        sleep(2000);
        return this;
    }

    @Step("Проверить, что модальное окно login невидно")
    public MainPage checkLoginWindowHidden() {
        loginModal.shouldBe(hidden);
        sleep(2000);
        return this;
    }

    @Step("Проверить видимость залогиненого пользователя")
    public MainPage checkLoggedInUserName(String userName) {
        loggedInUserName.shouldBe(visible).
            shouldHave(text("Welcome " + userName));
        sleep(2000);
        return this;
    }

    /**
     * метод позволяющий переключить контекст тестирование на класс LoginModal
     * @return LoginModal.class
     */
    public LoginModal toLoginModal() {
        return page(LoginModal.class);
    }
}
