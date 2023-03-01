package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Tag("registration")
public class RegistrationWithPageObjectsTests extends TestBase {
    @Test
    void successfulRegistrationTest() {
        TestData testData = new TestData();
        step("Open and fill registrations form", () -> {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhone(testData.phone)
                .setBirthDate(
                        testData.birthDate[0],
                        testData.birthDate[1],
                        testData.birthDate[2])
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture("1.png")
                .setAdress(testData.adress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();
        });
        step("Check form results", () -> {
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.email)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.phone)
                .verifyResult("Date of Birth", testData.birthDate[0] + " "
                        + testData.birthDate[1] + ","
                        + testData.birthDate[2])
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", testData.adress)
                .verifyResult("State and City", testData.state + " " + testData.city);
        });
    }
}
