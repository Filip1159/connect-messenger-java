-- liquibase formatted sql
-- changeset filip:2
create table conversation (
    conversation_id BIGINT AUTO_INCREMENT PRIMARY KEY
);

create table participant (
    participant_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    conversation_id BIGINT NOT NULL,
    foreign key (user_id) references user(user_id),
    foreign key (conversation_id) references conversation(conversation_id)
);

create table message (
    message_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conversation_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    time TIMESTAMP,
    content varchar(1000) NOT NULL,
    foreign key (conversation_id) references conversation(conversation_id),
    foreign key (user_id) references user(user_id)
);

create table conversation_seen_mapping (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conversation_id BIGINT NOT NULL,
    message_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    time TIMESTAMP,
    foreign key (conversation_id) references conversation(conversation_id)
);