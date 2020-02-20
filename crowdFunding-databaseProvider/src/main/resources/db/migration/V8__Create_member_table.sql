create table member
(
	id int auto_increment,
	project_id int not null comment '项目的id',
	member_name varchar(255) not null comment '成员名称',
	member_position varchar(255) not null comment '成员职位',
	member_introduction varchar(255) not null comment '成员简介',
	member_avatar varchar(255) not null comment '成员头像',
	constraint member_pk
		primary key (id)
)
comment '项目成员信息表';