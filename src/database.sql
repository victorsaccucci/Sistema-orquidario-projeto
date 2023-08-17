CREATE TABLE usuarios (
    id INT PRIMARY KEY auto_increment,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(20),
    instagram VARCHAR(255),
    whatsapp VARCHAR(20)
);

-- Tabela de Galerias
CREATE TABLE galerias (
    id INT PRIMARY KEY auto_increment,
    usuario_id INT,
    titulo VARCHAR(255),
    subtitulo VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de Exemplares
CREATE TABLE exemplares (
    id INT PRIMARY KEY auto_increment,
    galeria_id INT,
    identificacao VARCHAR(255),
    descricao TEXT,
    foto VARCHAR(255),
    FOREIGN KEY (galeria_id) REFERENCES galerias(id)
);