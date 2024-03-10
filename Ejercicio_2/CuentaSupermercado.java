package Ejercicio_2;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CuentaSupermercado {
    
    private int contador=0;
    private ArrayList<LineaFactura> productos = new ArrayList<>();
    LocalDate fechaActual = LocalDate.now();                                           //Importando la libreria time se puede extraer la fecha actual desde el computador
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String fechaFormateada = fechaActual.format(formatoFecha);

    public void Agregar_productos(Producto producto, int cantidad){                    //Metodo con el cual se anexan los productos por medio de una lista
        for(LineaFactura factura : productos){                                         //Se hace un for para verificar si el producto ya existe o sino anexarlo a la lista
           
           if(factura.Get_producto().Get_Nombre().equals(producto.Get_Nombre())){
                factura.Set_cantidad(factura.Get_cantidad() + cantidad);
           }else{
             productos.add(new LineaFactura(producto, cantidad));
           } 
        }
    }

    public void desprendible(){                                                     //metodo para generar el desprendible segun el formato brindado
        int cant=0;
        double precioU=0;
        double precioF=0;
        System.out.println("Desprendible:---------------------------------------------------- " + contador);        //Se muestra la cantidad de desprendibles generados
        System.out.println("Fecha de generacion:----------------------------------------------- " + fechaFormateada);   //Se muestra la fecha actual
        System.out.printf("%-20s%-5s%-10s%-10s\n", "Producto", "Un.", "PU", "Total");
        System.out.println("-------------------------------------------------------- ");
        for(LineaFactura factura : productos){                                          //Se genera un bucle de iteracion para mostrar los productos, cantidad, precios
            Producto producto = factura.Get_producto();
            cant = factura.Get_cantidad();
            precioU = producto.Get_precio();
            precioF = factura.Total();
            System.out.printf("%-20s%-5d%-10.2f%-10.2f\n", producto.Get_Nombre(), cant, precioU, precioF);
        }
        System.out.println("-------------------------------------------------------- ");
        System.out.printf("Total: %.2f\n", calculo_total());
    }


    public double calculo_total(){                                                  // Funcion para calcular el total de toda la compra
        double valor_final=0;
        for(LineaFactura factura:productos){
            valor_final = valor_final + factura.Total();
        }
        return valor_final;
    }





}
