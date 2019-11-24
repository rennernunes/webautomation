package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/feature/ShoppingAutomation.feature",
    glue = "",
    tags = {"not @ignore"},
    plugin = {"summary", "pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    dryRun = false,
    strict = true
)

public class ShoppingAutomationRunner {

}
