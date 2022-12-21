package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EmailTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }


    @Test
    void wrongEmailTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("anna");
        $("#lastName").setValue("buena");
        $("#userEmail").setValue("anna.mail.ru");
        $("#genterWrapper").$(byText("Female")).click(); // best
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#submit").scrollIntoView(true).click();
        $("#example-modal-sizes-title-lg").shouldNotBe(exist);

        $("#userEmail").setValue("anna@mail.ru");
        $("#submit").scrollIntoView(true).click();
        $("#example-modal-sizes-title-lg").shouldBe(exist);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Di");
        $("#lastName").setValue("Ev");
        $("#userEmail").setValue("di@maimail.ru");
        $("#genterWrapper").$(byText("Female")).click(); // best
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("address 1");
        $(".form-control-file").uploadFromClasspath("1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Di"),
                text("Ev"),
                text("di@maimail.ru"),
                text("1234567890"),
                text("30 April,1988"),
                text("Maths"),
                text("Sports"),
                text("1.png"),
                text("address 1"),
                text("NCR Delhi")
                );

    }
}
