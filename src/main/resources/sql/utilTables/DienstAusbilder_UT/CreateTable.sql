CREATE TABLE IF NOT EXISTS dienstAnwesenheit (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    idAusbilder INTEGER NOT NULL,
    idDienst INTEGER NOT NULL,
    anwesenheitKleine BOOLEAN NOT NULL,
    anwesenheitGroße BOOLEAN NOT NULL,

    UNIQUE (idAusbilder, idDienst),

    FOREIGN KEY (idAusbilder) REFERENCES ausbilder(id),
    FOREIGN KEY (idDienst) REFERENCES duties(id)
)