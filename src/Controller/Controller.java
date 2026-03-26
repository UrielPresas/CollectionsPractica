package Controller;

import Model.Alimentacio;
import Model.Electronica;
import Model.Productes;
import Model.ProductesCarro;
import Model.Textil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    private static Scanner scCon = new Scanner(System.in);
    private ArrayList<Productes> productes = new ArrayList<>();
    private HashMap<String, ProductesCarro> carro = new HashMap<>();

    public void addAlimentacio(){
        if(productes.size() < 101){
            System.out.println("Nom: ");
            String nom = scCon.nextLine();

            System.out.println("Preu: ");
            float preu = scCon.nextFloat();
            scCon.nextLine(); //Netejar el Buffer

            System.out.println("Codi de Barres: ");
            String codiDeBarres = scCon.nextLine();

            System.out.println("Data de caducitat (dd/MM/yyyy): ");
            String dDC = scCon.nextLine();

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDeCaducitat= LocalDate.parse(dDC, format);

            Alimentacio aliment = new Alimentacio(nom,preu,codiDeBarres,dataDeCaducitat);

            productes.add(aliment);

            if(carro.containsKey(codiDeBarres)){ //Comprova si hi ha un objecte que ja te el mateix codiDeBarres, si ja existeis es suma a les unitats +1
                carro.get(codiDeBarres).afegirUnitats();
            }
            else {
                ProductesCarro itemCarro = new ProductesCarro(aliment, 1);
                carro.put(codiDeBarres, itemCarro);
            }
        }
    }

    public void addTextil() {
        if (productes.size() < 101) {
            System.out.println("Nom: ");
            String nom = scCon.nextLine();

            System.out.println("Preu: ");
            float preu = scCon.nextFloat();
            scCon.nextLine(); //Netejar el Buffer

            System.out.println("Codi de Barres: ");
            String codiDeBarres = scCon.nextLine();

            System.out.println("Composicio Textil: ");
            String composicioTextil = scCon.nextLine();

            Textil textil = new Textil(nom, preu, codiDeBarres, composicioTextil);

            productes.add(textil);

            if (carro.containsKey(codiDeBarres)) { //Comprova si hi ha un objecte que ja te el mateix codiDeBarres, si ja existeis es suma a les unitats +1
                carro.get(codiDeBarres).afegirUnitats();
            } else {
                ProductesCarro itemCarro = new ProductesCarro(textil, 1);
                carro.put(codiDeBarres, itemCarro);
            }
        }
    }

    public void addElectronica(){
        if(productes.size() < 101){
            System.out.println("Nom: ");
            String nom = scCon.nextLine();

            System.out.println("Preu: ");
            float preu = scCon.nextFloat();
            scCon.nextLine(); //Netejar el Buffer

            System.out.println("Codi de Barres: ");
            String codiDeBarres = scCon.nextLine();

            System.out.println("Dies de Garantia: ");
            int diesDeGarantia = scCon.nextInt();

            Electronica electronic = new Electronica(nom,preu,codiDeBarres,diesDeGarantia);

            productes.add(electronic);

            if (carro.containsKey(codiDeBarres)) { //Comprova si hi ha un objecte que ja te el mateix codiDeBarres, si ja existeis es suma a les unitats +1
                carro.get(codiDeBarres).afegirUnitats();
            } else {
                ProductesCarro itemCarro = new ProductesCarro(electronic, 1);
                carro.put(codiDeBarres, itemCarro);
            }
        }
    }

    public void pasarPerCaixa(){
        LocalDate dataAvui = LocalDate.now();
        System.out.println("SAPAMERCAT\nData: " + dataAvui);
        for(ProductesCarro pc : carro.values()){
            System.out.println(pc);
        }
        carro.clear();
    }

    public void mostrarCarretDeLaCompra(){
        for(ProductesCarro pc : carro.values()){
            System.out.println("NOM: " + pc.getProducte().getNom() + "\tUnitats: " + pc.getUnitats());
        }
    }

}