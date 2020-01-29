create table type_project
(
	id int auto_increment,
	project_id int not null comment '项目的id',
	type_id int not null comment '品类的id',
	constraint type_project_pk
		primary key (id)
)comment '类型-项目表';