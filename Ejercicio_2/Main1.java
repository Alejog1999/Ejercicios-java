package Ejercicio_2;

import java.util.Scanner;

public class Main1 { //Creacion de clase Main principal
    public static void main(String[] args) {
    
        int cantidadP = 0;
        String nombreP;
        double preciop = 0;
        int cantP = 0;
        String resp = "";
        int op = 0;

        Scanner leeScanner = new Scanner(System.in);          //Se inicializa el scanner
        CuentaSupermercado cuenta = new CuentaSupermercado(); //Se crea el nuevo objeto llamado cuenta

        while (op == 3) {                                     //Se crea un bucle para tener el menu disponible mientras no se escoja la opcion salir
            System.out.println("Bienvenido al sistema de facturacion");
            System.out.println("Por favor seleccione una opcion del menu");
            System.out.println("1) Ingresar producto");
            System.out.println("2) Generar desprendible de facturacion");
            System.out.println("3) Salir");
            op = leeScanner.nextInt();

            switch (op) {                                     //Se da el switch y se dan las opciones de pantalla por casos
                case 1:                                       //Para el caso 1 se anexan los productos a la compra
                    System.out.println("Por favor ingrese la cantidad total de productos: ");
                    cantidadP = leeScanner.nextInt();

                    for (int i = 0; i < cantidadP; i++) {
                        System.out.println("Por favor ingrese el producto");
                        nombreP = leeScanner.next();
                        System.out.println("Por favor ingrese el precio del producto");
                        preciop = leeScanner.nextDouble();
                        System.out.println("Por favor ingrese la cantidad de ese producto");
                        cantP = leeScanner.nextInt();

                        Producto producto = new Producto(nombreP, preciop);
                        cuenta.Agregar_productos(producto, cantP);

                        System.out.println("¿Desea anexar otro producto? seleccione: Y/N");
                        resp = leeScanner.next();
                        if (resp.equals("N")) {
                            break;
                        }else{
                            cantidadP++;
                        }
                    }
                    break;

                case 2:                                                 //Para el caso 2 se muestra el desprendible llamando el metodo
                    System.out.println("Desprendible de compra");
                    cuenta.desprendible();
                    break;
            }

        }
        leeScanner.close();
    }
}
