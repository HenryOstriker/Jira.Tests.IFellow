package UI.hooks;

import UI.projectUtils.ScreenshotOnFailure;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebHooks.setUp();
    }

    @After
    public void closeWebBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            new ScreenshotOnFailure().getScreenshotBytes();
        }
        WebHooks.closeWebBrowser();
    }
}
