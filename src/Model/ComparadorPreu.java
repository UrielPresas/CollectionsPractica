package Model;

import java.util.Comparator;

public class Comparador implements Comparator<ProductesCarro>{
    @Override
    public int compare(ProductesCarro p1, ProductesCarro p2){
        return Float.compare(p1.getPreuUnitat(), p2.getPreuUnitat());
    }
}
