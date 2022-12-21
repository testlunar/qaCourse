package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {
    @Test
    void successfulRegistrationTest() {
        String userName = "Di";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Eg")
                .setEmail("di@mamil.com")
                .setGender("Female")
                .setPhone("1234567890")
                .setBirthDate("14", "April", "1990")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadPicture("1.png")
                .setAdress("some adress1")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Eg")
                .verifyResult("Student Email", "di@mamil.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "14 April,1990")
                .verifyResult("Subjects","Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", "some adress1")
                .verifyResult("State and City", "NCR Delhi");

    }
}
