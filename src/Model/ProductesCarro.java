package Model;

public class ProductesCarro {
    private Productes producte;
    private int unitats;

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

    public float calcularTotal(){
        return getPreuUnitat() * unitats;
    }

    @Override
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
