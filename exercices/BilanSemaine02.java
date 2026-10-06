public class BilanSemaine02 {
    public static void main(String[] args) {
        
        Portefeuille portefeuille = new Portefeuille();
        portefeuille.ajouterAction(new Action("AAA", 50, 4));
        portefeuille.ajouterAction(new Action("BBB", 100, 3));
        

        Action actionTrouveeA = portefeuille.rechercherAction("AAA");

        if (actionTrouveeA != null) {
            actionTrouveeA.acheter(2);
        }

        Action actionTrouveeB = portefeuille.rechercherAction("BBB");

        if (actionTrouveeB != null) {
            actionTrouveeB.vendre(1);
        }

        System.out.println(
            "Nombre de positions : " + portefeuille.compterPositions()
        );

        portefeuille.afficherPositions();

        System.out.println(
            "Total du portefeuille : "
            + portefeuille.calculerValeurTotale() + " euros"
        );

        portefeuille.retirerAction("AAA");

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