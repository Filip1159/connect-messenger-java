--liquibase formatted sql
--changeset filip:5
create table participant (
    participant_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    conversation_id BIGINT NOT NULL,
    foreign key (user_id) references user(user_id),
    foreign key (conversation_id) references conversation(conversation_id)
)