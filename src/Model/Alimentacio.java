package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentacio extends Productes {
    LocalDate dataDeCaducitat;

    public Alimentacio(String nom, float preu, String codiDeBarres, LocalDate dataDeCaducitat) {
        super(nom, preu, codiDeBarres);
        this.dataDeCaducitat = dataDeCaducitat;
    }

    public LocalDate getDataDeCaducitat() {
        return dataDeCaducitat;
    }

    public void setDataDeCaducitat(LocalDate dataDeCaducitat) {
        this.dataDeCaducitat = dataDeCaducitat;
    }

    @Override
    public float calcularPreuFinal(){
        LocalDate today = LocalDate.now();
        long diesRestants = ChronoUnit.DAYS.between(today,dataDeCaducitat);

        if(diesRestants < 0){
            diesRestants = 0;
        }

        float preu = getPreu();
        float preuFinal = (float)(preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1));

        return preuFinal;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDATA DE CADUCITAT: " + dataDeCaducitat + "\n";
    }
}
