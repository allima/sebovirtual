CREATE TABLE Endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo CHAR(1) NOT NULL,
  logradouro CHAR(20) NOT NULL,
  numero INTEGER UNSIGNED NOT NULL,
  complemento CHAR(15) NULL,
  bairro CHAR(20) NOT NULL,
  cidade CHAR(30) NOT NULL,
  estado CHAR(30) NOT NULL,
  PRIMARY KEY(idEndereco)
);

CREATE TABLE Editora (
  idEditora INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Nome CHAR(30) NOT NULL,
  PRIMARY KEY(idEditora)
);

CREATE TABLE Telefo.ne (
  idTelefone INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ddd INTEGER UNSIGNED NOT NULL,
  numero INTEGER UNSIGNED NOT NULL,
  tipo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idTelefone)
);

CREATE TABLE Pessoa (
  cpf INTEGER UNSIGNED NOT NULL,
  nome CHAR(50) NOT NULL,
  email CHAR(255) NOT NULL,
  senha CHAR(8) NOT NULL,
  dica_senha CHAR(20) NOT NULL,
  status_2 INTEGER UNSIGNED NOT NULL,
  tipo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(cpf)
);

CREATE TABLE Dados_Bancarios (
  idDados_Bancarios INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  banco INTEGER UNSIGNED NOT NULL,
  agencia INTEGER UNSIGNED NOT NULL,
  contacorente INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idDados_Bancarios)
);

CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Descricao CHAR(30) NOT NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Autor (
  idAutor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Nome CHAR(50) NOT NULL,
  PRIMARY KEY(idAutor)
);

CREATE TABLE Compra (
  idCompra INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  data_compra DATE NULL,
  PRIMARY KEY(idCompra),
  INDEX Compra_FKIndex1(Pessoa_cpf),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Pessoa_has_Endereco (
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  Endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(Pessoa_cpf, Endereco_idEndereco),
  INDEX Pessoa_has_Endereco_FKIndex1(Pessoa_cpf),
  INDEX Pessoa_has_Endereco_FKIndex2(Endereco_idEndereco),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Endereco_idEndereco)
    REFERENCES Endereco(idEndereco)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Pessoa_has_Telefone (
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  Telefone_idTelefone INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(Pessoa_cpf, Telefone_idTelefone),
  INDEX Pessoa_has_Telefone_FKIndex1(Pessoa_cpf),
  INDEX Pessoa_has_Telefone_FKIndex2(Telefone_idTelefone),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Telefone_idTelefone)
    REFERENCES Telefone(idTelefone)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Pessoa_has_Dados_Bancarios (
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  Dados_Bancarios_idDados_Bancarios INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(Pessoa_cpf, Dados_Bancarios_idDados_Bancarios),
  INDEX Pessoa_has_Dados_Bancarios_FKIndex1(Pessoa_cpf),
  INDEX Pessoa_has_Dados_Bancarios_FKIndex2(Dados_Bancarios_idDados_Bancarios),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Dados_Bancarios_idDados_Bancarios)
    REFERENCES Dados_Bancarios(idDados_Bancarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Pessoa_has_Categoria (
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  Categoria_idCategoria INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(Pessoa_cpf, Categoria_idCategoria),
  INDEX Pessoa_has_Categoria_FKIndex1(Pessoa_cpf),
  INDEX Pessoa_has_Categoria_FKIndex2(Categoria_idCategoria),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Categoria_idCategoria)
    REFERENCES Categoria(idCategoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Obra (
  ISBN INTEGER UNSIGNED NOT NULL,
  Categoria_idCategoria INTEGER UNSIGNED NOT NULL,
  Editora_idEditora INTEGER UNSIGNED NOT NULL,
  Autor_idAutor INTEGER UNSIGNED NOT NULL,
  titulo CHAR(30) NOT NULL,
  ano_publicacao INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(ISBN),
  INDEX Obra_FKIndex1(Autor_idAutor),
  INDEX Obra_FKIndex2(Editora_idEditora),
  INDEX Obra_FKIndex3(Categoria_idCategoria),
  FOREIGN KEY(Autor_idAutor)
    REFERENCES Autor(idAutor)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Editora_idEditora)
    REFERENCES Editora(idEditora)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Categoria_idCategoria)
    REFERENCES Categoria(idCategoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Vende (
  Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  Obra_ISBN INTEGER UNSIGNED NOT NULL,
  Dt_inicial DATE NOT NULL,
  Dt_final DATE NOT NULL,
  preco FLOAT NOT NULL,
  PRIMARY KEY(Pessoa_cpf, Obra_ISBN),
  INDEX Pessoa_has_Obra_FKIndex1(Pessoa_cpf),
  INDEX Pessoa_has_Obra_FKIndex2(Obra_ISBN),
  FOREIGN KEY(Pessoa_cpf)
    REFERENCES Pessoa(cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Obra_ISBN)
    REFERENCES Obra(ISBN)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Cesta (
  Compra_idCompra INTEGER UNSIGNED NOT NULL,
  Vende_Obra_ISBN INTEGER UNSIGNED NOT NULL,
  Vende_Pessoa_cpf INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(Compra_idCompra, Vende_Obra_ISBN, Vende_Pessoa_cpf),
  INDEX Compra_has_Vende_FKIndex1(Compra_idCompra),
  INDEX Compra_has_Vende_FKIndex2(Vende_Pessoa_cpf, Vende_Obra_ISBN),
  FOREIGN KEY(Compra_idCompra)
    REFERENCES Compra(idCompra)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Vende_Pessoa_cpf, Vende_Obra_ISBN)
    REFERENCES Vende(Pessoa_cpf, Obra_ISBN)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


