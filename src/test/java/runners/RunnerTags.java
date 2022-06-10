package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/lost_and_found_police.feature",
        tags = "@scenario1",
        glue = "stepdefinitions",
        snippets = SnippetType.CAMELCASE )

public class RunnerTags {
}
