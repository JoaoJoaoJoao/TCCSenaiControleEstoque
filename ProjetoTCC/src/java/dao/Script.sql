create database ProjetoTCC;

use ProjetoTCC;

create table ProjetoTCC.Produto(
idProduto int not null auto_increment,
nomeProduto varchar (100),
custoProduto double ,
valorProduto double ,
unidade int  ,
primary key (idProduto));

create table ProjetoTCC.Fornecedor(
idFornecedor int not null auto_increment,
nomeFornecedor varchar (100)  ,
telefoneForncedor varchar (20)  ,
cnpj int   ,
nomeContatoFornecedor varchar(100),
primary key (idFornecedor)); 
