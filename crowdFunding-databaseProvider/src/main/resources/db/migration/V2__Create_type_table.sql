create table type
(
	id int auto_increment,
	name varchar(255) not null comment '项目所属品类的名称',
	constraint type_pk
		primary key (id)
)
comment '项目品类表，即项目是属于哪一个品类的。一个项目可以属于多个品类。';