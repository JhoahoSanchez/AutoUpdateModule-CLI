package com.sideralsoft.cli;

import com.sideralsoft.facade.ConexionServidor;
import picocli.CommandLine;

@CommandLine.Command(
        name = "update",
        description = "Actualiza una aplicación o certificado existente."
)
public class ActualizacionComandos implements Runnable {
    @CommandLine.Parameters(index = "0", description = "El nombre de la aplicación o certificado a actualizar.")
    private String nombre;

    @Override
    public void run() {
        System.out.println("Actualizando " + nombre + "...");
        System.out.println(ConexionServidor.actualizarElemento(nombre));
    }
}
