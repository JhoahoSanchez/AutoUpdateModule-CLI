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
    @CommandLine.Option(names = {"--d", "--dependency"}, description = "Nombre de la dependencia a actualizar (Exclusivo para APLICACION).")
    private String dependencia;

    @Override
    public void run() {
        System.out.println("Actualizando " + nombre + "...");
        if (dependencia == null) {
            System.out.println(ConexionServidor.actualizarElemento(nombre));
        }else {
            System.out.println(ConexionServidor.actualizarElemento(nombre, dependencia));
        }
    }
}
