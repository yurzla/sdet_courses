package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс проверки главной страницы
 */
public class MainPage {
    @FindBy(css = "div[id='logInModal']")
    private SelenideElement loginModal;

    @FindBy(id = "nameofuser")
    private SelenideElement loggedInUserName;

    @FindBy(css = "a[id='login2']")
    private SelenideElement showLoginWindowButton;

    /**
     * Проверить, что модальное окно login видно
     * @return this
     */
    @Step("Проверить, что модальное окно login видно")
    public MainPage checkLoginWindowVisible() {
        loginModal.shouldBe(visible);
        return this;
    }

    /**
     * Проверить, что модальное окно login невидно
     * @return this
     */
    @Step("Проверить, что модальное окно login невидно")
    public MainPage checkLoginWindowHidden() {
        loginModal.shouldBe(hidden);
        return this;
    }

    /**
     * Проверить видимость залогиненого пользователя
     * @param userName имя пользователя
     * @return this
     */
    @Step("Проверить видимость залогиненого пользователя")
    public MainPage checkLoggedInUserName(String userName) {
        loggedInUserName.shouldBe(visible).
            shouldHave(text("Welcome " + userName));
        return this;
    }

    /**
     * Показать модальное окно login
     * @return LoginModal.class
     */
    @Step("Показать модальное окно login")
    public LoginModal showLoginModal() {
        showLoginWindowButton.shouldBe(visible)
                .shouldHave(text("Log in"))
                .click();
        return page(LoginModal.class);
    }

    /**
     * метод позволяющий переключить контекст тестирование на класс LoginModal
     * @return LoginModal.class
     */
    public LoginModal toLoginModal() {
        return page(LoginModal.class);
    }
}
