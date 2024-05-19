CREATE TABLE application(
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    student_id UUID NOT NULL,
    internship_id UUID NOT NULL,
    description TEXT NOT NULL,
    expiration_date DATE NOT NULL,
    FOREIGN KEY(student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY(internship_id) REFERENCES internship(id) ON DELETE CASCADE
);