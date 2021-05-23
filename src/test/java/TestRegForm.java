import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class TestRegForm {

    String firstName = "Тест",
            lastName = "Тестов",
            email = "test@testov.com",
            mobile = "9111111111",
            day = "10",
            month = "July",
            year = "1997",
            subject1 = "Maths",
            subject2 = "English",
            currentAddress = "Планета \"Мир тестов\", г.Тестминд, уд.Тестовая, д. 1",
            state = "Haryana",
            city = "Karnal";

    Logger logger = LoggerFactory.getLogger(TestRegForm.class);

    @BeforeAll
    static void MainSetup() {
        startMaximized = true;
        holdBrowserOpen = true;
        browser = "chrome";
        //browser="firefox";
        //browser="ie";
        //browser="edge";
    }

    @Test
    void CheckRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        //Name_&_Email
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        //Gender
        $("[id=gender-radio-3]").parent().click();
        //Mobile
        $("[id=userNumber]").setValue(mobile);
        //Date_Of_Birth
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(byText(day)).click();
        //Subjects
        $("[id=subjectsInput]").setValue(subject1).pressEnter();
        $("[id=subjectsInput]").setValue(subject2).pressEnter();
        //Hobbies
        $("[id=hobbies-checkbox-1]").parent().click();
        $("[id=hobbies-checkbox-2]").parent().click();
        $("[id=hobbies-checkbox-3]").parent().click();
        //Address
        $("[id=currentAddress]").setValue(currentAddress);
        //State_&_City
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();
        //Button_"Submit"
        $("[id=submit]").click();
        logger.info("The filling was completed successfully!");


        //Checking_After_The_Filling_Reg_Form
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text("Other"),
                text(mobile),
                text(day + " " + month + "," + year),
                text(subject1 + ", " + subject2),
                text("Sports, Reading, Music"),
                text(currentAddress),
                text(state + " " + city)
        );

        $("[id=closeLargeModal").click();
        logger.info("The check was completed successfully!");
    }
}
