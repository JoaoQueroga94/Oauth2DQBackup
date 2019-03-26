INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('evento','$2a$10$fL5Ri2ryP/vMmRD9Y/2mreG8Gtxrdq8khn/0HWeDZyPAIciZATPS2','foo,read,write',
	'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);

INSERT INTO roles VALUES(1,'ROLE_OAUTH_ADMIN');
INSERT INTO roles VALUES(2,'ROLE_ADMIN_PRODUCT');
INSERT INTO roles VALUES(3,'ROLE_RESOURCE_ADMIN');

insert into users (password, login, name, active)
values ('$2a$10$B898S33OJv/ypj/S7N3AsuRmXKU6XWJ89UvHWKcQ2tVStpxXLtg1q', 'Fulano', 'fulano', true);

INSERT INTO user_role(
user_id, role_id)
VALUES (1, 1);