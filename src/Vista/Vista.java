package Vista;

import Controller.Controller;

import java.util.Scanner;

public class Vista {
    //Creacio del scanner
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller(); //Inialitzacio/Trucada al controller per poder agafar les seves funcions
        int opcio;
        //Mostar menu + trucar a una funcio especifica dependent del que l'usuari esculli amb ajuda del switch case
        do{
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("-------\n-INICI-\n-------");
            System.out.println("1. Introduit producte");
            System.out.println("2. Passar per caixa");
            System.out.println("3. Mostrar carret de compra");
            System.out.println("0. Sortir");
            opcio = scan.nextInt();

            switch (opcio){
                case 1:
                    System.out.println("1. Alimentació");
                    System.out.println("2. Tèxtil");
                    System.out.println("3. Electrònica");
                    System.out.println("0. Tornar");

                    switch (scan.nextInt()){
                        case 1:
                            controlador.addAlimentacio();
                            break;
                        case 2:
                            controlador.addTextil();
                            break;
                        case 3:
                            controlador.addElectronica();
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 2:
                    controlador.pasarPerCaixa();
                    break;
                case 3:
                    controlador.mostrarCarretDeLaCompra();
                    break;
                case 0:
                    break;
                default:
                    throw new Exception("No has escollit una opcio valida");
            }
        }while(opcio != 0);

        System.out.println("Fi del programa");

    }

}
