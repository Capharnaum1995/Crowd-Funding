create table project
(
	id int auto_increment,
    type tinyint not null comment '0-回报众筹 1-公益众筹',
    day tinyint not null comment '筹资的天数',
    money bigint not null comment '筹资的目标金额',
    name varchar(255) not null comment '项目名称',
    main_description varchar(255) not null comment '项目的关键描述',
    highlight varchar(255) not null comment '项目的亮点',
    return_purchase tinyint not null comment '是否支持退换货。0-支持 1-不支持',
    crowd_funding_story text not null comment '众筹故事，md数据',
    company_file varchar(1024) not null comment '公司简介',
    team_file varchar(1024) null comment '团队简介',
    initiator_id int not null comment '项目发起人的id',
	status tinyint default 0 not null comment '0-即将开始，1-众筹中，2-众筹成功，3-众筹失败',
	gmt_create bigint not null comment '项目创建时间',
	gmt_deploy bigint not null comment '众筹开始时间，默认项目通过审核的时刻起',
	fund_money bigint default 0 not null comment '已经筹集的资金',
	supporter_number int default 0 not null comment '项目已经支持的人数',
	follower_count int default 0 not null comment '关注的人数',
	like_count int default 0 not null comment '项目的点赞的人数',
	constraint project_pk
		primary key (id)
)
comment '项目表';