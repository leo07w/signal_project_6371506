package com.cardio_generator.datastorage.patients;

import java.util.ArrayList;
import java.util.HashSet;

//Singleton
//Stores all patient records
public class RecordsArchive {

  private final HashSet<PatientFile> records;
  private static RecordsArchive archive = null;
  public static int historicalTotalPatients = 0;

  private RecordsArchive(HashSet<PatientFile> records) {
    this.records = records;
  }

  public static RecordsArchive getInstance() {
    if (archive == null) {
      archive = new RecordsArchive(new HashSet<PatientFile>());
    }
    return archive;
  }

  public void addRecord(PatientFile record) {
    records.add(record);
    if()
  }

  public void removeRecord(PatientFile record) {
    records.remove(record);
  }

  public void containsRecords(PatientFile record) {
    records.contains(record);
  }



}
