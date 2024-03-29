import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestDemoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1180";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillHardFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan@poker.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9999999901");

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--010.react-datepicker__day--weekend").click();

        $("#subjectsInput").setValue("e").pressEnter();
        $("#subjectsInput").setValue("a").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("example.jpg");

        $("#currentAddress").setValue("Some address 11");

        $("#react-select-3-input").setValue("u").pressEnter();
        $("#react-select-4-input").setValue("a").pressEnter();

        $("#submit").click();

        $(".table tbody tr", 0).shouldHave(text("Ivan Ivanov"));
        $(".table tbody tr", 1).shouldHave(text("ivan@poker.com"));
        $(".table tbody tr", 2).shouldHave(text("Male"));
        $(".table tbody tr", 3).shouldHave(text("9999999901"));
        $(".table tbody tr", 4).shouldHave(text("10 August,1980"));
        $(".table tbody tr", 5).shouldHave(text("English, Maths"));
        $(".table tbody tr", 6).shouldHave(text("Reading"));
        $(".table tbody tr", 7).shouldHave(text("example.jpg"));
        $(".table tbody tr", 8).shouldHave(text("Some address 11"));
        $(".table tbody tr", 9).shouldHave(text("Uttar Pradesh Agra"));

    }
}
