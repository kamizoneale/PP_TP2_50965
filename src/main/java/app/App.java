package app;

import excepciones.CupoExcedidoException;
import modelo.*;

import java.util.List;

public class App {

    public static void main(String[] args) {


        // =========================================
        // A. CREAR ESTUDIANTES
        // =========================================

        Estudiante estudiante1 =
                new Estudiante(
                        "1001",
                        "Lucas"
                );


        Estudiante estudiante2 =
                new Estudiante(
                        "1002",
                        "Ana"
                );


        Estudiante estudiante3 =
                new Estudiante(
                        "1003",
                        "Martín"
                );


        // =========================================
        // B. CREAR EVENTO
        // =========================================

        EventoUniversitario evento =
                new EventoUniversitario(
                        "EV001",
                        "Jornada Universitaria 2026",
                        10000,
                        false
                );


        // =========================================
        // CREAR SALA
        // =========================================

        Sala sala =
                new Sala(
                        1,
                        "Aula Magna"
                );


        evento.asignarSala(sala);


        // =========================================
        // CREAR ACTIVIDADES
        // =========================================

        Charla charla1 =
                new Charla(
                        1,
                        "Inteligencia Artificial",
                        50,
                        "Dr. Pérez"
                );


        Charla charla2 =
                new Charla(
                        2,
                        "Ciberseguridad",
                        40,
                        "Ing. López"
                );


        Taller taller1 =
                new Taller(
                        3,
                        "Programación Java",
                        30,
                        true
                );


        Taller taller2 =
                new Taller(
                        4,
                        "Git y GitHub",
                        25,
                        false
                );


        Curso curso1 =
                new Curso(
                        5,
                        "Programación Orientada a Objetos",
                        25,
                        1
                );


        // =========================================
        // AGREGAR ACTIVIDADES AL EVENTO
        // =========================================

        evento.agregarActividad(charla1);
        evento.agregarActividad(charla2);

        evento.agregarActividad(taller1);
        evento.agregarActividad(taller2);

        evento.agregarActividad(curso1);


        // =========================================
        // C. INSCRIBIR ESTUDIANTES
        // =========================================

        try {

            charla1.inscribirEstudiante(
                    estudiante1
            );


            charla2.inscribirEstudiante(
                    estudiante2
            );


            taller1.inscribirEstudiante(
                    estudiante1
            );


            taller1.inscribirEstudiante(
                    estudiante3
            );


            taller2.inscribirEstudiante(
                    estudiante2
            );


            curso1.inscribirEstudiante(
                    estudiante3
            );


        } catch (CupoExcedidoException e) {

            System.out.println(
                    "Error de cupo: "
                            + e.getMessage()
            );
        }


        // =========================================
        // D. FILTRAR ACTIVIDADES POR TIPO
        // =========================================

        List<Charla> charlas =
                evento.filtrarActividadesPorTipo(
                        Charla.class
                );


        List<Taller> talleres =
                evento.filtrarActividadesPorTipo(
                        Taller.class
                );


        List<Curso> cursos =
                evento.filtrarActividadesPorTipo(
                        Curso.class
                );


        // =========================================
        // E. MOSTRAR CANTIDAD DE CADA TIPO
        // =========================================

        System.out.println(
                "\n===== CANTIDAD DE ACTIVIDADES ====="
        );


        System.out.println(
                "Charlas: "
                        + charlas.size()
        );


        System.out.println(
                "Talleres: "
                        + talleres.size()
        );


        System.out.println(
                "Cursos: "
                        + cursos.size()
        );


        // =========================================
        // F. CALCULAR COSTO DE MATERIALES
        // =========================================

        double costoCharlas =
                evento.calcularCostoMateriales(
                        charlas
                );


        double costoTalleres =
                evento.calcularCostoMateriales(
                        talleres
                );


        double costoCursos =
                evento.calcularCostoMateriales(
                        cursos
                );


        System.out.println(
                "\n===== COSTO DE MATERIALES ====="
        );


        System.out.println(
                "Materiales de charlas: $"
                        + costoCharlas
        );


        System.out.println(
                "Materiales de talleres: $"
                        + costoTalleres
        );


        System.out.println(
                "Materiales de cursos: $"
                        + costoCursos
        );


        // =========================================
        // G. DEMOSTRAR TIPADO
        // =========================================

        System.out.println(
                "\n===== LISTAS TIPADAS ====="
        );


        for (Charla charla : charlas) {

            System.out.println(
                    "Charla encontrada: "
                            + charla.getTitulo()
            );
        }


        for (Taller taller : talleres) {

            System.out.println(
                    "Taller encontrado: "
                            + taller.getTitulo()
            );
        }


        for (Curso curso : cursos) {

            System.out.println(
                    "Curso encontrado: "
                            + curso.getTitulo()
            );
        }


        // =========================================
        // MOSTRAR EVENTO
        // =========================================

        System.out.println(
                "\n===== DATOS DEL EVENTO ====="
        );


        evento.mostrarDatos();
    }
}