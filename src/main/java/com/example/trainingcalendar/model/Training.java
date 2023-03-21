package com.example.trainingcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Training(
  Integer id,
  @NotBlank
  String title,
  String desc,
  Status status,
  Type trainingType,
  LocalDateTime startDate,
  LocalDateTime endDate,
  String url
) {
}
