package com.yavlena.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber.json",
                "html:target/default-html-reports",
                "html:target/cucumber-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/yavlena/step_definitions",
        dryRun = false,
        tags = "@scenario4"
)
public class CukesRunner {

}
