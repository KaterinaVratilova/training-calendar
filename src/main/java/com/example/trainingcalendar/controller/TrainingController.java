package com.example.trainingcalendar.controller;

import com.example.trainingcalendar.model.Training;
import com.example.trainingcalendar.repository.TrainingCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

  private final TrainingCollectionRepository repository;

  public TrainingController(TrainingCollectionRepository repository) {
    this.repository = repository;
  }


  // make a request and find all the training events in the system

  @GetMapping("")
  public List<Training> findAll() {

    return repository.findAll();
  }
  @GetMapping("/{id}")
  public Optional<Training> findById(@PathVariable Integer id) {
    return repository.findById(id);
  }


  // Create a new one
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@Valid @RequestBody Training training) {

    repository.save(training); // call save and pass in our new training
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@RequestBody Training training, @PathVariable Integer id) {
    if (repository.existById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }
    repository.save(training);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    repository.delete(id);
  }
}

