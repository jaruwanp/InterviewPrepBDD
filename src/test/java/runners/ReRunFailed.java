package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report.html"
        },
        features = "@target/rerun.txt",
        glue = "step_definitions",
        stepNotifications = true
)
public class ReRunFailed {
}
