-- Seed data for student table
INSERT INTO student (id, nome, email, matricula, data_nascimento) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'John Doe', 'john.doe@example.com', 123456, '2000-01-01'),
    ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Jane Doe', 'jane.doe@example.com', 123457, '2001-02-02');

-- Seed data for company table
INSERT INTO company (id, nome, email, cnpj) VALUES
    ('c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Company One', 'company.one@example.com', '12.345.678/0001-95'),
    ('d0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'Company Two', 'company.two@example.com', '98.765.432/0001-10');

-- Seed data for internship table
INSERT INTO internship (id, title, description, companyId) VALUES
    ('e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Internship One', 'Description for Internship One', 'c0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13'),
    ('f0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'Internship Two', 'Description for Internship Two', 'd0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14');

-- Seed data for application table
INSERT INTO application (id, student_id, internship_id, description, expiration_date) VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a17', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'e0eebc99-9c0b-4ef8-bb6d-6bb9bd380a15', 'Description for Application One', '2024-05-19'),
    ('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a18', 'b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'f0eebc99-9c0b-4ef8-bb6d-6bb9bd380a16', 'Description for Application Two', '2024-06-20');