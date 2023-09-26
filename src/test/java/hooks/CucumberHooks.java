package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebHooks.setUp();
    }

    @After
    public void closeWebBrowser() {
        WebHooks.closeWebBrowser();
    }
}
