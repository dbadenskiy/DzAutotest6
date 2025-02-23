package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setFirsName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();



        registrationPage.checkResult("Student Name", testData.firstName +" "+ testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.dayOfBirth +" "+ testData.monthOfBirth +","+ testData.yearOfBirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state +" "+ testData.city);

    }
    @Test
    void requiredFieldsTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setFirsName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .submitForm();

        registrationPage.checkResult("Student Name", testData.firstName +" "+ testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber);

    }

    @Test
    void mobilePhoneValidationTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setFirsName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber("mf8m3okvi4")
                .submitForm()
                .checkResultNegativ();



    }
}

