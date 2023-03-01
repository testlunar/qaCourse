package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideTest {

    @Test
    @Tag("Selenide")
    void checkThatSoftAssertionsHasCodeExampleForJUnit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#user-content-chapters").parent().sibling(0)
                .$$("li").findBy(Condition.text("Soft assertions")).shouldBe(Condition.exist);

        $(byText("Soft assertions")).click();

        $(".markdown-body").shouldHave(Condition.text("Using JUnit5"));
    }
}
