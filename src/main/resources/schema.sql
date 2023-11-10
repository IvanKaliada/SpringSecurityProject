CREATE TABLE IF NOT EXISTS users (
id bigint not null auto_increment primary key,
username varchar(64) not null,
password varchar(512) not null,
failedloginattempt bigint not null default 0,
lasttimefailed timestamp null,
enabled boolean not null
);

CREATE TABLE IF NOT EXISTS authorities(
id bigint not null auto_increment primary key,
    authority varchar(50) not null
);

CREATE TABLE IF NOT EXISTS user_authority(
user_id bigint not null,
authority_id  bigint not null
);

CREATE TABLE IF NOT EXISTS secret(
id bigint not null auto_increment primary key,
    text  varchar(50),
    uniquelink  varchar(50)
);


