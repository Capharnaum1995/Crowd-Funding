create table initiator_info_confirm
(
	id int auto_increment,
	user_id int not null comment '发起人会员id',
	pay_number varchar(225) not null comment '发起人支付宝账号',
	id_number varchar(225) not null comment '发起人身份证号码',
	constraint promoter_confirm_info_pk
		primary key (id)
)
comment '发起人信息确认表';