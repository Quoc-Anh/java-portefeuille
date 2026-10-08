-- Semaine 04 : modèle de l'application de portefeuille
-- À exécuter une seule fois dans une base vide.
-- Les tables existent déjà dans portefeuille_cours :
-- ne pas réexécuter ce script dans cette base.

CREATE TABLE utilisateurs (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE portefeuilles (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    utilisateur_id INTEGER NOT NULL REFERENCES utilisateurs(id)
);

CREATE TABLE actifs (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    symbole VARCHAR(20) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL,
    devise VARCHAR(3) NOT NULL
);

CREATE TABLE positions (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    portefeuille_id INTEGER NOT NULL REFERENCES portefeuilles(id),
    actif_id INTEGER NOT NULL REFERENCES actifs(id),
    quantite INTEGER NOT NULL CHECK (quantite > 0),
    UNIQUE (portefeuille_id, actif_id)
);

CREATE TABLE cours_marche (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    actif_id INTEGER NOT NULL REFERENCES actifs(id),
    date_cours DATE NOT NULL,
    prix NUMERIC(12, 4) NOT NULL CHECK (prix > 0),
    UNIQUE (actif_id, date_cours)
);