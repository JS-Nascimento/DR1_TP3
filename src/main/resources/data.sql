-- Criação da tabela aluno
CREATE TABLE aluno (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

-- Criação da tabela curso
CREATE TABLE curso (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

-- Criação da tabela de junção aluno_curso
CREATE TABLE aluno_curso (
                             aluno_id BIGINT NOT NULL,
                             curso_id BIGINT NOT NULL,
                             PRIMARY KEY (aluno_id, curso_id),
                             FOREIGN KEY (aluno_id) REFERENCES aluno(id),
                             FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- Inserção de dados na tabela aluno
INSERT INTO aluno (nome) VALUES ('João');

-- Inserção de dados na tabela curso
INSERT INTO curso (nome) VALUES ('Matemática');
INSERT INTO curso (nome) VALUES ('Português');

-- Inserção de dados na tabela de junção aluno_curso
INSERT INTO aluno_curso (aluno_id, curso_id) VALUES (1, 1);
INSERT INTO aluno_curso (aluno_id, curso_id) VALUES (1, 2);
