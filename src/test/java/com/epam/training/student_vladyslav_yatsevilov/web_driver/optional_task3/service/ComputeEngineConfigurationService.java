package com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.service;

import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.model.ComputeEngineConfiguration;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.util.TestDataReader;

public class ComputeEngineConfigurationService {

    private static final String TEST_DATA_NUMBER_OF_INSTANCES = "testdata.NumberOfInstances";
    private static final String TEST_DATA_OPERATING_SYSTEM = "testdata.OperatingSystem";
    private static final String TEST_DATA_PROVISIONING_MODEL = "testdata.ProvisioningModel";
    private static final String TEST_DATA_MACHINE_FAMILY = "testdata.MachineFamily";
    private static final String TEST_DATA_SERIES = "testdata.Series";
    private static final String TEST_DATA_MACHINE_TYPE = "testdata.MachineType";
    private static final String TEST_DATA_ADD_GPU = "testdata.AddGpu";
    private static final String TEST_DATA_GPU_TYPE = "testdata.GpuType";
    private static final String TEST_DATA_NUMBER_OF_GPU = "testdata.NumberOfGpu";
    private static final String TEST_DATA_LOCAL_SSD = "testdata.LocalSsd";
    private static final String TEST_DATA_REGION = "testdata.Region";


    public static ComputeEngineConfiguration getPasteDataFromProperties(){
        return new ComputeEngineConfiguration(
                TestDataReader.getTestData(TEST_DATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TEST_DATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TEST_DATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TEST_DATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TEST_DATA_SERIES),
                TestDataReader.getTestData(TEST_DATA_MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(TEST_DATA_ADD_GPU)),
                TestDataReader.getTestData(TEST_DATA_GPU_TYPE),
                TestDataReader.getTestData(TEST_DATA_NUMBER_OF_GPU),
                TestDataReader.getTestData(TEST_DATA_LOCAL_SSD),
                TestDataReader.getTestData(TEST_DATA_REGION)
        );
    }

}