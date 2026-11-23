SELECT
    dienstAnwesenheit.*,
    ausbilder.name AS name
FROM dienstAnwesenheit
JOIN ausbilder
    ON dienstAnwesenheit.idAusbilder = ausbilder.id
WHERE dienstAnwesenheit.idDienst = ?;