package Ejercicio_1;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno {// Se define la clase en la cual se definen los objetos de tipo "alumno"
    private String Nombre_del_alumno;
    private String Apellido_del_alumno;
    private List<Asignatura> asignaturas;
    

    
    LocalDate fechaActual = LocalDate.now();                                           //Importando la libreria time se puede extraer la fecha actual desde el computador
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String fechaFormateada = fechaActual.format(formatoFecha);

    public Alumno(String Nombre_del_alumno, String Apellido_del_alumno) { //Se definen las variables o propiedades del constructor
        this.Nombre_del_alumno = Nombre_del_alumno;
        this.Apellido_del_alumno = Apellido_del_alumno;
        this.asignaturas = new ArrayList<>();
    }

    public void set_Nombre(String Nombre) {                               //Metodo set para ingresar el nombre del alumno
        Nombre_del_alumno = Nombre;
    }

    public void set_Apellido(String Apellido) {                           //Metodo set para ingresar el apellido del alumno
        Apellido_del_alumno = Apellido;
    }

    public String Get_nombre(){                                           //Metodo get para extraer el nombre del alumno
        return Nombre_del_alumno;
    }

    public String Get_apellido(){                                         //Metodo get para extraer el apellido del alumno
        return Apellido_del_alumno;
    }

    public List<Asignatura> Get_asignaturas(){                            //Metodo para listar y extraer las asignaturas anexadas
        return asignaturas;
    }

    public void Agregar_asignatura(Asignatura asignatura) {               //metodo para anexar las asignaturas creando el objeto asignatura
        asignaturas.add(asignatura);
    }

    public void Modificar_nota_alumno(String Nombre_a, double nota) {     //Metodo para modificar la nota recorriendo las asignaturas por medio de un for hasta que encuentre la correcta
        for (Asignatura asignatura : asignaturas) {                       //En caso de no encontrarla se muestra un mensaje de error 
            if (asignatura.Get_materia().equals(Nombre_a)) {              //Por medio de un get se compara si es igual a la diligenciada
                asignatura.Set_nota(nota);                                //Se da un set a la nueva nota
                return;
            }
        }
        System.err.println("Error en la busqueda, por favor rectifique y vuelva a intentarlo");
    }

    public void Get_asigntatura(String Nombre_asignatura) {               //Metodo para extraer una asignatura especifica similar al metodo anterior
        for (Asignatura asignatura : asignaturas) {                       //Se hace un recorrido de las asignaturas por medio de un for hasta encontrar
            if (asignatura.Get_materia().equals(Nombre_asignatura)) {     //La asignatura deseada y con un mensaje de error en caso de no encontrar
                System.out.println("Asignatura: " + asignatura.Get_materia() + "Nota: " + asignatura.Get_nota());
                return;
            }
            
        }
        System.err.println("Error en la busqueda, por favor rectifique y vuelva a intentarlo");
    }

    public double promedio() {                                            //Funcion para retornar el promedio de las asignaturas creando una variable  
        double cantidad = 0;                                              //de suma y otra de conteo para calcular el promedio, de igual manera se hace
    int cont = 0;                                                         //se hace un recorrido por meido de un for
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

public void Boletin() {                                                   //Metodo para extraer todas las asignaturas del alumno con un formato especifico                                            
        System.out.println("Boletin generado: "+ fechaFormateada);        //Aqui se da uso a la fecha actual 
        System.out.println("Alumno: " + Nombre_del_alumno + " " + Apellido_del_alumno); //Se anexa el nombre y apellido del alumno implicado
        System.out.println();
        System.out.println("Asignatura   Nota");
        System.out.println("------------------");
        // Iteramos sobre la lista de asignaturas e imprimimos el nombre y la nota de
        // cada una
        for (Asignatura asignatura : asignaturas) {                       //Por medio de un bucle for se accede a cada asignatura y se muestra por consola
            System.out.printf("%-12s %.2f%n", asignatura.Get_materia(), asignatura.Get_nota());
        }
        
        System.out.println("------------------");
        System.out.printf("Nota Media: %.2f%n", promedio());      //Una vez terminado el bucle de muestra se calcula el promedio llamando a la funcion
        System.out.println("");
    }

}
