package com.epam.training.vladyslav_yatsevilov.final_task.service;


import com.epam.training.vladyslav_yatsevilov.final_task.model.LoginData;
import com.epam.training.vladyslav_yatsevilov.infrastructure.util.TestDataReader;


public class LoginDataCreator {

private static final String TESTDATA_LOGIN_USERNAME_USECASE = "testdata.swaglabs.login.username.usecase";
private static final String TESTDATA_LOGIN_PASSWORD_USECASE = "testdata.swaglabs.login.password.usecase";
private static final String TESTDATA_LOGIN_EXPECTED_MESSAGE_USECASE = "testdata.swaglabs.login.expected_message.usecase";


    public static LoginData getLoginUseCase(int useCaseNumber){
        return new LoginData(
                TestDataReader.getTestData(TESTDATA_LOGIN_USERNAME_USECASE + useCaseNumber),
                TestDataReader.getTestData(TESTDATA_LOGIN_PASSWORD_USECASE + useCaseNumber),
                TestDataReader.getTestData(TESTDATA_LOGIN_EXPECTED_MESSAGE_USECASE + useCaseNumber)
        );
    }

}
