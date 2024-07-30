INSERT INTO users (login, senha, role) VALUES
    ('john_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 0),
    ('jane_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1);

INSERT INTO students (name, email, enrollment, birth_date, user_id) VALUES
    ('John Doe', 'john.doe@example.com', 123456, '2000-01-01', 1),
    ('Jane Doe', 'jane.doe@example.com', 123457, '2001-02-02', 2),
    ('Bob Smith', 'bob.smith@example.com', 123458, '2002-03-03', 1),
    ('Alice Johnson', 'alice.johnson@example.com', 123459, '2003-04-04', 2);

INSERT INTO companys (name, email, cnpj) VALUES
    ('Company One', 'company.one@example.com', '12345678000195'),
    ('Company Two', 'company.two@example.com', '98765432000110'),
    ('Company Three', 'company.three@example.com', '23456789000123'),
    ('Company Four', 'company.four@example.com', '34567891000134');

INSERT INTO internships (title, description, company_id, salary, expiration_date, remote, city, shift) VALUES
    ('Internship One', 'Description for Internship One', 1, 1600.00, '2024-05-19', TRUE, 'Feira de Santana', 'Noturno'),
    ('Internship Two', 'Description for Internship Two', 2, 1000.00, '2024-05-20', FALSE, 'Feira de Santana', 'Diurno'),
    ('Internship Three', 'Description for Internship Three', 3, 1200.00, '2024-06-21', TRUE, 'Salvador', 'Matutino'),
    ('Internship Four', 'Description for Internship Four', 4, 1400.00, '2024-07-22', FALSE, 'Salvador', 'Vespertino');

INSERT INTO applications (student_id, internship_id, description) VALUES
    (1, 1, 'Description for Application One'),
    (2, 2, 'Description for Application Two'),
    (3, 3, 'Description for Application Three'),
    (4, 4, 'Description for Application Four');