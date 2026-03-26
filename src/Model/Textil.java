package Model;

//Es posa extends en la classe perque aquesta classe segeix snet un producte amb una variables especifica
public class Textil extends Productes{
    String composicioTextil;

    //Creacio del constructor
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
