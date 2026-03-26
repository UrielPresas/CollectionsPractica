package Model;

public class Electronica extends Productes{
    int diesGarantia;

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
