package persistencia;

import modelo.EventoUniversitario;

import java.io.*;

public class EventoPersistencia {

    public static void guardarEvento(
            EventoUniversitario evento,
            String archivo)
            throws IOException {

        ObjectOutputStream salida =
                new ObjectOutputStream(
                        new FileOutputStream(archivo)
                );

        salida.writeObject(evento);

        salida.close();
    }


    public static EventoUniversitario leerEvento(
            String archivo)
            throws IOException, ClassNotFoundException {

        ObjectInputStream entrada =
                new ObjectInputStream(
                        new FileInputStream(archivo)
                );

        EventoUniversitario evento =
                (EventoUniversitario) entrada.readObject();

        entrada.close();

        return evento;
    }
}