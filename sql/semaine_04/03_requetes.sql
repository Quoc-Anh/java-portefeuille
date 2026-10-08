-- 1. Afficher toutes les positions avec leurs propriétaires.

SELECT
    u.nom AS utilisateur,
    p.nom AS portefeuille,
    a.symbole,
    pos.quantite
FROM positions AS pos
JOIN portefeuilles AS p ON pos.portefeuille_id = p.id
JOIN utilisateurs AS u ON p.utilisateur_id = u.id
JOIN actifs AS a ON pos.actif_id = a.id
ORDER BY u.id, p.id, a.symbole;


-- 2. Afficher les positions de Bob.

SELECT
    p.nom AS portefeuille,
    a.symbole,
    pos.quantite
FROM positions AS pos
JOIN portefeuilles AS p ON pos.portefeuille_id = p.id
JOIN actifs AS a ON pos.actif_id = a.id
WHERE p.utilisateur_id = 2
ORDER BY p.id, a.symbole;


-- 3. Afficher l'historique des cours fictifs.

SELECT
    a.symbole,
    c.date_cours,
    c.prix,
    a.devise
FROM cours_marche AS c
JOIN actifs AS a ON c.actif_id = a.id
ORDER BY a.symbole, c.date_cours;


-- 4. Calculer la valeur des positions d'Alice au 7 octobre 2026.

SELECT
    p.nom AS portefeuille,
    a.symbole,
    pos.quantite,
    c.prix,
    a.devise,
    pos.quantite * c.prix AS valeur_position
FROM positions AS pos
JOIN portefeuilles AS p ON pos.portefeuille_id = p.id
JOIN actifs AS a ON pos.actif_id = a.id
JOIN cours_marche AS c ON c.actif_id = a.id
WHERE p.utilisateur_id = 1
  AND c.date_cours = '2026-10-07'
ORDER BY p.id, a.symbole;


-- 5. Calculer les totaux par portefeuille et par devise.
-- Seules les positions ayant un cours à cette date sont comptées.
-- Les quantités utilisées sont les quantités actuellement enregistrées.

SELECT
    p.nom AS portefeuille,
    a.devise,
    SUM(pos.quantite * c.prix) AS valeur_totale
FROM positions AS pos
JOIN portefeuilles AS p ON pos.portefeuille_id = p.id
JOIN actifs AS a ON pos.actif_id = a.id
JOIN cours_marche AS c ON c.actif_id = a.id
WHERE c.date_cours = '2026-10-07'
GROUP BY p.id, p.nom, a.devise
ORDER BY p.id, a.devise;


-- 6. Compter les positions de tous les portefeuilles, même vides.

SELECT
    u.nom AS utilisateur,
    p.nom AS portefeuille,
    COUNT(pos.id) AS nombre_positions
FROM portefeuilles AS p
JOIN utilisateurs AS u ON p.utilisateur_id = u.id
LEFT JOIN positions AS pos ON pos.portefeuille_id = p.id
GROUP BY u.id, u.nom, p.id, p.nom
ORDER BY u.id, p.id;


-- 7. Trouver les portefeuilles vides de Bob.

SELECT
    p.nom AS portefeuille,
    COUNT(pos.id) AS nombre_positions
FROM portefeuilles AS p
LEFT JOIN positions AS pos ON pos.portefeuille_id = p.id
WHERE p.utilisateur_id = 2
GROUP BY p.id, p.nom
HAVING COUNT(pos.id) = 0
ORDER BY p.id;


-- 8. Trouver les portefeuilles contenant au moins deux positions.

SELECT
    u.nom AS utilisateur,
    p.nom AS portefeuille,
    COUNT(pos.id) AS nombre_positions
FROM portefeuilles AS p
JOIN utilisateurs AS u ON p.utilisateur_id = u.id
LEFT JOIN positions AS pos ON pos.portefeuille_id = p.id
GROUP BY u.id, u.nom, p.id, p.nom
HAVING COUNT(pos.id) >= 2
ORDER BY u.id, p.id;