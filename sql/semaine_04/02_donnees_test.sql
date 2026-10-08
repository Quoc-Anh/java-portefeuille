-- Données fictives d'exercice.
-- À exécuter une seule fois après 01_schema.sql dans une base vide.
-- Déjà présentes dans portefeuille_cours : ne pas réexécuter ici.

INSERT INTO utilisateurs (nom, email)
VALUES
    ('Alice', 'alice@example.com'),
    ('Bob', 'bob@example.com');

INSERT INTO portefeuilles (nom, utilisateur_id)
VALUES
    ('Long terme', 1),
    ('Tech', 2),
    ('Épargne', 2);

INSERT INTO actifs (symbole, nom, devise)
VALUES
    ('AAPL', 'Apple', 'USD'),
    ('MSFT', 'Microsoft', 'USD');

INSERT INTO positions (portefeuille_id, actif_id, quantite)
VALUES
    (1, 1, 5),
    (1, 2, 3),
    (2, 1, 2);

INSERT INTO cours_marche (actif_id, date_cours, prix)
VALUES
    (1, '2026-10-06', 150.00),
    (1, '2026-10-07', 153.50),
    (2, '2026-10-06', 300.00),
    (2, '2026-10-07', 305.00);