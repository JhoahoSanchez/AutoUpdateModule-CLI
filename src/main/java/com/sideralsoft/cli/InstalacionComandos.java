package com.sideralsoft.cli;

import com.sideralsoft.facade.ConexionServidor;
import picocli.CommandLine;

@CommandLine.Command(
        name = "install",
        description = "Instala una aplicación o certificado."
)
public class InstalacionComandos implements Runnable {

    @CommandLine.Parameters(index = "0", description = "El nombre de la aplicación o certificado a instalar.")
    private String nombre;
    @CommandLine.Parameters(index = "1", description = "Tipo de elemento (APLICACION/INSTALADOR/CERTIFICADO).")
    private String tipo;
    @CommandLine.Option(names = {"--d", "--dependency"}, description = "Nombre de la dependencia a instalar (Exclusivo para APLICACION).")
    private String dependencia;

    @Override
    public void run() {
        System.out.println(ConexionServidor.instalarElemento(nombre, tipo, dependencia));
    }
}
