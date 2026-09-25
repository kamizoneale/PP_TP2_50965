package modelo;

import excepciones.CupoExcedidoException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {

    private final int id;
    private String titulo;
    private int cupoMaximo;

    private List<Inscripcion> inscripciones;


    public Actividad(int id, String titulo, int cupoMaximo) {

        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;

        this.inscripciones = new ArrayList<>();
    }


    public Inscripcion inscribirEstudiante(Estudiante estudiante)
            throws CupoExcedidoException {

        if (inscripciones.size() >= cupoMaximo) {

            throw new CupoExcedidoException(
                    "No hay cupo disponible en la actividad: "
                            + titulo
            );
        }


        Inscripcion inscripcion =
                new Inscripcion(
                        estudiante,
                        this,
                        LocalDate.now(),
                        "Confirmada"
                );


        inscripciones.add(inscripcion);

        return inscripcion;
    }


    public final void mostrarIdentificacion() {

        System.out.println(
                "ID: " + id
                        + " | " + getTipo()
                        + ": " + titulo
        );
    }


    public abstract double calcularCostoMateriales();


    public abstract String getTipo();


    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }


    public String getTitulo() {
        return titulo;
    }


    public int getId() {
        return id;
    }


    public int getCupoMaximo() {
        return cupoMaximo;
    }
}