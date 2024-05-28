CREATE TABLE applications (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    student_id UUID NOT NULL,
    internship_id UUID NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY(internship_id) REFERENCES internships(id) ON DELETE CASCADE
);