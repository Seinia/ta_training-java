package com.epam.training.vladyslav_yatsevilov.final_task.runner;

import com.epam.training.vladyslav_yatsevilov.final_task.service.LoginDataCreator;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@SelectPackages("com.epam.training.vladyslav_yatsevilov.final_task.runner")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.vladyslav_yatsevilov.final_task.step_definitions")
public class RunnerClass {


    static Object[][] dataProvider() {
        int[] testCases = {1, 2, 3};
        Object[][] data = new Object[testCases.length][1];
        for (int i = 0; i < testCases.length; i++) {
            data[i][0] = LoginDataCreator.getLoginUseCase(testCases[i]);
        }
        return data;
    }

}
