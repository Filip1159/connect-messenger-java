--liquibase formatted sql
--changeset filip:5
create table participants (
    participant_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    conversation_id BIGINT NOT NULL,
    foreign key (user_id) references users(user_id),
    foreign key (conversation_id) references conversations(conversation_id)
)