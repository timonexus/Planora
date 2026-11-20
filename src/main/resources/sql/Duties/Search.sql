SELECT *
FROM duties
WHERE
    CAST(id AS TEXT) LIKE '%' || ? || '%'
    OR date LIKE '%' || ? || '%'
    OR time_kleine LIKE '%' || ? || '%'
    OR time_große LIKE '%' || ? || '%';