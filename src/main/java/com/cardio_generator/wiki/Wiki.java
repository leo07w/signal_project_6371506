package com.cardio_generator.wiki;

import java.util.HashMap;
import java.util.HashSet;

// Contains all HealthFeatures and HealthConditions and their description
// Singleton pattern

public class Wiki {

  private final HashSet<HealthCondition> healthConditions;
  private final HashSet<HealthFeature> healthFeatures;
  static Wiki wiki = null;

  private Wiki() {
    healthConditions = new HashSet<HealthCondition>();
    healthFeatures = new HashSet<HealthFeature>();
  }

  //Conditions
  public void addCondition(HealthCondition condition) {
    healthConditions.add(condition);
  }

  public void removeCondition(String condition) {
    HealthCondition co = new HealthCondition(condition);
    healthConditions.remove(co);
  }

  public boolean containsCondition(String condition) {
    HealthCondition co = new HealthCondition(condition);
    return healthConditions.contains(co);
  }

  //Features

  public void addFeature(HealthFeature feature) {
    healthFeatures.add(feature);
  }

  public void removeFeature(String feature) {
    HealthFeature fe = new HealthFeature(feature);
    healthFeatures.remove(fe);
  }

  public boolean containsFeature(String feature) {
    HealthFeature fe = new HealthFeature(feature);
    return this.healthFeatures.contains(fe);
  }

  //Other
  public static Wiki getInstance() {
    return (wiki == null) ? new Wiki() : wiki;
  }

}
