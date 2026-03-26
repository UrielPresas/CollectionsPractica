package Model;

public class Productes {
    //Creació de les variables
    protected float preu;
    private String nom;
    private String codiDeBarres;

    //Constructor de productes
    public Productes(String nom, float preu, String codiDeBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiDeBarres = codiDeBarres;
    }

    public float getPreu() {
        return preu;
    }

    public float calcularPreuFinal(){
        return preu;
    }

    public String getNom() {
        return nom;
    }

    public String getCodiDeBarres() {
        return codiDeBarres;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodiDeBarres(String codiDeBarres) {
        this.codiDeBarres = codiDeBarres;
    }


    @Override
    public String toString() {
        return
                "NOM: " + nom +
                "\nPREU: " + calcularPreuFinal() +
                "\nCODI DE BARRES: " + codiDeBarres;
    }
}
