package Ejercicio_1;

import java.util.Scanner;

public class Main {         // Metodo principal donde se ejecutan los comandos principales de consultar y anexar
                            
    public static void main(String[] args) {
        int leeer = 0;                          //Se crea una variable encargada de leer la opcion dada por el usuario
        Scanner leer = new Scanner(System.in);  //Se crea el objeto leer de la clase Scanner que permite la lectura por teclado

        System.out.println("Bienvenido al sistema, como primera instancia debe ingresar el nombre del alumno");
        System.out.println("Por favor ingrese el nombre del alumno");
        String nombre = leer.nextLine();
        System.out.println("Por favor ingrese el apellido del alumno");
        String apellido = leer.nextLine();
        Alumno alumno = new Alumno(nombre, apellido);
        System.out.println("");               
        

        while (leeer != 5) {    //Se crea un while que siempre va estar ingresando en el menu a menos que se escoja salir
            System.out.println("Escoja una opcion valida");
            System.out.println("1) Anexar materias al alumno");
            System.out.println("2) Modificar Notas");
            System.out.println("3) Consultar boletin");
            System.out.println("4) Consultar asignatura");
            System.out.println("5) Salir");
            System.out.println("");
            leeer = leer.nextInt();
            switch (leeer) {
                case 1:
                    if (alumno.Get_nombre() == "") {    //Por medio de un get se consulta si verdaderamente hay un alumno 
                        break;
                    } else {
                        System.out.println("Ingrese el nombre de la asignatura");
                        String asigna = leer.next(); 
                        System.out.println("Ingrese la nota de la asignatura");
                        double not = leer.nextDouble();
                        alumno.Agregar_asignatura(new Asignatura(asigna, not));     //Se llama el metodo para agregar asignaturas segun las diligencia el usuario
                        System.out.println("");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el nombre de la asignatura a modificar");
                    String asignatura = leer.next();
                    System.out.println("Ingrese la nota nueva");
                    double nota_nueva = leer.nextDouble();
                    alumno.Modificar_nota_alumno(asignatura, nota_nueva); //Similar a la opcion anterior se diligencia el nombre de la asignatura y la nueva nota
                    System.out.println("");
                    break;

                case 3:
                    alumno.Boletin();
                    System.out.println(""); //Se llama el metodo para mostrar el boletin
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la asignatura a consultar");
                    String asignaturaa = leer.next();
                    System.out.println(alumno.Get_nombre() + " " + alumno.Get_apellido());
                    alumno.Get_asigntatura(asignaturaa); //Metodo para consultar asignaturas especificas
                    System.out.println("");
                    break;

                default:
                    break;
            }
        }

    }
}
