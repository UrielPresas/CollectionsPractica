package Model;

public class ProductesCarro {
    //Creació de les variables, la variable producte es un producte sencer de la classe productes
    private Productes producte;
    private int unitats;

    //Creació del constructor
    public ProductesCarro(Productes producte, int unitats) {
        this.producte = producte;
        this.unitats = unitats;
    }

    public void afegirUnitats(){
        unitats++;
    }

    public Productes getProducte(){
        return producte;
    }

    public int getUnitats(){
        return unitats;
    }

    public float getPreuUnitat(){
        return producte.calcularPreuFinal();
    }

    //Funcio on es calcula el preu final d'un producte, multiplicant per les unitats
    public float calcularTotal(){
        return getPreuUnitat() * unitats;
    }

    @Override
    //toString on es mostra tots els atributs del producte mes el preu normal, el preu amb les condicions especifiques de cada clase i el preu mulitplicat per les unitats.
    public String toString() {
        return
                producte.getNom() + "\n" +
                unitats + "\t" +
                producte.getPreu() + "\t" +
                getPreuUnitat() + "\t" +
                "\n---------------------\nTotal: " +
                calcularTotal();
    }
}
