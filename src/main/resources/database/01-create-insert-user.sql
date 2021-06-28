-- liquibase formatted sql
-- changeset filip:1
create table user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(20) not null UNIQUE,
    name varchar(20) not null,
    surname varchar(20) not null,
    password varchar(100) not null
);

insert into user(username, name, surname, password)
values ('janek007', 'Jan', 'Kowalski', '{bcrypt}$2y$12$yJKwJH8SWLBGSvPiggXQdelhMuZNhbQI3WIrNltRN1cE9JcNoNRVi');

insert into user(username, name, surname, password)
values ('ewa-nowak', 'Ewa', 'Nowak', '{bcrypt}$2y$12$s8GQ5Prs915abrGV/WxCquQuas1xvnqaDZ2iQrLzAKp2TthdfEBgK');

insert into user(username, name, surname, password)
values ('mrsmith', 'John', 'Smith', '{bcrypt}$2y$12$CQtho0.NJ6JCbh4PE.eAUOHPfj9OhP3PNA9KxU5jj.Gmdrd.U4wa6');

insert into user(username, name, surname, password)
values ('grace01', 'Grace', 'Thomson', '{bcrypt}$2y$12$q3XGnPrDa4JYMQOPWTcfFeSbr/E4XGKa7Y5K0mZnDxL1Ts3RQp8C.');
