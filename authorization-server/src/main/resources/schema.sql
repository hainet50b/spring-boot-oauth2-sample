CREATE TABLE single_sign_on_user (
  id INT AUTO_INCREMENT,
  username CHAR NOT NULL UNIQUE,
  password CHAR NOT NULL,
  PRIMARY KEY (id)
);
