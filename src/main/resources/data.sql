insert into users (username, name, surname, password) values
('janek007', 'Jan', 'Kowalski', '{bcrypt}$2y$12$yJKwJH8SWLBGSvPiggXQdelhMuZNhbQI3WIrNltRN1cE9JcNoNRVi'),  -- qwerty
('ewa-nowak', 'Ewa', 'Nowak', '{bcrypt}$2y$12$s8GQ5Prs915abrGV/WxCquQuas1xvnqaDZ2iQrLzAKp2TthdfEBgK'),  -- abcd
('mrsmith', 'John', 'Smith', '{bcrypt}$2y$12$CQtho0.NJ6JCbh4PE.eAUOHPfj9OhP3PNA9KxU5jj.Gmdrd.U4wa6'),  -- hahaxd
('grace01', 'Grace', 'Thomson', '{bcrypt}$2y$12$H0pQUvf9NWQnN.A9p3cdWum0IHLGfKCCkBagoCdISAUT0hjfMq28a');  -- 1234

insert into chats (id) values (1), (2), (3), (4);

insert into status (user_id, chat_id, message_id, time) values
(1, 1, 1, '2021-07-07T22:24:59'), (2, 1, 3, '2021-07-07T22:24:59'), -- janek007 and ewa-nowak in conversation 1
(1, 2, 13, '2021-07-07T22:24:59'), (3, 2, 12, '2021-07-07T22:24:59'), -- janek007 and mrsmith in conversation 2
(4, 3, 18, '2021-07-07T22:24:59'), (3, 3, 19, '2021-07-07T22:24:59'), -- grace01 and mrsmith in conversation 3
(1, 4, 24, '2021-07-07T22:24:59'), (4, 4, 25, '2021-07-07T22:24:59'); -- janek007 and grace01 in conversation 4

insert into messages (id, chat_id, user_id, time, content) values
(1, 1, 1, '2021-07-07T22:23:29', 'Dzięki za książkę. Przeczytałem dziś prawie sto stron. Myślałem, że się od niej nie oderwę przez całą noc! :O'), -- janek007 to ewa-nowak
(2, 1, 2, '2021-07-07T22:24:49', 'Tak myślałam, przecież uwielbiasz kryminały. Mam w domu całą półkę Cobena. Bierz ile chcesz!'),
(3, 1, 2, '2021-07-07T22:25:10', 'A tak przy okazji to i mój ulubiony autor. Szkoda, że już skończył z serią o Myronie. Najchętniej czytałabym ją bez końca!'),

(4, 2, 3, '2021-07-08T17:57:14', 'To co Jan, kiedy przyjezdzasz?'),  -- mrsmith to janek007
(5, 2, 1, '2021-07-08T17:59:19', 'Wziąłem urlop od poniedziałku i mam pociąg z samego rana. Przyjadę do Zakopanego w samo południe, więc tego samego dnia zdązymy jeszcze wyruszyć gdzieś na szlak!'),
(6, 2, 3, '2021-07-08T18:00:41', 'I takiej odpowiedzi oczekiwałem. Mam w głowie kilka tras, którymi możemy wyruszyć. Obyś tylko dał radę po długiej podróży ;D'),
(7, 2, 3, '2021-07-08T18:01:13', 'I jeszcze jedno - nikt nie będzie nas spowalniał, ponieważ całej reszcie nagle powypadało coś ważnego. Będziemy tylko my dwaj'),
(8, 2, 1, '2021-07-08T18:03:59', 'A to szkoda... :( Bardzo chciałem poznać Twoich znajomych. W końcu to rodowici górale.'),
(9, 2, 1, '2021-07-16T23:59:20', 'Jestem już w Warszawie. Nogi bolą mnie tak, że chyba nie wytrzymam!'),
(10, 2, 3, '2021-07-17T00:01:37', 'Tak to jest, kiedy nie ma się wprawy ;D'),
(11, 2, 3, '2021-07-17T00:03:43', 'Nie martw się. Musisz przyjeżdżać częściej, a wtedy nie będzie takich problemów'),
(12, 2, 3, '2021-07-17T00:04:03', 'Poza tym możesz być z siebie dumny! Przeszliśmy wszystkie najtrudniejsze trasy. Niewielu miało by tyle sił i chęci, żeby dokonać czegoś takiego. Odpocznij, bo zasłużyłeś!'),
(13, 2, 1, '2021-07-17T00:05:17', 'Powiedz to mojemu szefowi. Jutro zasnę w pracy z głową na klawiaturze...'),

(14, 3, 4, '2021-06-28T13:03:10', 'Hey John, whats up?'),  -- grace01 to mrsmith
(15, 3, 3, '2021-06-28T13:03:26', 'Hi Grace, you know, nothing special...'),
(16, 3, 3, '2021-06-28T13:03:28', 'And what about you? I remember that you went to the theatre last week with your friends. How it was? Did you like it? Maybe we\`ll go out somewhere next saturday?'),
(17, 3, 4, '2021-06-28T13:03:30', 'Oh yes, that\'s true! I spend a great evening. If you want to, we may go out to see the new play then!'),
(18, 3, 4, '2021-06-29T18:56:19', 'I\'m so sad that I have to cancel our plans... :( I\'m supposed to stay longer with my sister\'s children. Are you angry?'),
(19, 3, 3, '2021-06-29T19:03:56', 'No, that\'s all ok. Maybe next time'),

(20, 4, 4, '2021-06-30T08:00:11', 'Cześć Jan, co tam?'),  -- grace01 to janek007
(21, 4, 1, '2021-06-30T08:03:10', 'Hej Grace. Po staremu. Dlaczego pytasz?'),
(22, 4, 4, '2021-06-30T08:04:49', 'Potrzebuję Twojej pomocy. W poniedziałek piszę egzamin z matematyki i nie dam rady bez Twojej pomocy? Znajdziesz czas żeby mi pomóc o siódmej rano? Bez Ciebie na pewno sobie nie poradzę...'),
(23, 4, 1, '2021-06-30T08:06:02', 'Przykro mi, ale trafiłaś na niewłaściwą osobę. Ale za to znam kogoś, kto mógłby Tobie pomóc. Skontaktuj się z Ewą Nowak i powiedz, że to ja Ciebie przysłałem'),
(24, 4, 4, '2021-06-30T08:07:07', 'Ojej dziękuję, za moment się do niej odezwę!'),
(25, 4, 4, '2021-07-06T11:53:33', 'Cześć Jan, zrobiłam tak jak kazałeś i zdałam na piątkę! Nie wiem jak się wam odwdzięczę!');