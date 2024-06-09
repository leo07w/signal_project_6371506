package com.cardio_generator.datastorage.patients;

import com.cardio_generator.datastructures.FixedSizeStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Lightweight patient list, used for quick access to patient data from identityManager
//Singleton

public class PatientList {

  private int maxPatients;
  private HashSet<Patient> patientMap;
  private FixedSizeStack<Patient> patientList;
  private static PatientList patientListInstance = null;
  public static int currentPatientNumber = 0;

  private PatientList(int maxPatients) {
    this.patientMap = new HashSet<Patient>();
    this.patientList = new FixedSizeStack<Patient>(maxPatients);
  }

  public static PatientList getInstance() {
    if (patientListInstance == null) {
      patientListInstance = new PatientList(1000); //hardcoded size
    }
    return patientListInstance;
  }

  public void admitPatient(Patient patient) {
    patientMap.add(patient);
    patientList.push(patient);
    currentPatientNumber++;
  }

  public void dismissPatient(Patient patient) {
    patientMap.remove(patient);
    patientList.remove(patient.getPatientNumber());
    currentPatientNumber--;
  }
}
