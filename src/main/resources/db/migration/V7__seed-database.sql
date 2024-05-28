INSERT INTO users (id, login, senha, role) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a19', 'john_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1),
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a20', 'jane_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1);

-- Seed data for student table
INSERT INTO students (id, nome, email, matricula, data_nascimento, user_id) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'John Doe', 'john.doe@example.com', 123456, '2000-01-01', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a19'),
    ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Jane Doe', 'jane.doe@example.com', 123457, '2001-02-02', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a20');

-- Seed data for company table
INSERT INTO companys (id, nome, email, cnpj) VALUES
    ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Company One', 'company.one@example.com', '12.345.678/0001-95'),
    ('d0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'Company Two', 'company.two@example.com', '98.765.432/0001-10');

-- Seed data for internship table
INSERT INTO internships (id, title, description, company_id, salary, expiration_date, remote) VALUES
    ('e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Internship One', 'Description for Internship One', 'c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 1600.00, '2024-05-19', TRUE),
    ('f0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'Internship Two', 'Description for Internship Two', 'd0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 1000.00, '2024-05-20', FALSE);

-- Seed data for application table
INSERT INTO applications (id, student_id, internship_id, description) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a17', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Description for Application One'),
    ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a18', 'b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'f0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'Description for Application Two');