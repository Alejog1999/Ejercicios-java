package Ejercicio_2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int cantidadP = 0;
        String nombreP;
        double preciop = 0;
        int cantP = 0;
        String resp = "";
        int op = 0;

        Scanner leeScanner = new Scanner(System.in);
        CuentaSupermercado cuenta = new CuentaSupermercado();

        while (op != 3) {
            System.out.println("Bienvenido al sistema de facturacion");
            System.out.println("Por favor seleccione una opcion del menu");
            System.out.println("1) Ingresar producto");
            System.out.println("2) Generar desprendible de facturacion");
            System.out.println("3) Salir");
            op = leeScanner.nextInt();

            switch (op) {
                case 1:
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
                        if (resp.equalsIgnoreCase("N")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Desprendible de compra");
                    cuenta.desprendible();
                    break;
            }
        }
        leeScanner.close();
    }
}
