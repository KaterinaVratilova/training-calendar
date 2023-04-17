CREATE TABLE IF NOT EXISTS Training (
  id SERIAL PRIMARY KEY ,
  title varchar(255) NOT NULL,
  description text,
  status VARCHAR(20) NOT NULL,
  training_type VARCHAR(50) NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP,
  url VARCHAR(255)
  );

INSERT INTO Training (title, description, status, training_type, start_date)
VALUES('New webinar','Webinar about java','CONFIRMED', 'WEBINAR', CURRENT_TIMESTAMP());
