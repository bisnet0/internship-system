CREATE TABLE internship(
   id UUID PRIMARY KEY UNIQUE NOT NULL,
   title TEXT NOT NULL,
   description TEXT NOT NULL,
   companyId UUID NOT NULL,
   FOREIGN KEY(companyId) REFERENCES company(id) ON DELETE CASCADE
);