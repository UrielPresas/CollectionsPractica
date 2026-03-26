package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Es posa extends en la classe perque aquesta classe segeix snet un producte amb una variables especifica
public class Alimentacio extends Productes {
    //Creació de les variables
    LocalDate dataDeCaducitat;

    //Creació del constructor
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
    //Funcio per calcular el preu final d'un aliment amb ajuda de la data de caducitat,
    //te el Override perque s'executi aquesta funcio nomes si es un objecte de tipus aliment
    public float calcularPreuFinal(){
        LocalDate today = LocalDate.now(); //Agafo la data de sistema quan executa aquesta funcio
        long diesRestants = ChronoUnit.DAYS.between(today,dataDeCaducitat); //Funcio que conta els dies que hi han entra la data de caducitat i la data actual

        if(diesRestants < 0){ //Si els dies restants son mes petits que 0, es posaran a 0 perque no te sentit tindre numeros en negatiu
            diesRestants = 0;
        }

        float preu = getPreu();
        float preuFinal = (float)(preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1)); //Calcul del preu final amb la data de caducitat

        return preuFinal;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDATA DE CADUCITAT: " + dataDeCaducitat + "\n";
    }
}
