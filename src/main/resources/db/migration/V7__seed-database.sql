INSERT INTO users (id, login, senha, role) VALUES
    (1, 'john_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1),
    (2, 'jane_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1);

-- Seed data for student table
INSERT INTO students (id, name, email, enrollment, birth_date, user_id) VALUES
    (1, 'John Doe', 'john.doe@example.com', 123456, '2000-01-01', 1),
    (2, 'Jane Doe', 'jane.doe@example.com', 123457, '2001-02-02', 2);

-- Seed data for company table
INSERT INTO companys (id, name, email, cnpj) VALUES
    (1, 'Company One', 'company.one@example.com', '12.345.678/0001-95'),
    (2, 'Company Two', 'company.two@example.com', '98.765.432/0001-10');

-- Seed data for internship table
INSERT INTO internships (id, title, description, company_id, salary, expiration_date, remote, city, shift) VALUES
    (1, 'Internship One', 'Description for Internship One', 1, 1600.00, '2024-05-19', TRUE, 'Feira de Santana', 'Noturno'),
    (2, 'Internship Two', 'Description for Internship Two', 2, 1000.00, '2024-05-20', FALSE, 'Feira de Santana', 'Diurno');

-- Seed data for application table
INSERT INTO applications (id, student_id, internship_id, description) VALUES
    (1, 1, 1, 'Description for Application One'),
    (2, 2, 2, 'Description for Application Two');