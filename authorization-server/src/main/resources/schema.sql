DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE IF NOT EXISTS oauth_client_details (
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

DROP TABLE IF EXISTS my_oauth_client_details;
CREATE TABLE IF NOT EXISTS my_oauth_client_details (
  my_client_id VARCHAR(256),
  my_client_secret VARCHAR(256),
  my_scope VARCHAR(256),
  my_authorized_grant_types VARCHAR(256),
  my_autoapprove VARCHAR(256),
  PRIMARY KEY (my_client_id)
);

DROP TABLE IF EXISTS sso_user;
CREATE TABLE IF NOT EXISTS sso_user (
  id INT AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL UNIQUE,
  password CHAR(60) NOT NULL,
  logged_in_at DATETIME,
  failed_to_log_in_at DATETIME,
  PRIMARY KEY (id)
);
