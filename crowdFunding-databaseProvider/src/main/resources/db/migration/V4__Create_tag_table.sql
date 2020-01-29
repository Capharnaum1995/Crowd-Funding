create table tag
(
	id int auto_increment,
	parent_id int default 0 not null comment '该标签的父标签id，''0''的话表示该标签没有父标签',
	name varchar(255) not null comment '标签的名称',
	constraint tag_pk
		primary key (id)
)comment '标签表';