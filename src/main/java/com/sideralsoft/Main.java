package com.sideralsoft;

import com.sideralsoft.cli.InterfazComandos;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new InterfazComandos()).execute(args);
        System.exit(exitCode);
    }
}