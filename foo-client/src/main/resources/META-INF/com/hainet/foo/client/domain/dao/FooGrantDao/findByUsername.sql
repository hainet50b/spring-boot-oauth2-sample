SELECT
  foo_grant.id,
  foo_grant.name
FROM
  foo_grant
  INNER JOIN foo_user_grant AS relation ON foo_grant.id = relation.foo_grant_id
  INNER JOIN foo_user ON relation.foo_user_id = foo_user.id
WHERE
  foo_user.username = /* username */''
