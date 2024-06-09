package com.cardio_generator.datastorage.patients;

import com.cardio_generator.wiki.HealthCondition;

import com.cardio_generator.timetools.TimeRange;

import java.time.LocalDateTime;
import java.util.ArrayList;

//Patient file, contains overview of patient information
public class PatientFile {

  private Patient patient;
  private int age;
  private String biologicalGender;
  private String medicalHistory;
  private ArrayList<HealthCondition> conditions;
  private LocalDateTime dateOfBirth;
  private ArrayList<TimeRange> hospitalVisits;
  private Status status;

  public PatientFile(Patient patient, int age, String biologicalGender, String medicalHistory, ArrayList<HealthCondition> conditions, LocalDateTime dateOfBirth, ArrayList<TimeRange> hospitalVisits, Status status) {
    this.patient = patient;
    this.age = age;
    this.biologicalGender = biologicalGender;
    this.medicalHistory = medicalHistory;
    this.conditions = conditions;
    this.dateOfBirth = dateOfBirth;
    this.hospitalVisits = hospitalVisits;
  }

  @Override
  public int hashCode() {
    return this.patient.hashCode();
  }

  public enum Status {
    DECEASED, DISMISSED, ADMITTED
  }
}
