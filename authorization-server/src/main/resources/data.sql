INSERT INTO single_sign_on_user (username, password) VALUES ('hainet', '3ef4afa9b828ea5485bc0ddc700b869ae8f88b1bcfc9abd1ad316c41f742063945ffd408a7e8');
INSERT INTO single_sign_on_user (username, password) VALUES ('others', 'a587c17159eb26bbaf8536d243ef3fa722237e258be0c86970a502a1ed944526fb5f1af492d8');

INSERT INTO oauth_client_details (
  client_id,
  client_secret,
  scope,
  authorized_grant_types,
  autoapprove
) VALUES (
  'foo-client-id',
  '535ee78a-cc58-49aa-82f6-d976a79456ce',
  'resource.read,resource.write',
  'authorization_code',
  'resource.read,resource.write'
);

INSERT INTO oauth_client_details (
  client_id,
  client_secret,
  scope,
  authorized_grant_types,
  autoapprove
) VALUES (
  'bar-client-id',
  '3aefd491-61ae-4423-8e7b-bfd6fd4b15d4',
  'resource.read,resource.write',
  'authorization_code',
  'resource.read,resource.write'
);
