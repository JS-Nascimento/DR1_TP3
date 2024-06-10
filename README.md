# API de Alunos e Cursos

Esta é uma aplicação Spring Boot que demonstra a persistência de dados usando JPA, gerenciamento de configurações e implementação de serviços baseados em diferentes tecnologias de armazenamento e ferramentas de monitoramento.

## Pré-requisitos

- Java 21
- Maven
- Docker

## Executando a Aplicação

1. **Clone o repositório**:
    ```sh
    git clone https://github.com/JS-Nascimento/DR1_TP3
    cd DR1_TP3
    ```

2. **Inicie o Redis e MongoDB usando Docker**:
    ```sh
    docker-compose up -d
    ```

3. **Construa e execute a aplicação Spring Boot**:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints da API

A API fornece endpoints para gerenciar alunos, cursos e materiais didáticos.

### Alunos

- `GET /alunos`: Obter todos os alunos
- `POST /alunos`: Criar um novo aluno
- `GET /alunos/{id}`: Obter um aluno por ID
- `PUT /alunos/{id}`: Atualizar um aluno por ID
- `DELETE /alunos/{id}`: Excluir um aluno por ID

### Cursos

- `GET /cursos`: Obter todos os cursos
- `POST /cursos`: Criar um novo curso
- `GET /cursos/{id}`: Obter um curso por ID
- `PUT /cursos/{id}`: Atualizar um curso por ID
- `DELETE /cursos/{id}`: Excluir um curso por ID

### Materiais Didáticos

- `GET /materiais`: Obter todos os materiais didáticos
- `POST /materiais`: Criar um novo material didático
- `GET /materiais/{id}`: Obter um material didático por ID
- `PUT /materiais/{id}`: Atualizar um material didático por ID
- `DELETE /materiais/{id}`: Excluir um material didático por ID

## Usando o Insomnia

Para usar esta API com o Insomnia:

1. Abra o Insomnia.
2. Importe o arquivo `Insomnia_Collection.json` fornecido acima.
3. Os endpoints estarão disponíveis para teste.

## Monitoramento com Spring Boot Actuator

A aplicação inclui Spring Boot Actuator para monitoramento de saúde, métricas e configurações do ambiente.

- `GET /actuator/health`: Verificar o status de saúde da aplicação
- `GET /actuator/metrics`: Ver métricas da aplicação
- `GET /actuator/customMetrics`: Ver métricas personalizadas

## Inicialização do Banco de Dados

O banco de dados H2 é usado para armazenar alunos e cursos. O banco de dados é inicializado com alguns dados de exemplo, que estão definidos no arquivo `data.sql`.

## Configuração

As propriedades de configuração estão definidas no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.sql.init.mode=always

spring.redis.host=localhost
spring.redis.port=6379

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=test
