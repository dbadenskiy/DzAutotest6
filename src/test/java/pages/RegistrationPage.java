package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userForm #userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            responseInput = $(".table");

    CalendarComponent calendarComponent = new CalendarComponent();





    public RegistrationPage openPage () {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner () {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirsName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender (String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject (String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby (String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity (String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitForm () {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResults (String value) {
        responseInput.shouldHave(text(value)).shouldHave(text(value));
        return this;
    }
}
