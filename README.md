# internship-system-


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