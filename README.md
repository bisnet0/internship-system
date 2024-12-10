<h1 align= "center"> Internship System Backend 💻

## Descrição do Projeto

>Este é o backend de um sistema para gerenciar estágios, oferecendo APIs REST para autenticação, gerenciamento de usuários, empresas, estágios, estudantes e candidaturas de estágio. A aplicação permite o cadastro, consulta, atualização e exclusão desses dados, além de fornecer uma interface de documentação através do Swagger.

## Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot
- **Banco de Dados:** JPA/Hibernate (com PostgreSQL ou MySQL)
- **Autenticação:** Spring Security e JWT
- **Documentação:** Swagger/OpenAPI
- **Gerenciamento de Dependências:** Maven

## Como Rodar o Projeto

### Pré-requisitos

1. **JDK 17** ou superior  
2. **Maven** instalado  
3. **Banco de dados configurado** (ex.: PostgreSQL ou MySQL)  
4. Configurar as variáveis de ambiente ou o arquivo `application.properties`:
   - `spring.datasource.url`
   - `spring.datasource.username`
   - `spring.datasource.password`

### Passos para Rodar

1. **Clone o repositório:**  
   ```bash
   git clone https://github.com/bisnet0/internship-system.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd internship-system-backend
   ```

3. **Instale as dependências e rode o projeto:**
    ```bash
   mvn spring-boot:run
    ```

4. **Acessar o Swagger**:
   _Documentação disponível em:_ [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    ```bash
   http://localhost:8080
    ```

3. **Iniciar a Aplicação**:
   No terminal, execute:
    ```bash
     mvn spring-boot:run
    ```

## Rotas do Projeto

### **Autenticação**
- **POST /auth/login**
  - **Exemplo de Request:**
    ```json
    {
      "login": "admin",
      "senha": "123456"
    }
    ```
  - **Response:**
    ```json
    {
      "token": "eyJhbGciOiJIUzI1Ni..."
    }
    ```

- **POST /auth/register**
  - **Exemplo de Request:**
    ```json
    {
      "login": "novoUsuario",
      "senha": "senha123",
      "role": "ROLE_USER",
      "nome": "João Silva",
      "email": "joao@example.com",
      "matricula": "202212345",
      "data_nascimento": "2000-01-01"
    }
    ```
  - **Response:** `200 OK`

### **Estudantes**
- **GET /student**
  - Retorna todos os estudantes cadastrados.
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@example.com",
        "matricula": "202212345",
        "data_nascimento": "2000-01-01"
      }
    ]
    ```

- **GET /student/{id}**
  - Retorna um estudante específico.
  - **Exemplo de Response:**
    ```json
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao@example.com",
      "matricula": "202212345",
      "data_nascimento": "2000-01-01"
    }
    ```

### **Estágios**
- **GET /internship**
  - Retorna todos os estágios cadastrados.
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "title": "Estágio em TI",
        "company": {
          "id": 2,
          "name": "Tech Corp"
        },
        "city": "São Paulo",
        "salary": 1500.0,
        "remote": true,
        "expirationDate": "2024-12-31T23:59:59"
      }
    ]
    ```

- **POST /internship**
  - **Exemplo de Request:**
    ```json
    {
      "title": "Estágio em Engenharia",
      "description": "Trabalhar em projetos de engenharia civil.",
      "company": { "id": 1 },
      "city": "Belo Horizonte",
      "salary": 1800.0,
      "remote": false,
      "expirationDate": "2025-06-30T23:59:59"
    }
    ```

### **Candidaturas**
- **GET /application**
  - Retorna todas as candidaturas.
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "student": { "id": 1, "name": "João Silva" },
        "internship": { "id": 1, "title": "Estágio em TI" },
        "description": "Candidatura para estágio em TI"
      }
    ]
    ```

- **POST /application**
  - **Exemplo de Request:**
    ```json
    {
      "student": { "id": 1 },
      "internship": { "id": 1 },
      "description": "Estou interessado no estágio"
    }
    ```

---

# Testes do Sistema de Estágio

Este documento descreve os testes realizados para o backend do Sistema de Estágio. Os testes incluem a verificação das rotas de segurança, como a autorização de usuários anônimos e autenticados.

## Testes de Integração

### 1. Teste de Carregamento do Contexto
Verifica se o contexto da aplicação carrega corretamente.

### 2. Testes de Segurança

#### Preparação dos Testes:
- Um token JWT é gerado para um usuário autenticado, simulando um usuário logado e permitindo o acesso às rotas protegidas.

#### Testes de Acesso para Usuários Anônimos:
- Usuário anônimo não pode acessar a lista de candidaturas (status 403 - Forbidden).
- Usuário anônimo pode acessar a lista de estágios (status 200 - OK).
- Usuário anônimo pode visualizar um estágio específico (status 200 - OK).

#### Testes de Acesso para Usuários Logados:
- Usuário logado pode acessar a lista de candidaturas (status 200 - OK).
- Usuário logado pode acessar a lista de estágios (status 200 - OK).
- Usuário logado pode visualizar um estágio específico (status 200 - OK).

## Resumo

Esses testes garantem:
- Carregamento adequado do contexto da aplicação.
- Acesso às rotas de candidaturas e estágios para usuários anônimos e logados.
- Verificação correta das permissões de acesso com base na autenticação.

Esses testes são essenciais para garantir a segurança e o comportamento correto das rotas no sistema.


---

Feito com ❤️ por [Sua Equipe].
