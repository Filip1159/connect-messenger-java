--liquibase formatted sql
--changeset filip:1
create table USERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(20) not null UNIQUE,
    name varchar(20) not null,
    surname varchar(20) not null,
    password varchar(100) not null
);
--changeset filip:2
create table authorities (
    username varchar(20) not null,
    authority varchar(20) not null,
    constraint fk_authorities_users foreign key (username) references users(username),
    unique key username_authority(username, authority)
);
--changeset filip:3
insert into users(username, name, surname, password)
values ('janek007', 'Jan', 'Kowalski', '{bcrypt}$2y$12$yJKwJH8SWLBGSvPiggXQdelhMuZNhbQI3WIrNltRN1cE9JcNoNRVi');
insert into authorities (username, authority) values ('janek007', 'USER');

insert into users(username, name, surname, password)
values ('ewa-nowak', 'Ewa', 'Nowak', '{bcrypt}$2y$12$s8GQ5Prs915abrGV/WxCquQuas1xvnqaDZ2iQrLzAKp2TthdfEBgK');
insert into authorities (username, authority) values ('ewa-nowak', 'USER');

insert into users(username, name, surname, password)
values ('mrsmith', 'John', 'Smith', '{bcrypt}$2y$12$CQtho0.NJ6JCbh4PE.eAUOHPfj9OhP3PNA9KxU5jj.Gmdrd.U4wa6');
insert into authorities (username, authority) values ('mrsmith', 'USER');

insert into users(username, name, surname, password)
values ('grace01', 'Grace', 'Thomson', '{bcrypt}$2y$12$q3XGnPrDa4JYMQOPWTcfFeSbr/E4XGKa7Y5K0mZnDxL1Ts3RQp8C.');
insert into authorities (username, authority) values ('grace01', 'USER');