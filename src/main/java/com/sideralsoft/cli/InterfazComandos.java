package com.sideralsoft.cli;

import picocli.CommandLine;

@CommandLine.Command(
        name = "appmanager",
        description = "Gestor de aplicaciones y certificados de SIDERALSOFT.",
        subcommands = {
                InstalacionComandos.class,
                ActualizacionComandos.class,
                ConsultaComandos.class
        },
        mixinStandardHelpOptions = true
)

public class InterfazComandos implements Runnable {

    @Override
    public void run() {
        System.out.println("AppManager CLI: usa '--help' para más información.");
    }
}
