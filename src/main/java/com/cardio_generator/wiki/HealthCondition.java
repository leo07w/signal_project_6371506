package com.cardio_generator.wiki;

import java.util.HashMap;

// Could be an illness, infection... Can set default values for thresholds

public class HealthCondition {

  private String name;

  private String description;

  private HashMap<String, Double> thresholds;

  //Constructors
  public HealthCondition(String name) {
    this.name = name.toLowerCase();
    this.thresholds = new HashMap<String, Double>();
  }

  public HealthCondition(String name, String description) {
    this.name = name.toLowerCase();
    this.description = description;
    this.thresholds = new HashMap<String, Double>();
  }

  public HealthCondition(String name, String description, HashMap<String, Double> thresholds) {
    this.name = name.toLowerCase();
    this.description = description;
    this.thresholds = thresholds;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public HashMap<String, Double> getThresholds() {
    return thresholds;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setThresholds(HashMap<String, Double> thresholds) {
    this.thresholds = thresholds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HealthCondition condition = (HealthCondition) o;
    return name == null ? condition.getName() == null : name.equals(condition.getName()) ;
  }

  @Override
  public int hashCode() {
    return this.name == null ? 0 : this.name.hashCode();
  }
}
