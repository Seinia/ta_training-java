package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paste1 {
    String pasteCode;
    String pasteTitle;
    String pasteExpiration;
}
