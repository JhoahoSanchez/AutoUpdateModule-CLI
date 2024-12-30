package com.sideralsoft.cli;

import com.sideralsoft.facade.ConexionServidor;
import picocli.CommandLine;

@CommandLine.Command(
        name = "version",
        description = "Muestra la versión de una aplicación o certificado."
)
public class ConsultaComandos implements Runnable {

    @CommandLine.Parameters(index = "0", description = "El nombre de la aplicación o certificado.")
    private String name;

    @Override
    public void run() {
        System.out.println("Consultando version de " + name);
        System.out.println(ConexionServidor.obtenerVersionActual(name));
    }
}
