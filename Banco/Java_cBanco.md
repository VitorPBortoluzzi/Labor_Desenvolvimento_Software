Java Swing + Banco de Dados

SQL
```SQL
create database DBaula01;

show databases;

use dbaula_01;

CREATE TABLE pessoa(
    id int auto_increment PRIMARY KEY,
    nome varchar(50) NOT NULL,
    sexo varchar(1) NOT NULL,
    idioma varchar(10) NOT NULL
);

show tables;
desc pressoa;

INSERT INTO pessoa(nome,sexo,idioma) VALUES ("Ricardo","M","Portugês"),("Vitor","M","Português"),("Mary","F","Inglês");

select * from pessoa;
```

```SQL
create database escola;

show databases;

use escola;

CREATE TABLE alunos(
    id int auto_increment PRIMARY KEY,
    nome varchar(50) NOT NULL,
    idade int NOT NULL,
    curso varchar(50) NOT NULL
);

show tables;
desc alunos;

INSERT INTO alunos(nome,idade,curso) VALUES ("João",20,"Matemática"),("Maria",23,"História"),("Pedro",21,"Ciências da Computação"),("Ana",19,"Biologia"),("Carlos",23,"Economia");

select * from alunos;

CREATE TABLE professores(id int auto_increment primary key,nome varchar(50) not null, idade int not null,disciplina varchar(50) not null);

INSERT INTO professores(nome,idade,disciplina) VALUES ("Leticia",35,"Matemática"),("Maria",52,"História"),("Ricardo",41,"Ciências da Computação"),("Ana Paula",48,"Biologia"),("Thiago",39,"Economia");

Create table matriculas(id int auto_increment primary key,id_aluno int,id_professor int, data_matricula DATE, foreign key(id_aluno) references alunos(id), foreign key (id_professor) references professores(id));

insert into matriculas(id_aluno,id_professor,data_matricula) values (1,1,'2023-01-15'),(2,2,'2023-02-20'),(3,3,'2023-03-10'),(4,1,'2023-04-05'),(5,2,'2023-05-12');

select id_aluno as 'Aluno',id_professor as 'Professor' from matriculas;
-- SELECT a.nome AS 'Aluno', p.nome AS 'Professor' FROM matriculas m JOIN alunos a ON m.id_aluno = a.id JOIN professores p ON m.id_professor = p.id;
-- Usamos JOIN para relacionar os IDs de matriculas com os respectivos IDs de alunos e professores, permitindo exibir os nomes correspondentes em vez dos números.


```


Estruturas de projetos:
Beans:
    Classes que mapearao as tabelas

DAO:
    CRUD do SQL