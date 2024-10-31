package com.epam.training.vladyslav_yatsevilov.final_task.runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@SelectPackages("com.epam.training.vladyslav_yatsevilov.final_task.runner")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.vladyslav_yatsevilov.final_task.step_definitions")
public class RunnerClass {
}
