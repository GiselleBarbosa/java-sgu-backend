-- Criação da tabela Funcionarios
CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    salario NUMERIC(10, 2) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    em_atividade BOOLEAN NOT NULL,
    departamento_id BIGINT NOT NULL
);

-- Inserção de valores padrão na tabela Funcionarios
INSERT INTO funcionarios (nome, telefone, email, cpf, senha, data_nascimento, salario, cargo, em_atividade, departamento_id) VALUES
('Tony Stark', '(11) 98765-4321', 'ironman@example.com', '123.456.789-10', 's3nh@123', '1980-05-29', 10000.00, 'CEO', TRUE, 1),
('Diana Prince', '(21) 98765-4321', 'wonderwoman@example.com', '987.654.321-10', 's3nh@456', '1985-06-23', 9500.00, 'Gerente de Operações', TRUE, 2),
('Peter Parker', '(31) 98765-4321', 'spiderman@example.com', '456.789.123-10', 's3nh@789', '1990-09-15', 8000.00, 'Desenvolvedor', TRUE, 1),
('Bruce Wayne', '(41) 98765-4321', 'batman@example.com', '789.123.456-10', 's3nh@abc', '1982-11-01', 8500.00, 'Analista de Segurança', TRUE, 2),
('Clark Kent', '(51) 98765-4321', 'superman@example.com', '321.654.987-10', 's3nh@def', '1978-07-04', 9000.00, 'Gerente de Projetos', TRUE, 1);
