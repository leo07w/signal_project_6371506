package com.cardio_generator.outputs;

public class ConsoleOutputStrategy implements OutputStrategy {

  /**
   * Prints patient data to the console.
   * @param patientId: arbitrary patient ID
   * @param timestamp: time of output/storage, for example system time
   * @param label: data label, provides context for the data
   * @param data: relevant patient data
   */
  @Override
  public void output(int patientId, long timestamp, String label, String data) {
    System.out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
  }
}
