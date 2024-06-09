package com.cardio_generator.wiki;

public class HealthFeature {

  private String name;

  private String description;

  public HealthFeature(String name) {
    this.name = name;
  }

  public HealthFeature(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  //Used GPT
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HealthFeature feature = (HealthFeature) o;
    return this.name == null ? feature.getName() == null : this.name.equals(feature.getName());
  }

  @Override
  public int hashCode() {
    return this.name == null ? 0 : this.name.hashCode();
  }

}
