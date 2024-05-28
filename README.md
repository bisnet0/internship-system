# internship-system-
flyway -user=postgres -password=password -url=jdbc:postgresql://localhost:5432/mydatabase -locations=filesystem:src/main/resources/db/migration clean
flyway -user=postgres -password=password -url=jdbc:postgresql://localhost:5432/mydatabase -locations=filesystem:src/main/resources/db/migration migrate


## Como rodar o projeto

docker-compose up -d --build sobe o banco de dados

## Rotas disponíveis:

#### POST /auth/register
```json
{
    "login": "example",
    "senha": "example"
}
```
##### resposta 
200 - OK

#### POST /auth/login
```json
{
    "login": "example",
    "senha": "example"
}
```

##### resposta
200 - OK
```json
{
"token": "example"
}
```