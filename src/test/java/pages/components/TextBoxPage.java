package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            result = $("#output");

    public TextBoxPage openPage () {
        open("https://demoqa.com/text-box");
        return this;
    }
    public TextBoxPage setFullName (String value) {
        fullNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddres (String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress (String value) {
        permanentAddress.setValue(value);
        return this;
    }
    public TextBoxPage setButton() {
        submitButton.click();
        return this;
    }
    public TextBoxPage getResult (String value) {
        result.shouldHave(text(value));
        return this;
    }
}


