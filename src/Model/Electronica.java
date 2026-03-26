package Model;

//Es posa extends en la classe perque aquesta classe segeix snet un producte amb una variables especifica
public class Electronica extends Productes{
    //Creació de les variables
    int diesGarantia;

    //Creació del constructor
    public Electronica(String nom, float preu, String codiDeBarres, int diesGarantia) {
        super(nom, preu, codiDeBarres);
        this.diesGarantia = diesGarantia;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    @Override
    //Funcio que es trucada nomes si el producte es de tipus electronic, aquesta funcio calcula el preu final amb ajuda del dies de garantia
    public float calcularPreuFinal(){
        Float preu = getPreu();
        Float preuGarantia;
        preuGarantia = (float)(preu + preu*(getDiesGarantia()/365)*0.1);
        return preuGarantia;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nDIES DE GARANTIA" + diesGarantia + "\n";
    }
}
