package com.sideralsoft.cli;

import picocli.CommandLine;

@CommandLine.Command(
        name = "appmanager",
        description = "Gestor de aplicaciones y certificados de SIDERALSOFT.",
        subcommands = {
                InstalacionComandos.class,
                ActualizacionComandos.class,
                ConsultaComandos.class
        }
)

public class InterfazComandos implements Runnable{

    @Override
    public void run() {
        System.out.println("AppManager CLI: usa 'appmanager --help' para más información.");
    }
}
