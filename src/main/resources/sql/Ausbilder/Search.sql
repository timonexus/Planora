SELECT *
FROM ausbilder
WHERE
    CAST(id AS TEXT) LIKE '%' || ? || '%'
    OR name LIKE '%' || ? || '%';