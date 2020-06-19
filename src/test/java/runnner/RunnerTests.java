package runnner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\FinalFeature.feature",
        glue = "stepDefination.jira",
        monochrome=true,
        strict=true,
        plugin={"pretty","html:target\\cucumber-reports\\cucumber-html-reports","json:target\\jsonReports\\common.json"}

)
public class RunnerTests {

}
