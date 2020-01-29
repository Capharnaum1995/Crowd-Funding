create table project
(
	id int auto_increment,
	name varchar(255) not null comment '项目名称',
	main_description varchar(255) not null comment '项目的关键描述',
	highlight varchar(255) not null comment '项目的亮点',
	money bigint not null comment '筹资的目标金额',
	day tinyint not null comment '筹资的天数',
	type tinyint not null comment '0-回报众筹 1-公益众筹',
	return_purchase tinyint not null comment '是否支持退换货。0-支持 1-不支持',
	crowd_funding_story text not null comment '众筹故事，md数据',
	why_crowd_funding text not null comment '为什么众筹，md文件',
	company_file varchar(1024) not null comment '公司简介',
	team_file varchar(1024) null comment '团队简介',
	status tinyint default 0 not null comment '0-即将开始，1-众筹中，2-众筹成功，3-众筹失败',
	gmt_deploy bigint not null comment '众筹开始时间',
	fund_money bigint default 0 not null comment '已经筹集的资金',
	supporter_number int default 0 not null comment '项目已经支持的人数',
	promoter_id int not null comment '项目发起人的id',
	gmt_create bigint not null comment '项目创建时间',
	follower_count int default 0 not null comment '关注的人数',
	like_count int default 0 not null comment '项目的点赞的人数',
	header_picture varchar(225) not null comment '项目图片（首页展示用的）',
	constraint project_pk
		primary key (id)
)
comment '项目表';