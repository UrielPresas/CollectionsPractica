package Vista;

import Controller.Controller;

import java.util.Scanner;

public class Vista {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller();
        int opcio;
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

        //HACER LA PARTE DEL GITHUB

    }

}
