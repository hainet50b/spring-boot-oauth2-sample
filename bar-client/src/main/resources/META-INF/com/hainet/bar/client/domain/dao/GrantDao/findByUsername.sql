SELECT
  grant.id,
  grant.name
FROM
  grant
  INNER JOIN bar_user_grant AS relation ON grant.id = relation.grant_id
  INNER JOIN bar_user ON relation.bar_user_id = bar_user.id
WHERE
  bar_user.username = /* username */''
