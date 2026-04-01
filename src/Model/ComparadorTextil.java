package Model;

import java.util.Comparator;

public class ComparadorTextil implements Comparator<ProductesCarro> {
    @Override
    public int compare(ProductesCarro pc1, ProductesCarro pc2){
        //Asumim que els objectes son Texils
        Textil t1 = (Textil) pc1.getProducte();
        Textil t2 = (Textil) pc2.getProducte();
        return t1.getComposicioTextil().compareToIgnoreCase(t2.getComposicioTextil());
    }
}
