import java.util.Scanner;

public class alumnosMaterias{
public static void main(String[] args) {
        final int TOTAL_ALUMNOS = 500;
        final int TOTAL_MATERIAS = 6;

        // Matriz: 500 filas (alumnos) por 6 columnas (materias)
        double[][] calificaciones = new double[TOTAL_ALUMNOS][TOTAL_MATERIAS];

        // Llenamos la matriz con calificaciones aleatorias (entre 5.0 y 10.0) para simular los datos
        for (int i = 0; i < TOTAL_ALUMNOS; i++) {
            for (int j = 0; j < TOTAL_MATERIAS; j++) {
                // Genera una calificación con un decimal
                calificaciones[i][j] = Math.round((5.0 + Math.random() * 5.0) * 10.0) / 10.0;
            }
        }

        System.out.printf("%-15s", ""); 
        for (int m = 1; m <= TOTAL_MATERIAS; m++) {
            System.out.printf("| %-12s", "Materia" + m);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");

        // Filas: Alumno1 ... Alumno500 con sus respectivas calificaciones
        for (int i = 0; i < TOTAL_ALUMNOS; i++) {
            System.out.printf("%-15s", "Alumno" + (i + 1));
            
            for (int j = 0; j < TOTAL_MATERIAS; j++) {
                System.out.printf("| %-12.1f", calificaciones[i][j]);
                
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE BÚSQUEDA DE CALIFICACIONES ===");

        // Solicitamos el ID del alumno (de 1 a 500)
        System.out.print("Ingrese el número de alumno (1 - 500): ");
        int numAlumno = scanner.nextInt();

        // Solicitamos el número de materia (de 1 a 6)
        System.out.print("Ingrese el número de materia (1 - 6): ");
        int numMateria = scanner.nextInt();

        // Validamos que los datos ingresados estén dentro del rango
        if (numAlumno >= 1 && numAlumno <= TOTAL_ALUMNOS && numMateria >= 1 && numMateria <= TOTAL_MATERIAS) {
            
            // Convertimos la entrada a índices de arreglo (base 0)
            int fila = numAlumno - 1;
            int columna = numMateria - 1;

            // Obtenemos la calificación directamente mediante sus índices
            double nota = calificaciones[fila][columna];

            System.out.println("\n-------------------------------------------");
            System.out.println("Alumno  | "+"materia  | "+"calificacion  | ");
            System.out.println("-------------------------------------------");
            System.out.println("Alumno " + numAlumno+"|"+"Materia " + numMateria+" | " + nota);
            System.out.println("-------------------------------------------");

        } else {
            System.out.println("\nError: El número de alumno o materia está fuera del rango permitido.");
        }

        scanner.close();
    }


}