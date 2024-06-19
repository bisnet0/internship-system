CREATE TABLE internships(
   id UUID PRIMARY KEY UNIQUE NOT NULL,
   title TEXT NOT NULL,
   description TEXT NOT NULL,
   company_id UUID NOT NULL,
   city TEXT NOT NULL,
   shift TEXT NOT NULL,
   salary DECIMAL NOT NULL,
   expiration_date DATE NOT NULL,
   remote BOOLEAN,
   FOREIGN KEY(company_id) REFERENCES companys(id) ON DELETE CASCADE
);