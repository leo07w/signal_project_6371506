package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

// Interface for classes that generate differing types of health data about patients
public interface PatientDataGenerator {

  /**
   * Generates data about a patient and specifies strategy to store/output the data.
   * Type of data generated is determined by implementing class
   * @param patientId: arbitrary patient ID number
   * @param outputStrategy: strategy to output data, such as writing to a file, printing to console, etc.
   */
  void generate(int patientId, OutputStrategy outputStrategy);
}
