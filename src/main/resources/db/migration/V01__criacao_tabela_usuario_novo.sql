CREATE TABLE usuario_novo (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    posto_grad VARCHAR(50) NOT NULL,
    nome_guerra VARCHAR(50) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    escalao VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    servico VARCHAR(200) NOT NULL
    
    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;