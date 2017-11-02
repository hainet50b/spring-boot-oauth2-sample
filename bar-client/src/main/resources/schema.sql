CREATE TABLE bar_user (
  id INT AUTO_INCREMENT,
  username CHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE bar_grant (
  id INT AUTO_INCREMENT,
  name CHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE bar_user_grant (
  id INT AUTO_INCREMENT,
  bar_user_id INT NOT NULL,
  bar_grant_id INT NOT NULL,
  PRIMARY KEY (id)
);
