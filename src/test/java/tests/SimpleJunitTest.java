import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJunitTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Dmitrij");
        $("#lastName").setValue("Badenskiy");
        $("#userEmail").setValue("Dima@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userForm #userNumber").setValue("9771970000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Test.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Student Name")).shouldHave(text("Dmitrij Badenskiy"));
        $(".table").shouldHave(text("Student Email")).shouldHave(text("Dima@mail.ru"));
        $(".table").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table").shouldHave(text("Mobile")).shouldHave(text("9771970000"));
        $(".table").shouldHave(text("Date of Birth")).shouldHave(text("29 March,1996"));
        $(".table").shouldHave(text("Subjects")).shouldHave(text("Maths"));
        $(".table").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("Test.jpg"));
        $(".table").shouldHave(text("Address")).shouldHave(text("Moscow"));
        $(".table").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}