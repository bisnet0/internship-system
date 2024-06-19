INSERT INTO users (id, login, senha, role) VALUES
    (1, 'john_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 0),
    (2, 'jane_doe', '$2a$10$VX8GUkTvcte/xa0bfVvsaOo6ucw7fomAQw/jJd8RXbImgTxvrRYaG', 1);

INSERT INTO students (id, name, email, enrollment, birth_date, user_id) VALUES
    (1, 'John Doe', 'john.doe@example.com', 123456, '2000-01-01', 1),
    (2, 'Jane Doe', 'jane.doe@example.com', 123457, '2001-02-02', 2),
    (3, 'Bob Smith', 'bob.smith@example.com', 123458, '2002-03-03', 1),
    (4, 'Alice Johnson', 'alice.johnson@example.com', 123459, '2003-04-04', 2);

INSERT INTO companys (id, name, email, cnpj) VALUES
    (1, 'Company One', 'company.one@example.com', '12345678000195'),
    (2, 'Company Two', 'company.two@example.com', '98765432000110'),
    (3, 'Company Three', 'company.three@example.com', '23456789000123'),
    (4, 'Company Four', 'company.four@example.com', '34567891000134');

INSERT INTO internships (id, title, description, company_id, salary, expiration_date, remote, city, shift) VALUES
    (1, 'Internship One', 'Description for Internship One', 1, 1600.00, '2024-05-19', TRUE, 'Feira de Santana', 'Noturno'),
    (2, 'Internship Two', 'Description for Internship Two', 2, 1000.00, '2024-05-20', FALSE, 'Feira de Santana', 'Diurno'),
    (3, 'Internship Three', 'Description for Internship Three', 3, 1200.00, '2024-06-21', TRUE, 'Salvador', 'Matutino'),
    (4, 'Internship Four', 'Description for Internship Four', 4, 1400.00, '2024-07-22', FALSE, 'Salvador', 'Vespertino');

INSERT INTO applications (id, student_id, internship_id, description) VALUES
    (1, 1, 1, 'Description for Application One'),
    (2, 2, 2, 'Description for Application Two'),
    (3, 3, 3, 'Description for Application Three'),
    (4, 4, 4, 'Description for Application Four');