package com.yamilov.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@all"},
        features = {"src/test/java/com/yamilov/test/features/"},
        glue = {"com.yamilov.test.steps.gui", "com.yamilov.test.steps.api"},
        plugin = {"pretty"},
        monochrome = true
)
public class RunCucumberTest {
}
