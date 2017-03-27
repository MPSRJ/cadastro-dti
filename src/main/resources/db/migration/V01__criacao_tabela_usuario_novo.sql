CREATE TABLE usuario_novo (
    codigo BIGINT(50) PRIMARY KEY AUTO_INCREMENT,
    posto_grad VARCHAR(50) NOT NULL,
    nome_guerra VARCHAR(50) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    escalao VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    servico VARCHAR(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE servico (
    codigo BIGINT(50) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_servico (
    codigo_usuario BIGINT(50) NOT NULL,
    codigo_servico BIGINT(50) NOT NULL,
    PRIMARY KEY (codigo_usuario, codigo_servico),
    FOREIGN KEY (codigo_usuario) REFERENCES usuario_novo(codigo),
    FOREIGN KEY (codigo_servico) REFERENCES servico(codigo)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;