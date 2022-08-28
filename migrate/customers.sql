CREATE TABLE IF NOT EXISTS customers (
  id SERIAL PRIMARY KEY,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL
);

INSERT INTO customers (first_name,last_name) VALUES 
  ( 'Paul', 'California'),
  ( 'Макс', 'Петров'),
  ( 'Дуся', 'Ковальчук'),
  ( 'Маша', 'Михайлова'),
  ( 'Аня', 'Орлова'),
  ( 'Андрей', 'Петров'),
  ( 'Валя', 'Валентинов');
