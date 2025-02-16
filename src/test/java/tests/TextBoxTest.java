package tests;

import org.junit.jupiter.api.Test;
import pages.components.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxTest = new TextBoxPage();


    @Test
    void textBoxTest() {
        textBoxTest.openPage()
                .setFullName("Dmitriy")
                .setEmail("Dima1996@mail.ru")
                .setCurrentAddres("Moscow")
                .setPermanentAddress("Karl Marx Street")
                .setButton();

        textBoxTest.getResult("Dmitriy")
                .getResult("Dima1996@mail.ru")
                .getResult("Moscow")
                .getResult("Karl Marx Street");

    }
}
