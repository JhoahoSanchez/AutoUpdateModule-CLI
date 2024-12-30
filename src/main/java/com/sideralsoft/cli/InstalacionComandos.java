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
    @CommandLine.Parameters(index = "1", description = "Tipo de elemento (APLICACION/CERTIFICADO).")
    private String tipo;

    @Override
    public void run() {
        ConexionServidor.instalarElemento(tipo, nombre);
    }
}
