package Ejercicio_2;

public class Producto {
    private String Nombre_producto;                      //Propiedades privada
    private double Precio_unitario;

    public Producto(String Nombre_producto, double Precio_unitario){ //Creacion de constructor
        this.Nombre_producto = Nombre_producto;
        this.Precio_unitario = Precio_unitario;
    }

    public void Set_Nombre(String Nombre_pro){          //Metodo set para anexar nombre del producto
        Nombre_producto = Nombre_pro;
    }

    public void Set_precio(int Prec){                   //Metodo set para anexar precio unitario del producto
        Precio_unitario = Prec;
    }

public String Get_Nombre(){                             //Funcion Get para extraer el nombre del producto
        return Nombre_producto;
    }

    public double Get_precio(){                            //Funcion Get para extraer el precio del producto
        return Precio_unitario;
    }
}
