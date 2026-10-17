CREATE DATABASE IF NOT EXISTS college_events;
USE college_events;

CREATE TABLE IF NOT EXISTS registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    department VARCHAR(100) NOT NULL,
    event_name VARCHAR(100) NOT NULL,
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
