package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSoftAssertionsAndCodeForJUnit {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void searchSoftAssertionsAndCodeForJUnitTest() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).$("pre").
                shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                         @Test
                        void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                        }
                        }"""));
    }
}
