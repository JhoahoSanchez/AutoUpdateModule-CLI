package com.sideralsoft.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties;

    private static void cargarPropiedades() {
        properties = new Properties();
        try (InputStream input = ApplicationProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo application.properties");
                return;
            }
            if (properties != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo application.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            ApplicationProperties.cargarPropiedades();
        }
        return properties.getProperty(key);
    }
}
