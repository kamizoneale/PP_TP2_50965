package modelo;

import certificacion.Certificable;

public class Curso extends Actividad
        implements Certificable {

    private int nivel;


    public Curso(
            int id,
            String titulo,
            int cupoMaximo,
            int nivel) {

        super(id, titulo, cupoMaximo);

        this.nivel = nivel;
    }


    @Override
    public double calcularCostoMateriales() {

        return 3000;
    }


    @Override
    public String getTipo() {

        return "Curso";
    }


    @Override
    public String generarCertificado(
            Estudiante estudiante) {

        return "CERTIFICADO DE ASISTENCIA\n"
                + "Entidad emisora: "
                + ENTIDAD_EMISORA + "\n"
                + "Estudiante: "
                + estudiante.getNombre() + "\n"
                + "Legajo: "
                + estudiante.getLegajo() + "\n"
                + "Curso: "
                + getTitulo();
    }


    public int getNivel() {
        return nivel;
    }
}
