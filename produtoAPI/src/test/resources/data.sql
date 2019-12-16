INSERT INTO CATEGORIA(nome) VALUES('Cozinha');
INSERT INTO CATEGORIA(nome) VALUES('Casa');
INSERT INTO CATEGORIA(nome) VALUES('Eletrônicos');
INSERT INTO CATEGORIA(nome) VALUES('Esporte');

INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (1,250.0,23,'Panela de Pressão', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (1,1250.0,23,'Air Fryer', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (1,150.0,23,'Pipoqueira', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (3,4550.0,1500,'Televisor de LED', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (4,250.0,1000,'Bola Jabulani', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (4,250.0,100,'Kit Pingpong', FALSE);
INSERT INTO PRODUTO(categoria_id, preco, quantidade, descricao, removido) VALUES (4,250.0,100,'Speedo Glass X', FALSE);


INSERT INTO CLIENTE(nome, email, senha) VALUES ('Cliente', 'cliente@mail.com', '$2a$10$Si7PvxTHg6vuLoJBMpXaqegEs9EVa52UZ/rX4VeVhKV6gOrzn9Ypi');

INSERT INTO ENDERECO_CLIENTE(bairro, cep, cidade, estado, rua, cliente_id) VALUES ('Consolação', '01304-001', 'São Paulo', 'SP', 'Rua Augusta 01', 1);