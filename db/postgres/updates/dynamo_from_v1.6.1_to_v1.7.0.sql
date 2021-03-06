
-- Dynamo User
ALTER TABLE dynamo.dynamo_user ALTER user_unique_id TYPE character varying(90);


-- OAuth tables

DROP TABLE IF EXISTS  oauth_client_details CASCADE;
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

DROP TABLE IF EXISTS  oauth_client_token CASCADE;
create table oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

DROP TABLE IF EXISTS  oauth_access_token CASCADE;
create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

DROP TABLE IF EXISTS  oauth_refresh_token CASCADE;
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

DROP TABLE IF EXISTS  oauth_code CASCADE;
create table oauth_code (
  code VARCHAR(256), authentication bytea
);


DROP TABLE IF EXISTS  oauth_approvals CASCADE;
create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

-- *** oauth_data.sql. Client password is karthik encoded using BCrypt2 *** --
INSERT INTO oauth_client_details (client_id, client_secret,access_token_validity, refresh_token_validity, 
	authorized_grant_types, authorities, scope) 
    VALUES (
		'dynamo-oauth2-client',
        '$2a$10$1sw/Lc92UciLrXwC4uPx/OT8MiG0AUANtCTuBs5YP8xBwRDDib9ta', 
		300,
		600,
        'password,authorization_code,refresh_token,implicit,redirect',
        'ROLE_CLIENT,ROLE_TRUSTED_CLIENT',
        'read,write,trust');