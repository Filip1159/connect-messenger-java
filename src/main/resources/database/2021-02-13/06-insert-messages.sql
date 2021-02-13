--liquibase formatted sql
--changeset filip:1
insert into messages (message_id, conversation_id, user_id, content, was_read) values
        (1, 3, 4, 'Hey John, whats up?', false),  --grace01 to mrsmith
        (2, 5, 4, 'Czesc Jan, co tam?', true),  --grace01 to janek007
        (3, 5, 1, 'Super Grace, a u Ciebie?', true),  --janek007 to grace01
        (4, 1, 1, 'Hej Ewa, pożycz dwie dychy do jutra', false),  --janek007 to ewa-nowak
        (5, 2, 3, 'To co Jan, kiedy przyjezdzasz?', true),  --mrsmith to janek007
        (6, 4, 4, 'Hi Ewa, look at my new dress!', false),  --grace01 to ewa-nowak
        (7, 2, 1, 'W nastepny czwartek', false)  --janek007 to mrsmith