package com.example.trainingcalendar.repository;

import com.example.trainingcalendar.model.Status;
import com.example.trainingcalendar.model.Training;
import com.example.trainingcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TrainingCollectionRepository {

  private final List<Training> trainingList = new ArrayList<>();

  public TrainingCollectionRepository() {
  }

  public List<Training> findAll() {
    return trainingList;
  }

  public Optional<Training> findById(Integer id) {
    return trainingList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Training training) {
    trainingList.removeIf(c ->c.id().equals(training.id()));
    trainingList.add(training);
  }

  @PostConstruct
  private void init() {
    Training training = new Training(1,
      "The latest trends webinar",
      "The webinar is about the latest trends in the sector.",
        Status.PLANNED,
      Type.WEBINAR,
      LocalDateTime.now(),
      null,
    "");

    trainingList.add(training);

  }

  public boolean existById(Integer id) {
    return trainingList.stream().filter(c -> c.id().equals(id)).count() == 1;
  }

  public void delete(Integer id) {
trainingList.removeIf(c -> c.id().equals(id));
  }

}
