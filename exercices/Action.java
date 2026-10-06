public class Action {
    private String nom;
    private double prix;
    private int quantite;

    public Action(String nom, double prix, int quantite) {
    if (prix < 0) {
        throw new IllegalArgumentException(
            "Le prix ne peut pas être négatif."
        );
    }

    if (quantite < 0) {
        throw new IllegalArgumentException(
            "La quantité ne peut pas être négative."
        );
    }

    this.nom = nom;
    this.prix = prix;
    this.quantite = quantite;
}

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int nouvelleQuantite) {
        if (nouvelleQuantite < 0) {
            System.out.println("Erreur : la quantité ne peut pas être négative.");
        } else {
            this.quantite = nouvelleQuantite;
        }
    }

    public void acheter(int quantiteAchetee) {
    if (quantiteAchetee <= 0) {
        throw new IllegalArgumentException(
            "La quantité achetée doit être supérieure à zéro."
        );
    }

    this.quantite += quantiteAchetee;
    }

    public void vendre(int quantiteVendue) {
    if (quantiteVendue <= 0) {
        throw new IllegalArgumentException(
            "La quantité vendue doit être supérieure à zéro."
        );
    } else if (quantiteVendue > quantite) {
        throw new IllegalArgumentException(
            "La quantité vendue dépasse la quantité détenue."
        );
    }

    this.quantite -= quantiteVendue;
    }

    public double calculerValeur() {
        return prix * quantite;
    }
}