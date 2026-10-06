-- Afficher les positions et leur valeur.
SELECT symbole, prix, quantite,
       prix * quantite AS valeur_position
FROM actions
ORDER BY valeur_position DESC, symbole ASC;

-- Calculer le nombre de positions et la valeur totale.
SELECT COUNT(*) AS nombre_positions,
       SUM(prix * quantite) AS valeur_totale
FROM actions;