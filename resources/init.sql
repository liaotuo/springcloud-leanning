drop database if exists springcloud;
create database springcloud;
use springcloud;

drop table if exists `payment`;
create table `payment`
(
    `id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `serial` varchar(200) default '',
    PRIMARY KEY (`id`)
) engine = innoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

insert into payment values (1, 'name')
