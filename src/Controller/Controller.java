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
    //Creacio del escaner
    private static Scanner scCon = new Scanner(System.in);
    //Creacio d'un arrayList per guardar els productes
    private ArrayList<Productes> productes = new ArrayList<>();
    //Creacio d'un HashMap per poder comprovar quins productes tenen el mateix codi de barres
    private HashMap<String, ProductesCarro> carro = new HashMap<>();

    public void addAlimentacio(){
        if(productes.size() < 101){ //Comprova que no hi han mes de 100 aliments diferents
            System.out.println("Nom: ");
            String nom = scCon.nextLine();

            System.out.println("Preu: ");
            float preu = scCon.nextFloat();
            scCon.nextLine(); //Netejar el Buffer

            System.out.println("Codi de Barres: ");
            String codiDeBarres = scCon.nextLine();

            System.out.println("Data de caducitat (dd/MM/yyyy): ");
            String dDC = scCon.nextLine();

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formato el codi de la data
            LocalDate dataDeCaducitat = LocalDate.parse(dDC, format); //Es formata la data de caducitat amb el format especificat

            Alimentacio aliment = new Alimentacio(nom,preu,codiDeBarres,dataDeCaducitat); //Creacio del aliment

            productes.add(aliment); //S'afegeix l'aliment a l'ArrayList

            if(carro.containsKey(codiDeBarres)){ //Comprova si hi ha un objecte que ja te el mateix codiDeBarres, si ja existeis es suma a les unitats +1
                carro.get(codiDeBarres).afegirUnitats();
            }
            else { //Si el producte no existeix es crea un nou amb les unitats a 1
                ProductesCarro itemCarro = new ProductesCarro(aliment, 1);
                carro.put(codiDeBarres, itemCarro);
            }
        }
    }

    //Mateix funcionament que "addAlimentacio()", no hi ha data de caducitat en aquest
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

    //Mateix funcionament que "addAlimentacio()" sense data de caducitat
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

    //Funcio que mostra els productes introduïts al carro de la compra, però surt el preu, i subtotal a més del nom i la resta d'atributs.
    public void pasarPerCaixa(){
        LocalDate dataAvui = LocalDate.now();
        System.out.println("SAPAMERCAT\nData: " + dataAvui);
        for(ProductesCarro pc : carro.values()){
            System.out.println(pc);
        }
        carro.clear();
    }

    //Funcio que mostra el carret de la compra, només mostra el nom i les unitats.
    public void mostrarCarretDeLaCompra(){
        for(ProductesCarro pc : carro.values()){
            System.out.println("NOM: " + pc.getProducte().getNom() + "\tUnitats: " + pc.getUnitats());
        }
    }

}