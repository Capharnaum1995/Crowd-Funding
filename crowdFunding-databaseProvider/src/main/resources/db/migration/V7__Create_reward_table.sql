create table reward
(
	id int auto_increment,
	project_id int not null comment '该回报所属的项目的id',
	type tinyint not null comment '回报物品的类型 0-虚拟 1-实物',
	money int not null comment '支持该挡位需要的金额',
	description varchar(255) not null comment '回报物品的描述',
	picture varchar(255) not null comment '回报物的图片展示',
    remark varchar (255) not null comment '回报的备注信息',
	limited_amount int not null comment '回报的物品是否限购 0-不限购',
	limited_purchase int not null comment '一个用户限购的数量 ',
	freight int not null comment '是否包邮 0-包邮',
	reward_date tinyint not null comment '众筹成功多少天后向支持者发放回报',
	receipt tinyint not null comment '是否支持开发票 0-不支持 1-支持',
	constraint reward_pk
		primary key (id)
)
comment '回报档位标，一个项目可以有多个回报挡位';