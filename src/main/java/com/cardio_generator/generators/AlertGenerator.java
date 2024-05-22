package com.cardio_generator.generators;

import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Generates alerts for patients independent of any actual health value.
 * Enables probabilistic updating of patient's alert state.
 */
public class AlertGenerator implements PatientDataGenerator {

  public static final Random randomGenerator = new Random();

  private boolean[] alertStates; // false = resolved, true = pressed

  /**
   * Initialise alert generator, create array of given number of patients
   * All patients are not on alert state initially
   * @param patientCount: number of patients
   */
  public AlertGenerator(int patientCount) {
    alertStates = new boolean[patientCount + 1];
  }

  /**
   * Generate alerts for patients with random probability.
   * Alerts are resolved with random probability.
   * Therefore, alerts are independent of any health data.
   * @param patientId: arbitrary patient ID
   * @param outputStrategy: strategy to output alert data, such as writing to a file, printing to console, etc.
   */
  @Override
  public void generate(int patientId, OutputStrategy outputStrategy) {
    try {
      if (alertStates[patientId]) {
        if (randomGenerator.nextDouble() < 0.9) { // 90% chance to resolve
          alertStates[patientId] = false;
          // Output the alert
          outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "resolved");
        }
      } else {
        double lambda = 0.1; // Average rate (alerts per period), adjust based on desired frequency
        double p = -Math.expm1(-lambda); // Probability of at least one alert in the period
        boolean alertTriggered = randomGenerator.nextDouble() < p;

        if (alertTriggered) {
          alertStates[patientId] = true;
          // Output the alert
          outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "triggered");
        }
      }
    } catch (Exception e) {
      System.err.println("An error occurred while generating alert data for patient " + patientId);
      e.printStackTrace();
    }
  }
}
