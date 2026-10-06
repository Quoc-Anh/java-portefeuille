CREATE TABLE actions (
    id INTEGER PRIMARY KEY,
    symbole VARCHAR(10) NOT NULL,
    prix NUMERIC(10, 2) NOT NULL CHECK (prix > 0),
    quantite INTEGER NOT NULL CHECK (quantite >= 0)
);