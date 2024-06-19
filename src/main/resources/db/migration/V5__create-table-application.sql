CREATE TABLE applications (
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    internship_id INT NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY(internship_id) REFERENCES internships(id) ON DELETE CASCADE
);