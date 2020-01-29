create table promoter
(
	id int auto_increment,
	project_id int not null comment '项目的id',
	name varchar(255) not null comment '发起人名称',
	position varchar(255) not null comment '发起人职位',
	introduction varchar(255) not null comment '发起人简介',
	avatar varchar(255) not null comment '发起人头像',
	constraint promoter_pk
		primary key (id)
)
comment '发起人信息表';