CREATE TABLE company (
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    email TEXT NOT NULL,
    biografia TEXT NOT NULL,
    razao_social TEXT NOT NULL
    );