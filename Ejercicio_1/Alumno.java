package Ejercicio_1;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno {// Se define la clase en la cual se definen los objetos de tipo "alumno"
    private String Nombre_del_alumno;
    private String Apellido_del_alumno;
    private List<Asignatura> asignaturas;
    

    
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String fechaFormateada = fechaActual.format(formatoFecha);

    public Alumno(String Nombre_del_alumno, String Apellido_del_alumno) {
        this.Nombre_del_alumno = Nombre_del_alumno;
        this.Apellido_del_alumno = Apellido_del_alumno;
        this.asignaturas = new ArrayList<>();
    }

    public void set_Nombre(String Nombre) {
        Nombre_del_alumno = Nombre;
    }

    public void set_Apellido(String Apellido) {
        Apellido_del_alumno = Apellido;
    }

    public String Get_nombre(){
        return Nombre_del_alumno;
    }

    public String Get_apellido(){
        return Apellido_del_alumno;
    }

    public List<Asignatura> Get_asignaturas(){
        return asignaturas;
    }

    public void Agregar_asignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void Modificar_nota_alumno(String Nombre_a, double nota) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.Get_materia().equals(Nombre_a)) {
                asignatura.Set_nota(nota);
                return;
            }
        }
        System.err.println("Error en la busqueda, por favor rectifique y vuelva a intentarlo");
    }

    public void Get_asigntatura(String Nombre_asignatura) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.Get_materia().equals(Nombre_asignatura)) {
                System.out.println("Asignatura: " + asignatura.Get_materia() + "Nota: " + asignatura.Get_nota());
                return;
            }
            
        }
        System.err.println("Error en la busqueda, por favor rectifique y vuelva a intentarlo");
    }

    public double promedio() {
        double cantidad = 0;
        int cont = 0;
        if (asignaturas.isEmpty()) {
            return cantidad;
        } else {
            for (Asignatura asignatura : asignaturas) {
                cantidad = cantidad + asignatura.Get_nota();
                cont++;
            }
            return cantidad / cont;
        }
    }

    public void Boletin() {
        System.out.println("Boletin generado: "+ fechaFormateada);
        System.out.println("Alumno: " + Nombre_del_alumno + " " + Apellido_del_alumno);
        System.out.println();
        System.out.println("Asignatura   Nota");
        System.out.println("------------------");
        // Iteramos sobre la lista de asignaturas e imprimimos el nombre y la nota de
        // cada una
        for (Asignatura asignatura : asignaturas) {
            System.out.printf("%-12s %.2f%n", asignatura.Get_materia(), asignatura.Get_nota());
        }
        // Mostramos el promedio de las notas
        System.out.println("------------------");
        System.out.printf("Nota Media: %.2f%n", promedio());
        System.out.println("");
    }

}
