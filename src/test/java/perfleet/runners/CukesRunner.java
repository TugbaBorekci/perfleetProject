package perfleet.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },


        features = "src/test/resources/features" ,
        glue = "perfleet/step_definitions",
        dryRun = false,
        tags ="@PER10-389",
        publish = false


)


public class CukesRunner {

}
