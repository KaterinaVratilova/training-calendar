package com.example.trainingcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Training(
  @Id
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
