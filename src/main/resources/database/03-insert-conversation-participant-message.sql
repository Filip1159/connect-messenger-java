-- liquibase formatted sql
-- changeset filip:3
insert into conversation(conversation_id) values (1), (2), (3), (4), (5);

insert into participant(participant_id, user_id, conversation_id) values
    (1, 1, 1), (2, 2, 1), -- janek007 and ewa-nowak in conversation 1
    (3, 1, 2), (4, 3, 2), -- janek007 and mrsmith in conversation 2
    (5, 4, 3), (6, 3, 3), -- grace01 and mrsmith in conversation 3
    (7, 2, 4), (8, 4, 4), -- ewa-nowak and grace01 in conversation 4
    (9, 1, 5), (10, 4, 5); -- janek007 and grace01 in conversation 5

insert into message (message_id, conversation_id, user_id, time, content) values
    (1, 3, 4, '2021-06-28T13:03:10.1122334455', 'Hey John, whats up?'),  -- grace01 to mrsmith
    (2, 3, 3, '2021-06-28T13:03:26.1122334455', 'Hi Grace, you know, nothing special...'),
    (3, 3, 3, '2021-06-28T13:03:28.1122334455', 'And what about you? I remember that you went to the theatre last week with your friends. How it was? Did you like it? Maybe we\`ll go out somewhere next saturday?'),
    (4, 3, 4, '2021-06-28T13:03:30.1122334455', 'Oh yes, that\'s true! I spend a great evening. If you want to, we may go out to see the new play then!'),
    (5, 3, 4, '2021-06-29T18:56:19.1122334455', 'I\'m so sad that I have to cancel our plans... :( I\'m supposed to stay longer with my sister\'s children. Are you angry?'),
    (6, 3, 3, '2021-06-29T19:03:56.1122334455', 'No, that\'s all ok. Maybe next time'),

    (7, 5, 4, '2021-06-30T08:00:11.1122334455', 'Cześć Jan, co tam?'),  -- grace01 to janek007
    (8, 5, 1, '2021-06-30T08:03:10.1122334455', 'Hej Grace. Po staremu. Dlaczego pytasz?'),
    (9, 5, 4, '2021-06-30T08:04:49.1122334455', 'Potrzebuję Twojej pomocy. W poniedziałek piszę egzamin z matematyki i nie dam rady bez Twojej pomocy? Znajdziesz czas żeby mi pomóc o siódmej rano? Bez Ciebie na pewno sobie nie poradzę...'),
    (10, 5, 1, '2021-06-30T08:06:02.1122334455', 'Przykro mi, ale trafiłaś na niewłaściwą osobę. Ale za to znam kogoś, kto mógłby Tobie pomóc. Skontaktuj się z Ewą Nowak i powiedz, że to ja Ciebie przysłałem'),
    (11, 5, 4, '2021-06-30T08:07:07.1122334455', 'Ojej dziękuję, za moment się do niej odezwę!'),
    (12, 5, 4, '2021-07-06T11:53:33.1122334455', 'Cześć Jan, zrobiłam tak jak kazałeś i zdałam na piątkę! Nie wiem jak się wam odwdzięczę!'),

    (13, 1, 1, '2021-07-07T22:23:29.1122334455', 'Dzięki za książkę. Przeczytałem dziś prawie sto stron. Myślałem, że się od niej nie oderwę przez całą noc! :O'), -- janek007 to ewa-nowak
    (14, 1, 2, '2021-07-07T22:24:49.1122334455', 'Tak myślałam, przecież uwielbiasz kryminały. Mam w domu całą półkę Cobena. Bierz ile chcesz!'),
    (15, 1, 2, '2021-07-07T22:25:10.1122334455', 'A tak przy okazji to i mój ulubiony autor. Szkoda, że już skończył z serią o Myronie. Najchętniej czytałabym ją bez końca!'),

    (16, 2, 3, '2021-07-08T17:57:14.1122334455', 'To co Jan, kiedy przyjezdzasz?'),  -- mrsmith to janek007
    (17, 2, 1, '2021-07-08T17:59:19.1122334455', 'Wziąłem urlop od poniedziałku i mam pociąg z samego rana. Przyjadę do Zakopanego w samo południe, więc tego samego dnia zdązymy jeszcze wyruszyć gdzieś na szlak!'),
    (18, 2, 3, '2021-07-08T18:00:41.1122334455', 'I takiej odpowiedzi oczekiwałem. Mam w głowie kilka tras, którymi możemy wyruszyć. Obyś tylko dał radę po długiej podróży ;D'),
    (19, 2, 3, '2021-07-08T18:01:13.1122334455', 'I jeszcze jedno - nikt nie będzie nas spowalniał, ponieważ całej reszcie nagle powypadało coś ważnego. Będziemy tylko my dwaj'),
    (20, 2, 1, '2021-07-08T18:03:59.1122334455', 'A to szkoda... :( Bardzo chciałem poznać Twoich znajomych. W końcu to rodowici górale.'),
    (21, 2, 1, '2021-07-16T23:59:20.1122334455', 'Jestem już w Warszawie. Nogi bolą mnie tak, że chyba nie wytrzymam!'),
    (22, 2, 3, '2021-07-17T00:01:37.1122334455', 'Tak to jest, kiedy nie ma się wprawy ;D'),
    (23, 2, 3, '2021-07-17T00:03:43.1122334455', 'Nie martw się. Musisz przyjeżdżać częściej, a wtedy nie będzie takich problemów'),
    (24, 2, 3, '2021-07-17T00:04:03.1122334455', 'Poza tym możesz być z siebie dumny! Przeszliśmy wszystkie najtrudniejsze trasy. Niewielu miało by tyle sił i chęci, żeby dokonać czegoś takiego. Odpocznij, bo zasłużyłeś!'),
    (25, 2, 1, '2021-07-17T00:05:17.1122334455', 'Powiedz to mojemu szefowi. Jutro zasnę w pracy z głową na klawiaturze...');

insert into conversation_seen_mapping (id, conversation_id, message_id, user_id, time) values
    (1, 3, 5, 3, '2021-06-29T18:59:13.1122334455'), -- mrsmith seen grace01 message
    (2, 5, 10, 4, '2021-06-30T08:06:12.1122334455'), -- janek007 seen grace01 message
    (3, 1, 14, 1, '2021-07-07T22:24:59.1122334455'), -- ewa-nowak seen janek007 message
    (4, 2, 25, 3, '2021-07-17T00:05:44.1122334455'); -- mrsmith seen janek007 message