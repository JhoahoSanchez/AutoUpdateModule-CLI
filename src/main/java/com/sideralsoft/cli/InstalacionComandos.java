package com.sideralsoft.cli;

import picocli.CommandLine;

@CommandLine.Command(
        name = "install",
        description = "Instala una aplicación o certificado."
)
public class InstalacionComandos implements Runnable {

    @CommandLine.Parameters(index = "0", description = "El nombre de la aplicación o certificado a instalar.")
    private String name;

    @Override
    public void run() {
        System.out.println("Instalando: " + name);
    }
}
