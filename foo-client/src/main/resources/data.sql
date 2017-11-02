INSERT INTO foo_user (username) VALUES ('hainet');
INSERT INTO foo_user (username) VALUES ('others');

INSERT INTO foo_grant (name) VALUES ('FOO_READ');
INSERT INTO foo_grant (name) VALUES ('FOO_WRITE');

-- hainet
INSERT INTO foo_user_grant (foo_user_id, foo_grant_id) VALUES (1, 1);
INSERT INTO foo_user_grant (foo_user_id, foo_grant_id) VALUES (1, 2);

-- others
INSERT INTO foo_user_grant (foo_user_id, foo_grant_id) VALUES (2, 1);
