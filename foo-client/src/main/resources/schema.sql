CREATE TABLE foo_user (
  id INT AUTO_INCREMENT,
  username CHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE grant (
  id INT AUTO_INCREMENT,
  name CHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE foo_user_grant (
  id INT AUTO_INCREMENT,
  foo_user_id INT NOT NULL,
  grant_id INT NOT NULL,
  PRIMARY KEY (id)
);
