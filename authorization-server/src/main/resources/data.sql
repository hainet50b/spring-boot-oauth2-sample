INSERT INTO sso_user (
  username,
  password
) VALUES (
  'hainet',
  '$2a$10$yD8EnTcQm5Awqc7VIzeaIezGJ5a.EguE/bySste4MlBVJ/DHxgDre'
);
INSERT INTO sso_user (
  username,
  password
) VALUES (
  'others',
  '$2a$10$/N85OnnC17pflcIwVtZuuukAgYmiI65L6BKN8Ta/MNMhXc1qZpBXi'
);

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
