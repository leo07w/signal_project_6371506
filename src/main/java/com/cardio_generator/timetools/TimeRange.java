package com.cardio_generator.timetools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeRange {
  private final LocalDate startDate;
  private final LocalDate endDate;

  public TimeRange(LocalDate startDate, LocalDate endDate) {
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("Start date must be before end date");
    }
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    return "From " + startDate.format(formatter) + " to " + endDate.format(formatter);
  }

}
