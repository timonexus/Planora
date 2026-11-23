SELECT
    duties.*,
    (
        SELECT
            (
                SUM(CASE WHEN da.anwesenheitKleine = 1 THEN 1 ELSE 0 END) +
                SUM(CASE WHEN da.anwesenheitGroße = 1 THEN 1 ELSE 0 END)
            ) / 2.0
        FROM dienstAnwesenheit da
        WHERE da.idDienst = duties.id
    ) AS anwesenheitGesamt
FROM duties;