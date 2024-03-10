package Ejercicio_1;

import java.util.Scanner;

public class Main { // Metodo principal donde se ejecutan los comandos principales de consultar y
                    // anexar
    public static void main(String[] args) {
        int leeer = 0;
        Scanner leer = new Scanner(System.in);

        System.out.println("Bienvenido al sistema, como primera instancia debe ingresar el nombre del alumno");
        System.out.println("Por favor ingrese el nombre del alumno");
        String nombre = leer.nextLine();
        System.out.println("Por favor ingrese el apellido del alumno");
        String apellido = leer.nextLine();
        Alumno alumno = new Alumno(nombre, apellido);
        System.out.println("");
        

        while (leeer != 5) {
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
                    if (alumno.Get_nombre() == "") {
                        break;
                    } else {
                        System.out.println("Ingrese el nombre de la asignatura");
                        String asigna = leer.next(); // Consumir el carácter de nueva línea pendiente
                        System.out.println("Ingrese la nota de la asignatura");
                        double not = leer.nextDouble();
                        System.out.println(alumno.Get_nombre() + " " + alumno.Get_apellido());
                        alumno.Agregar_asignatura(new Asignatura(asigna, not));
                        System.out.println("");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el nombre de la asignatura a modificar");
                    String asignatura = leer.next();
                    System.out.println("Ingrese la nota nueva");
                    double nota_nueva = leer.nextDouble();
                    System.out.println(alumno.Get_nombre() + " " + alumno.Get_apellido());
                    alumno.Modificar_nota_alumno(asignatura, nota_nueva);
                    System.out.println("");
                    break;

                case 3:
                    alumno.Boletin();
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la asignatura a consultar");
                    String asignaturaa = leer.next();
                    System.out.println(alumno.Get_nombre() + " " + alumno.Get_apellido());
                    alumno.Get_asigntatura(asignaturaa);
                    System.out.println("");
                    break;

                default:
                    break;
            }
        }

    }
}
