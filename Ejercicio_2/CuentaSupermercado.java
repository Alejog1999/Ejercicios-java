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

    public void Agregar_productos(Producto producto, int cantidad){
        for(LineaFactura factura : productos){
           
           if(factura.Get_producto().Get_Nombre().equals(producto.Get_Nombre())){
                factura.Set_cantidad(factura.Get_cantidad() + cantidad);
           }else{
             productos.add(new LineaFactura(producto, cantidad));
           } 
        }
    }

    public void desprendible(){
        int cant=0;
        double precioU=0;
        double precioF=0;
        System.out.println("Desprendible:---------------------------------------------------- " + contador);
        System.out.println("Fecha de generacion:----------------------------------------------- " + fechaFormateada);
        System.out.printf("%-20s%-5s%-10s%-10s\n", "Producto", "Un.", "PU", "Total");
        System.out.println("-------------------------------------------------------- ");
        for(LineaFactura factura : productos){
            Producto producto = factura.Get_producto();
            cant = factura.Get_cantidad();
            precioU = producto.Get_precio();
            precioF = factura.Total();
            System.out.printf("%-20s%-5d%-10.2f%-10.2f\n", producto.Get_Nombre(), cant, precioU, precioF);
        }
        System.out.println("-------------------------------------------------------- ");
        System.out.printf("Total: %.2f\n", calculo_total());
    }


    public double calculo_total(){
        double valor_final=0;
        for(LineaFactura factura:productos){
            valor_final = valor_final + factura.Total();
        }
        return valor_final;
    }





}
