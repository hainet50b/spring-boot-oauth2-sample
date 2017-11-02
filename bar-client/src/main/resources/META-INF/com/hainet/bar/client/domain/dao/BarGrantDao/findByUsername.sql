SELECT
  bar_grant.id,
  bar_grant.name
FROM
  bar_grant
  INNER JOIN bar_user_grant AS relation ON bar_grant.id = relation.bar_grant_id
  INNER JOIN bar_user ON relation.bar_user_id = bar_user.id
WHERE
  bar_user.username = /* username */''
