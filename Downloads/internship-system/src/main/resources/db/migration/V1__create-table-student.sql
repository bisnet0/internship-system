CREATE TABLE student (
  id SERIAL PRIMARY KEY UNIQUE NOT NULL,
  nome TEXT NOT NULL,
  email TEXT NOT NULL,
  login TEXT NOT NULL,
  senha TEXT NOT NULL,
  matricula INT UNIQUE NOT NULL,
  data_nascimento DATE NOT NULL,
  biografia TEXT NOT NULL
);