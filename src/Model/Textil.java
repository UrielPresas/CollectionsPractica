package Model;

public class Textil extends Productes{
    String composicioTextil;

    public Textil(String nom, float preu, String codiDeBarres, String composicioTextil) {
        super(nom, preu, codiDeBarres);
        this.composicioTextil = composicioTextil;
    }

    public String getComposicioTextil() {
        return composicioTextil;
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nCOMPOSICIO TEXTIL: " + composicioTextil + "\n";
    }
}
