package Ejercicio_2;

import java.util.Scanner;

public class Main {public static void main(String[] args) {
    int cantidadP=0;
    String nombreP;
    double preciop=0;
    int cantP=0;
    String resp="";

    Scanner leeScanner = new Scanner(System.in);
    System.out.println("Bienvenido al sistema de facturacion");
    System.out.println("Por favor ingrese la cantidad total de productos: ");
    cantidadP = leeScanner.nextInt();
    CuentaSupermercado cuenta = new CuentaSupermercado();

    for(int i = 0; i < cantidadP; i++){
        System.out.println("Por favor ingrese el producto");
        nombreP = leeScanner.next();
        System.out.println("Por favor ingrese el precio del producto");
        preciop = leeScanner.nextDouble();
        System.out.println("Por favor ingrese la cantidad de ese producto");
        cantP = leeScanner.nextInt();

        Producto producto = new Producto(nombreP, preciop);
        cuenta.Agregar_productos(producto, cantidadP);

        System.out.println("¿Desea anexar otro producto? seleccione: Y/N");
        resp = leeScanner.next();
        if(resp.equals("N")){
            break;
        }
    }

    System.out.println("Desprendible de compra");
    cuenta.desprendible();

    leeScanner.close();
}
}
