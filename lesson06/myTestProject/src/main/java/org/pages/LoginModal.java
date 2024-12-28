package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginModal {
    @FindBy(css = "div[id='logInModal'] button.close")
    private SelenideElement hideLoginWindowButton;

    @FindBy(id = "loginusername")
    private SelenideElement textBoxLoginUsername;

    @FindBy(id = "loginpassword")
    private SelenideElement textBoxLoginPassword;

    @FindBy(css = "div[id='logInModal'] button.btn-primary")
    private SelenideElement loginButton;

    @Step("Убрать модальное login окно")
    public MainPage hideLoginModal() {
        hideLoginWindowButton.shouldBe(visible)
                .click();
        return page(MainPage.class);
    }

    @Step("Проверить наличие элемента ввода имени пользователя и ввести его")
    public LoginModal checkUserNameAndTypeText(String userName) {
        textBoxLoginUsername.shouldBe(visible)
                .sendKeys(userName);
        return this;
    }

    @Step("Проверить наличие элемента ввода пароля и ввести его")
    public LoginModal checkPasswordAndTypeText(String password) {
        textBoxLoginPassword.shouldBe(visible)
                .sendKeys(password);
        return this;
    }

    @Step("Проверить наличие кнопки login и нажать её")
    public LoginModal checkLoginButtonAndClick() {
        loginButton.shouldBe(visible)
                .click();
        return this;
    }

    /**
     * метод позволяющий переключить контекст тестирование на класс MainPage
     * @return MainPage.class
     */
    public MainPage toMainPage() {
        return page(MainPage.class);
    }

}
