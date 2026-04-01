package Model;

import java.util.Comparator;

public class ComparadorPreu implements Comparator<Productes>{
    @Override
    public int compare(Productes p1, Productes p2){
        return Float.compare(p1.getPreu(), p2.getPreu());
    }
}
