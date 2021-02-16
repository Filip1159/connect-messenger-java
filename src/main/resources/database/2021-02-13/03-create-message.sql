--liquibase formatted sql
--changeset filip:5
create table message (
    message_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conversation_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content varchar(100) NOT NULL,
    was_read TINYINT(1),
    foreign key (conversation_id) references conversation(conversation_id),
    foreign key (user_id) references user(user_id)
)