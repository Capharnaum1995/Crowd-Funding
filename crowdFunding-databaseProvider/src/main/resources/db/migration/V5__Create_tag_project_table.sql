create table tag_project
(
	id int auto_increment,
	project_id int not null comment '该标签所在项目的id',
	tag_id int not null comment '该标签的id',
	constraint tag_project_pk
		primary key (id)
)comment '标签-项目表';