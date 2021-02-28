package com.comcast.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = "com/comcast/step_definitions",
        dryRun = false,
        tags = "@comcast"
)

public class CukesRunner {

}
