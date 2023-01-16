package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://stepik.org/";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open(baseUrl);
    }

    @ValueSource(strings = {
            "Java",
            "Python",
            "C++"})
    @ParameterizedTest(name = "Проверка,что количество статей на тему {0} на сайте stepik.ru равно 20")
    @Tag("BLOCKER")
    void searchText(String text) {
        $(".search-form__input").setValue(text).pressEnter();
        $$("[data-view=search-item]").should(CollectionCondition.size(20));
    }

    @CsvSource(value = {
            "Java,20",
            "Python,20",
            "C++,20"})
    @ParameterizedTest(name = "Проверка,что количество статей на тему {0} на сайте stepik.ru равно {1}")
    @Tag("BLOCKER")
    void checkNumberOfSearchResultCsvSource(String text, int searchResults) {
        $(".search-form__input").setValue(text).pressEnter();
        $$("[data-view=search-item]").should(CollectionCondition.size(searchResults));
    }



    @MethodSource()
    @ParameterizedTest(name = "Проверка названий текста чекбоксов {1} в зависимости от языка {0}")
    @Tag("BLOCKER")
    void checkBoxNamesDependsOnLocale(String locale, List<String> checkboxesNames) {
        $(".language-selector").click();
        $$(".drop-down-content li").find(Condition.text(locale)).click();
        $$(".form-checkbox span").shouldHave(CollectionCondition.texts(checkboxesNames));

    }

    static Stream <Arguments> checkBoxNamesDependsOnLocale(){
        return Stream.of(
                Arguments.of("English",List.of("With certificate","Free")),
                Arguments.of("Русский", List.of("С сертификатами", "Бесплатные")),
                Arguments.of("Беларуская", List.of("З сертыфікатамі", "Бясплатныя"))
        );
    }
}
