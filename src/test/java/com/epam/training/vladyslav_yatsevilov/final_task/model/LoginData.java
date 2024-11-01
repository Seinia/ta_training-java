package com.epam.training.vladyslav_yatsevilov.final_task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    String username;
    String password;
    String expectedMessage;
}
