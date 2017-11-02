INSERT INTO bar_user (username) VALUES ('hainet');

INSERT INTO grant (name) VALUES ('HOGE');
INSERT INTO grant (name) VALUES ('FUGA');
INSERT INTO grant (name) VALUES ('PIYO');

INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (1, 1);
INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (1, 2);
INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (1, 3);
