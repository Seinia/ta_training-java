package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComputeEngineConfiguration {
    String numberOfInstances;
    String operatingSystem;
    String provisioningModel;
    String machineFamily;
    String series;
    String machineType;
    boolean addGPU;
    String gpuModel;
    String numbersOfGPU;
    String ssdCapacity;
    String region;
}
