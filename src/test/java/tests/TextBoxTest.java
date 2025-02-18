package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


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
