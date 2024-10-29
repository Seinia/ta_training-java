package com.epam.training.student_vladyslav_yatsevilov.final_task.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"com.epam.training.student_vladyslav_yatsevilov.final_task.step_definitions"}
)
public class RunnerClass {
}
