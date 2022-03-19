create table member (
    id bigint not null auto_increment comment '회원 ID',
    email varchar(255) not null comment '이메일',
    name varchar(50) not null comment '이름',
    status varchar(10) not null comment '회원 상태',
    cellPhone varchar(20) comment '휴대폰 번호',
    telePhone varchar(20) comment '전화번호',
    country varchar(90) comment '국가',
    city varchar(200) comment '시',
    state varchar(100) comment '도/구',
    street1 varchar(100) comment '주소1',
    street2 varchar(100) comment '주소2',
    zipcode varchar(20) comment '우편번호',
    createdAt datetime(6) comment '생성일시',
    updatedAt datetime(6) comment '수정일시',
    createdBy varchar(255) comment '생성자',
    updatedBy varchar(255) comment '수정자',
    primary key (id),
    key `idx_email` (`email`),
    key `idx_cellphone` (`cellPhone`)
) engine=InnoDB default charset=utf8mb4 comment='회원 정보'
;