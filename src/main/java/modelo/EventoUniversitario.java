package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario
        implements Serializable {

    private final String id;

    private String titulo;

    private double costoBase;

    private boolean gratuito;

    private static int cantidadEventos = 0;

    private Sala sala;

    private List<Actividad> actividades;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public EventoUniversitario(
            String id,
            String titulo,
            double costoBase,
            boolean gratuito) {

        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;

        actividades = new ArrayList<>();

        cantidadEventos++;
    }


    // =========================================
    // CONSTRUCTOR DE COPIA
    // =========================================

    public EventoUniversitario(
            EventoUniversitario otro) {

        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;

        this.sala = otro.sala;

        this.actividades =
                new ArrayList<>(otro.actividades);

        cantidadEventos++;
    }


    // =========================================
    // ASIGNAR SALA
    // =========================================

    public void asignarSala(Sala sala) {

        this.sala = sala;
    }


    // =========================================
    // AGREGAR ACTIVIDAD
    // =========================================

    public void agregarActividad(
            Actividad actividad) {

        actividades.add(actividad);
    }


    // =========================================
    // FILTRAR ACTIVIDADES POR TIPO
    // =========================================

    public <T extends Actividad>
    List<T> filtrarActividadesPorTipo(
            Class<T> tipo) {

        List<T> resultado =
                new ArrayList<>();


        for (Actividad actividad : actividades) {

            if (tipo.isInstance(actividad)) {

                resultado.add(
                        tipo.cast(actividad)
                );
            }
        }


        return resultado;
    }


    // =========================================
    // CALCULAR COSTO DE MATERIALES
    // =========================================

    public double calcularCostoMateriales(
            List<? extends Actividad> actividades) {

        double total = 0;


        for (Actividad actividad : actividades) {

            total +=
                    actividad.calcularCostoMateriales();
        }


        return total;
    }


    // =========================================
    // CALCULAR COSTO ESTIMADO
    // =========================================

    public double calcularCostoEstimado() {

        if (gratuito) {

            return 0;
        }


        double costoMateriales =
                calcularCostoMateriales(
                        actividades
                );


        return (costoBase + costoMateriales)
                * 1.21;
    }


    // =========================================
    // MOSTRAR DATOS
    // =========================================

    public void mostrarDatos() {

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "EVENTO: " + titulo
        );

        System.out.println(
                "ID: " + id
        );

        System.out.println(
                "Costo base: $" + costoBase
        );

        System.out.println(
                "Gratuito: "
                        + (gratuito ? "Sí" : "No")
        );


        if (sala != null) {

            System.out.println(
                    "Sala: "
                            + sala.getNombre()
            );
        }


        System.out.println(
                "\nActividades:"
        );


        for (Actividad actividad : actividades) {

            actividad.mostrarIdentificacion();
        }


        System.out.println(
                "\nCosto materiales total: $"
                        + calcularCostoMateriales(
                        actividades
                )
        );


        System.out.println(
                "Costo estimado: $"
                        + calcularCostoEstimado()
        );


        System.out.println(
                "=============================="
        );
    }


    // =========================================
    // GETTERS
    // =========================================

    public List<Actividad> getActividades() {

        return actividades;
    }


    public String getTitulo() {

        return titulo;
    }


    public static int getCantidadEventos() {

        return cantidadEventos;
    }
}