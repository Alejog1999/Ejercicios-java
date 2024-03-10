package Ejercicio_1;

public class Asignatura {                           //Se define la clase Asignatura
    private String materia;
    private double nota;

    public Asignatura(String materia, double nota) { //Se define el constructor con las propiedades de materia y nota
        this.materia = materia;
        this.nota = nota;
    }

    public void Set_materia(String mat) {            // Se define el Setter para las materias
        materia = mat;
    }

    public void Set_nota(double not) {              //Se define el setter para las notas de las materias
        nota = not;
    }

    public String Get_materia() {                   //Se define el Getter para extraer las materias
        return materia;
    }

    public double Get_nota() {                      //Se define el Getter para extraer el valor de las notas
        return nota;
    }

}
