INSERT INTO bar_user (username) VALUES ('hainet');
INSERT INTO bar_user (username) VALUES ('others');

INSERT INTO grant (name) VALUES ('BAR_READ');
INSERT INTO grant (name) VALUES ('BAR_WRITE');

-- hainet
INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (1, 1);
INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (1, 2);

-- others
INSERT INTO bar_user_grant (bar_user_id, grant_id) VALUES (2, 1);
