package hooks;

import PageObject.PageSteps.HeaderElementsSteps;
import PageObject.PageSteps.LogInElementsSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import static utils.Configuration.getConfigurationValue;

public abstract class WebHooks {
    @BeforeAll
    static void setUp() {
        Selenide.open(getConfigurationValue("jiraUrl"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
        new LogInElementsSteps().authorization(getConfigurationValue("username"),
                getConfigurationValue("password"));
    }

    @BeforeEach
    public void logIn() {
        new HeaderElementsSteps().clickMainLogo();
    }

    @AfterAll
    static void closeWebBrowser() {
        new HeaderElementsSteps().logout();
        Selenide.closeWebDriver();
    }
}
