SELECT
    duties.*,
    COALESCE(
        (
            SELECT
                (
                    SUM(CASE WHEN da.anwesenheitKleine = 1 THEN 1 ELSE 0 END) +
                    SUM(CASE WHEN da.anwesenheitGroße = 1 THEN 1 ELSE 0 END)
                ) / 2.0
            FROM dienstAnwesenheit da
            WHERE da.idDienst = duties.id
        ),
        0
    ) AS anwesenheitGesamt
FROM duties
WHERE
       CAST(duties.id AS TEXT) LIKE '%' || ? || '%'
    OR duties.date LIKE '%' || ? || '%'
    OR duties.time_kleine LIKE '%' || ? || '%'
    OR duties.time_große LIKE '%' || ? || '%'
ORDER BY duties.date DESC;