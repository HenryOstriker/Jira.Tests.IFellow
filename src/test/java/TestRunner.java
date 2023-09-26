import hooks.CucumberHooks;
import hooks.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/cucumber.feature",
        glue = {"StepDefinition", "hooks"}
)
public class TestRunner extends CucumberHooks {
}
