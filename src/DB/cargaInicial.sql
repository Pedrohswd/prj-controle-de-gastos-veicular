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
CREATE TABLE IF NOT EXISTS Veiculo (
    ID_VEICULO SERIAL PRIMARY KEY,
    placa UNIQUE VARCHAR(10) NOT NULL,
    renavam VARCHAR(11) NOT NULL,
    ano_fabricacao VARCHAR(4) NOT NULL,
    ano_modelo VARCHAR(4) NOT NULL,
    combustivel VARCHAR(30) NOT NULL,
    km_atual FLOAT NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    status VARCHAR(10) NOT NULL,
    ID_MODELO INT,
    FOREIGN KEY (ID_MODELO) REFERENCES Modelo (ID_MODELO)
);
CREATE TABLE IF NOT EXISTS Categoria (
    id_categoria SERIAL PRIMARY KEY,
    Descricao VARCHAR(100) not null
);
CREATE TABLE IF NOT EXISTS Subcategoria (
    ID_SUBCATEGORIA SERIAL PRIMARY KEY,
    Descricao VARCHAR(100) not null,
    ID_CATEGORIA INT not null,
    FOREIGN KEY (ID_CATEGORIA) REFERENCES Categoria(id_categoria) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS Lancamento (
    ID_LANCAMENTO SERIAL PRIMARY KEY,
    ID_VEICULO INT,
    ID_CATEGORIA INT,
    ID_SUBCATEGORIA INT,
    valor float(24) NOT NULL,
    data_lancamento DATE not null,
    FOREIGN KEY (ID_VEICULO) REFERENCES Veiculo (ID_VEICULO),
    FOREIGN KEY (ID_CATEGORIA) REFERENCES Categoria (id_categoria),
    FOREIGN KEY (ID_SUBCATEGORIA) REFERENCES Subcategoria (id_subcategoria)    
);