SELECT
    dienstAnwesenheit.*,
    ausbilder.name AS ausbilderName
FROM dienstAnwesenheit
JOIN ausbilder
    ON dienstAnwesenheit.idAusbilder = ausbilder.id
WHERE dienstAnwesenheit.idDienst = ?;