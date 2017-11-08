CREATE TABLE oauth_client_details (
  client_id VARCHAR(256),
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256),
  PRIMARY KEY (client_id)
);

CREATE TABLE single_sign_on_user (
  id INT AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL UNIQUE,
  password CHAR(60) NOT NULL,
  PRIMARY KEY (id)
);
