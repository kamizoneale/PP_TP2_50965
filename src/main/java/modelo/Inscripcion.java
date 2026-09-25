package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {

    private Estudiante estudiante;
    private Actividad actividad;

    private LocalDate fecha;
    private String estado;

    public Inscripcion(
            Estudiante estudiante,
            Actividad actividad,
            LocalDate fecha,
            String estado) {

        this.estudiante = estudiante;
        this.actividad = actividad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String getEstado() {
        return estado;
    }
}