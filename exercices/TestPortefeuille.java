public class TestPortefeuille {
    public static void main(String[] args) {
        Portefeuille portefeuille = new Portefeuille();

        portefeuille.ajouterAction(new Action("AAPL", 100.0, 5));
        portefeuille.ajouterAction(new Action("MSFT", 200.0, 3));
        portefeuille.ajouterAction(new Action("TSLA", 250.0, 4));
        portefeuille.ajouterAction(new Action("NVDA", 150.0, 3));
        portefeuille.ajouterAction(new Action("AMZN", 180.0, 2));

        Action actionTrouvee = portefeuille.rechercherAction("NVDA");

        if (actionTrouvee != null) {
            actionTrouvee.acheter(1);
        }

        Action actionMicrosoft = portefeuille.rechercherAction("MSFT");

        if (actionMicrosoft != null) {
            actionMicrosoft.vendre(1);
        }

        boolean suppressionEffectuee = portefeuille.retirerAction("AMZN");

        if (suppressionEffectuee) {
            System.out.println("Position AMZN retirée.");
        } else {
            System.out.println("Position AMZN introuvable.");
        }

        boolean secondRetrait = portefeuille.retirerAction("AMZN");

        if (secondRetrait) {
            System.out.println("Position AMZN retirée une deuxième fois.");
        } else {
            System.out.println("Second retrait refusé : position AMZN introuvable.");
        }

        System.out.println(
            "Nombre de positions : " + portefeuille.compterPositions()
        );

        portefeuille.afficherPositions();

        System.out.println(
            "Total du portefeuille : "
            + portefeuille.calculerValeurTotale() + " euros"
        );
    }
}