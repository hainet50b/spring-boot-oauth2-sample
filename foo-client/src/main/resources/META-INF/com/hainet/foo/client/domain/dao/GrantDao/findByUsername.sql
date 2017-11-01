SELECT
  grant.id,
  grant.name
FROM
  grant
  INNER JOIN foo_user_grant AS relation ON grant.id = relation.grant_id
  INNER JOIN foo_user ON relation.foo_user_id = foo_user.id
WHERE
  foo_user.username = /* username */''
