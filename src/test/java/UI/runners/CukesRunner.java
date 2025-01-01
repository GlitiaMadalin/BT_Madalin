package UI.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                //"pretty",
              //  "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/resources/features",
        glue = "UI/step_definitions",
        dryRun = false,
        tags = "@Functionality",
        publish = true
)
public class CukesRunner {
}
