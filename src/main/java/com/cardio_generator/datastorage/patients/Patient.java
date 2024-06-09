package com.cardio_generator.datastorage.patients;

import com.cardio_generator.wiki.HealthCondition;

import java.util.HashMap;
//Patient object is hashed using the patient's name, this ensures patients can be searched by name
//However under the hood patients are handled using patient id's
public class Patient {

  private String name;

  private int id;

  private int patientNumber;

  //Room and bed managers not implemented yet
  private int roomNumber;
  private int bedNumber;

  HashMap<String, Double> thresholds;

  public Patient(String name) {
    this.name = name;
    this.id = RecordsArchive.historicalTotalPatients++;
    this.patientNumber = PatientList.currentPatientNumber++;
  }

  public String name() {
    return this.name;
  }

  public int id() {
    return this.id;
  }

  public int getPatientNumber() {
    return patientNumber;
  }

  public int hashCode() {
    return this.name.hashCode();
  }

}
