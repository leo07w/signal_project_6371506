package com.cardio_generator.outputs;

/**
 * Interface for classes that output and/or store patient data.
 */
public interface OutputStrategy {

  /**
   * Outputs patient data.
   * The method of output/storage is determined by the implementing class.
   * @param patientId: arbitrary patient ID
   * @param timestamp: time of output/storage, for example system time
   * @param label: data label, provides context for the data
   * @param data: relevant patient data
   */
  void output(int patientId, long timestamp, String label, String data);
}
