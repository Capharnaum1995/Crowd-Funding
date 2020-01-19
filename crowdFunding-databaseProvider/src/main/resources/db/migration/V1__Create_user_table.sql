create table user
(
	id int auto_increment,
	account varchar(255) not null,
	password char(200) not null,
	user_name varchar(255) null,
	email varchar(255) null,
	auth_status tinyint null comment '实名认证状态：0-未实名 1-实名申请中 2-已实名',
	user_type tinyint null comment '0-个人 1-企业',
	real_name varchar(255) null,
	bank_account varchar(255) null,
	account_type tinyint null comment '0-企业 1-个体户 2-个人 3-政府部门',
	constraint user_pk
		primary key (id)
);