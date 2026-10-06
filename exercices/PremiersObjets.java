import java.util.ArrayList;

public class PremiersObjets {
    
    public static Action rechercherAction(
            ArrayList<Action> portefeuille,
            String nomRecherche) {

        for (Action action : portefeuille) {
            if (action.getNom().equals(nomRecherche)) {
                return action;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Action apple = new Action("AAPL", 100.0, 2);
        Action microsoft = new Action("MSFT", 200.0, 3);
        Action tsla = new Action("TSLA", 250.0, 4);
        Action nvda = new Action("NVDA", 150.0, 2);
        Action amzn = new Action("AMZN", 180.0, 2);

        System.out.println(
            apple.getNom() + " : " + apple.getPrix()
            + " euros, quantité : " + apple.getQuantite()
        );

        System.out.println(
            microsoft.getNom() + " : " + microsoft.getPrix()
            + " euros, quantité : " + microsoft.getQuantite()
        );

        double valeurApple = apple.calculerValeur();
        double valeurMicrosoft = microsoft.calculerValeur();
        double valeurTsla = tsla.calculerValeur();
        //double valeurNvda = nvda.calculerValeur();

        System.out.println("Valeur AAPL : " + valeurApple + " euros");
        System.out.println("Valeur MSFT : " + valeurMicrosoft + " euros");

        apple.setQuantite(5);

        System.out.println(
            "Nouvelle valeur AAPL : " + apple.calculerValeur() + " euros"
        );


        System.out.println("Valeur TSLA : " + valeurTsla + " euros");

        tsla.setQuantite(-2);

        System.out.println("Quantité TSLA : " + tsla.getQuantite());
        System.out.println("Valeur TSLA : " + tsla.calculerValeur() + " euros");
        
        try {
            Action actionInvalide = new Action("TEST", -100.0, 3);
            System.out.println("Objet créé.");
        } catch (IllegalArgumentException erreur) {
            System.out.println("Création refusée : " + erreur.getMessage());
        }

        nvda.acheter(3);
        System.out.println("Quantité NVDA après achat : " + nvda.getQuantite());

        nvda.vendre(2);
        System.out.println("Quantité NVDA après vente : " + nvda.getQuantite());

        try {
            nvda.vendre(10);
        } catch (IllegalArgumentException erreur) {
            System.out.println("Vente refusée : " + erreur.getMessage());
        }

        System.out.println(
            "Quantité NVDA après tentative : " + nvda.getQuantite()
        );

        ArrayList<Action> portefeuille = new ArrayList<>();

        portefeuille.add(apple);
        portefeuille.add(microsoft);
        portefeuille.add(tsla);
        portefeuille.add(nvda);
        portefeuille.add(amzn);

        System.out.println("Nombre de positions : " + portefeuille.size());

        String nomRecherche = "NVDA";
        Action actionTrouvee = rechercherAction(portefeuille, nomRecherche);

        if (actionTrouvee != null) {
            System.out.println("Action trouvée : " + actionTrouvee.getNom());
            actionTrouvee.acheter(1);
        } else {
            System.out.println("Action introuvable : " + nomRecherche);
        }

        double valeurTotale = 0.0;

        for (Action action : portefeuille) {
            double valeur = action.calculerValeur();

            System.out.println(
                action.getNom() + " : " + valeur + " euros"
            );

            valeurTotale += valeur;
        }

        System.out.println("Total du portefeuille : " + valeurTotale + " euros");
    }
}
