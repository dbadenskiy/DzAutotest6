package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setFirsName("Dmitrij")
                .setLastName("Badenskiy")
                .setEmail("Dima@mail.ru")
                .setGender("Male")
                .setUserNumber("9771970000")
                .setDateOfBirth("29","03","1996")
                .setSubject("Maths")
                .setHobby("Sports")
                .uploadPicture("Test.jpg")
                .setAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();



        registrationPage.checkResult("Student Name", "Dmitrij Badenskiy")
                .checkResult("Student Email", "Dima@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9771970000")
                .checkResult("Date of Birth", "29 March,1996")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Test.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "NCR Delhi");






    }
}