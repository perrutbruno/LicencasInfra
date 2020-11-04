INSERT INTO public.itens_nf(
	id_nota_fiscal, quantidade, id_produto)
	VALUES (1, 10, 1);
	
ALTER TABLE public.itens_nf
    ADD COLUMN id_item_nf SERIAL CONSTRAINT pk_id_item_nf PRIMARY KEY;/*
create table FORNECEDORES(
id_fornecedor SERIAL CONSTRAINT pk_id_fornecedor PRIMARY KEY,
codigo_fornecedor integer NOT NULL,
nome_fornecedor varchar(50) NOT NULL,
cnpj_fornecedor varchar(14) NOT NULL,
ativo integer NOT NULL);


create table SETORES(
id_setor SERIAL CONSTRAINT pk_id_setor PRIMARY KEY,
codigo_setor integer NOT NULL,
nome_setor varchar(40) NOT NULL,
ativo integer NOT NULL);


create table ATENDIMENTOS(
id_atendimento SERIAL CONSTRAINT pk_id_atendimento PRIMARY KEY,
numero_atendimento varchar(20) NOT NULL);


create table PRODUTOS(
id_produto SERIAL CONSTRAINT pk_id_produto PRIMARY KEY,
codigo_produto integer NOT NULL,
nome_produto varchar(40) NOT NULL,
modelo varchar(40),
versao varchar(40),
descricao varchar(150),
observacao varchar(150),
ativo integer NOT NULL);

create table ITENS_NF(
id_item_nf SERIAL CONSTRAINT pk_id_item_nf PRIMARY KEY,
quantidade integer NOT NULL,
id_produto integer NOT NULL,
id_nota_fiscal integer NOT NULL,
FOREIGN KEY (id_produto) REFERENCES produtos (id_produto) ON DELETE CASCADE,
FOREIGN KEY (id_nota_fiscal) REFERENCES notas_fiscais (id_nota_fiscal) ON DELETE CASCADE);

create table NOTAS_FISCAIS(
id_nota_fiscal SERIAL CONSTRAINT pk_id_nota_fiscal PRIMARY KEY,
codigo_nota_fiscal varchar(40) NOT NULL,
data_emissao date NOT NULL,
nome_arquivo varchar(150) NOT NULL,
caminho_arquivo varchar(150) NOT NULL,
descricao varchar(150),
observacao varchar(150),
atendimento varchar(30),
id_fornecedor integer NOT NULL,
FOREIGN KEY (id_fornecedor) REFERENCES fornecedores (id_fornecedor) ON DELETE CASCADE);


create table CHAVES_LICENCAS(
id_chave_licenca SERIAL CONSTRAINT pk_id_chave_licenca PRIMARY KEY,
chave text NOT NULL,
quantidade integer NOT NULL,
quantidade_uso integer NOT NULL,
id_produto integer NOT NULL,
ativo integer NOT NULL,
FOREIGN KEY (id_produto) REFERENCES produtos (id_produto) ON DELETE CASCADE);

create table ATIVACOES(
id_ativacao SERIAL CONSTRAINT pk_id_ativacao PRIMARY KEY,
id_atendimento integer NOT NULL,
FOREIGN KEY (id_atendimento) REFERENCES atendimentos (id_atendimento) ON DELETE CASCADE);


create table COLABORADORES(
id_colaborador SERIAL CONSTRAINT pk_id_colaborador PRIMARY KEY,
nome_colaborador varchar(50) NOT NULL);



create table LICENCIAMENTOS(
id_licenciamento SERIAL CONSTRAINT pk_id_licenciamento PRIMARY KEY,
data_cadastro date NOT NULL,
maquina varchar(20) NOT NULL,
tipo_maquina varchar(30) NOT NULL,
id_ativacao integer NOT NULL,
id_colaborador integer NOT NULL,
id_produto integer NOT NULL,
id_setor integer NOT NULL,
FOREIGN KEY (id_ativacao) REFERENCES ativacoes (id_ativacao) ON DELETE CASCADE,
FOREIGN KEY (id_colaborador) REFERENCES colaboradores (id_colaborador) ON DELETE CASCADE,
FOREIGN KEY (id_produto) REFERENCES produtos (id_produto) ON DELETE CASCADE,
FOREIGN KEY (id_setor) REFERENCES setores (id_setor) ON DELETE CASCADE);

create table USUARIOS(
id_usuario SERIAL CONSTRAINT pk_id_usuario PRIMARY KEY,
codigo_usuario integer NOT NULL,
nome_usuario varchar(40) NOT NULL,
login_usu varchar(40) NOT NULL,
sen_usu varchar(40) NOT NULL,
ativo integer NOT NULL);

*/