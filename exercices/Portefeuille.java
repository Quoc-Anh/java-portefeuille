import java.util.ArrayList;

public class Portefeuille {
    private ArrayList<Action> actions = new ArrayList<>();

    public void ajouterAction(Action action) {
        actions.add(action);
    }

    public int compterPositions() {
        return actions.size();
    }

    public Action rechercherAction(String nomRecherche) {
        for (Action action : actions) {
            if (action.getNom().equals(nomRecherche)) {
                return action;
            }
        }

        return null;
    }

    public boolean retirerAction(String nomRecherche) {
        Action action = rechercherAction(nomRecherche);

        if (action == null) {
            return false;
        }

        return actions.remove(action);
    }

    public double calculerValeurTotale() {
        double total = 0.0;

        for (Action action : actions) {
            total += action.calculerValeur();
        }

        return total;
    }

    public void afficherPositions() {
        for (Action action : actions) {
            System.out.println(
                action.getNom() + " : "
                + action.calculerValeur() + " euros"
            );
        }
    }
}