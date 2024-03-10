package Ejercicio_2;

public class LineaFactura {
    private int cantidad;
    private Producto producto;

    public LineaFactura(Producto producto, int cantidad){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public void Set_producto(Producto prod){
        producto = prod;
    }

    public void Set_cantidad(int cant){
        cantidad = cant;
    }

    public Producto Get_producto(){
        return producto;
    }

    public int Get_cantidad(){
        return cantidad;
    }

    public double Total(){
        double total=0;
        total = producto.Get_precio()*cantidad;
        return total;
    }
}
