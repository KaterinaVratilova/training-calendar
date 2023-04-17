package com.example.trainingcalendar.repository;

import com.example.trainingcalendar.model.Training;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TrainingJdbcTemplateRepository {


  private final JdbcTemplate jdbcTemplate;

  public TrainingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Training mapRow(ResultSet rs, int rowNum) throws SQLException, SQLException {
    return new Training(rs.getInt("id"),
      rs.getString("title"),
      rs.getString("desc"),
      Status.valueOf(rs.getString("status")),
      Type.valueOf(rs.getString("training_type")),
      rs.getObject("date_created", LocalDateTime.class),
      rs.getObject("date_updated",LocalDateTime.class),
      rs.getString("url"));
  }

  public List<Training> getAllTraining() {
    String sql = "SELECT * FROM Training";
    List<Training> trainings = jdbcTemplate.query(sql, TrainingJdbcTemplateRepository::mapRow);
    return trainings;
  }

  public void createTraining(String title, String desc, String status, String trainingType, String URL) {
    String sql = "INSERT INTO Training (title, desc, status, training_type, start_date, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
    jdbcTemplate.update(sql, title, desc, status, trainingType, URL);
  }

  public void updateTraining(int id, String title, String desc, String status, String trainingType, String URL) {
    String sql = "UPDATE Training SET title=?, desc=?, status=?, training_type=?, start_date=NOW(), url=? WHERE id=?";
    jdbcTemplate.update(sql, title, desc, status, trainingType, URL, id);
  }

  public void deleteTraining(int id) {
    String sql = "DELETE FROM Training WHERE id=?";
    jdbcTemplate.update(sql, id);
  }

  public Training getTraining(int id) {
    String sql = "SELECT * FROM Training WHERE id=?";
    Training training = jdbcTemplate.queryForObject(sql, new Object[]{id}, TrainingJdbcTemplateRepository::mapRow);
    return training;
  }
}
