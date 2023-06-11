CREATE TABLE IF NOT EXISTS Proprietario (
    CPF_CNPJ VARCHAR(14) PRIMARY KEY,
    Nome VARCHAR(100) not null,
    Email VARCHAR(100) not null,
    Telefone VARCHAR(20)not null,
    CategoriaCNH CHAR(2),
    DataNasc_Criacao DATE not null,
    CEP VARCHAR(10) not null,
    Logradouro VARCHAR(100) not null,
    Numero VARCHAR(10),
    Complemento VARCHAR(100),
    Bairro VARCHAR(100)not null,
    Cidade VARCHAR(100)not null,
    Estado CHAR(2)not null,
    Tipo_pessoa CHAR(2)not null
);
CREATE TABLE IF NOT EXISTS Marca (
    ID_MARCA SERIAL PRIMARY KEY,
    Nome VARCHAR(100) not null,
    Imagem BYTEA
);
CREATE TABLE IF NOT EXISTS Modelo (
    ID_MODELO SERIAL PRIMARY KEY,
    Nome VARCHAR(100) not null,
    Imagem BYTEA,
    ID_MARCA INT not null,
    FOREIGN KEY (ID_MARCA) REFERENCES Marca (ID_MARCA)
);
CREATE TABLE IF NOT EXISTS Categoria (
    id_categoria SERIAL PRIMARY KEY,
    Descricao VARCHAR(100) not null,
    Tipo VARCHAR(12) not null,
    categoria_pai int,
    FOREIGN KEY (categoria_pai) REFERENCES Categoria (id_categoria)
);