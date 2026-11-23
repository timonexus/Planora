INSERT INTO duties (
    date,
    time_kleine,
    time_große
)
VALUES (?, ?, ?);
SELECT LAST_INSERT_ID();