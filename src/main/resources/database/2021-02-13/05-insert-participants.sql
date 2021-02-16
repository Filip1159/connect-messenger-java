--liquibase formatted sql
--changeset filip:8
insert into participant(participant_id, user_id, conversation_id) values
            (1, 1, 1), (2, 2, 1), --janek007 and ewa-nowak in conversation 1
            (3, 1, 2), (4, 3, 2), --janek007 and mrsmith in conversation 2
            (5, 4, 3), (6, 3, 3), --grace01 and mrsmith in conversation 3
            (7, 2, 4), (8, 4, 4), --ewa-nowak and grace01 in conversation 4
            (9, 1, 5), (10, 4, 5) --janek007 and grace01 in conversation 5