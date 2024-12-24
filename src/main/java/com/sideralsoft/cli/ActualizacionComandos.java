package com.sideralsoft.cli;


import picocli.CommandLine;

@CommandLine.Command(
        name = "update",
        description = "Actualiza una aplicación o certificado existente."
)
public class ActualizacionComandos implements Runnable {
    @CommandLine.Parameters(index = "0", description = "El nombre de la aplicación o certificado a actualizar.")
    private String name;

    @Override
    public void run() {
        System.out.println("Actualizando cliente: " + name);
    }
}
