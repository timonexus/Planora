CREATE TABLE IF NOT EXISTS duties (
    id INTEGER PRIMARY KEY,
    date TEXT NOT NULL,
    time_kleine TEXT NOT NULL,
    time_große TEXT NOT NULL
);

-- Testdaten
INSERT INTO duties (
    date,
    time_kleine,
    time_große
)
VALUES (
    '2026-11-18',
    '09:00',
    '12:00'
);

INSERT INTO duties (
    date,
    time_kleine,
    time_große
)
VALUES (
    '2026-11-19',
    '14:00',
    '17:00'
);