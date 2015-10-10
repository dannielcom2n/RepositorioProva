create database CadastroDeCliente;
use CadastroDeCliente;

create table Medicamento(
id int not null auto_increment,
nome varchar(46),
dosagem Int,
intervalo varchar(46),
duracao Int,
primary key(id)
);