package org.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class FeedbackModal {
    final String FEEDBACK_MODAL = "//*[@class='fmo-parent']//*[@class='fb-modal-default']";

    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackModalWindow;


    @FindBy(xpath = FEEDBACK_MODAL + "//input[@data-clear='text']/../..")
    private SelenideElement textInput;

    @Step("Проверить, что модальное окно Обратной связи отобразилось на странице")
    public FeedbackModal checkModalWindowVisible() {
        feedbackModalWindow.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что текстовое поле присутствует")
    public FeedbackModal checkTextInput() {
        textInput.shouldHave(text("Имя или организация"));
        return this;
    }
}
