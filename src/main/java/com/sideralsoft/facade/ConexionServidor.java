package com.sideralsoft.facade;

import com.sideralsoft.component.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ConexionServidor {

    private static final Logger LOG = LoggerFactory.getLogger(ConexionServidor.class);

    public static String obtenerVersionActual(String nombreElemento) {
        String nombre = URLEncoder.encode(nombreElemento, StandardCharsets.UTF_8);
        String baseUrl = ApplicationProperties.getProperty("api.url") + "/version";
        String urlConParametros = String.format("%s?nombre=%s", baseUrl, nombre);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlConParametros))
                    .header("Authorization", ApplicationProperties.getProperty("api.security.token"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                LOG.debug("No se ha encontrado una instalacion de " + nombreElemento);
                return "No se ha encontrado una instalacion de " + nombreElemento;
            }

            LOG.debug("Version actual de {}: {}", nombreElemento, response.body());
            return response.body();
        } catch (Exception e) {
            LOG.error("Error al consultar la cliente: {}", e.getMessage());
        }
        return null;
    }

    public static String actualizarElemento(String nombreElemento) {
        String nombre = URLEncoder.encode(nombreElemento, StandardCharsets.UTF_8);
        String baseUrl = ApplicationProperties.getProperty("api.url") + "/update";
        String urlConParametros = String.format("%s?nombre=%s", baseUrl, nombre);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlConParametros))
                    .header("Authorization", ApplicationProperties.getProperty("api.security.token"))
                    .POST(HttpRequest.BodyPublishers.ofString(nombreElemento))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                LOG.debug("Ha ocurrido un error al intentar actualizar " + nombreElemento);
                return "Ha ocurrido un error al intentar actualizar " + nombreElemento;
            }

            return response.body();
        } catch (Exception e) {
            LOG.error("Error al consultar la cliente: {}", e.getMessage());
            return "Error al consultar la cliente: " + e.getMessage();
        }
    }

    public static String actualizarElemento(String nombreElemento, String dependencia) {
        String nombre = URLEncoder.encode(nombreElemento, StandardCharsets.UTF_8);
        String baseUrl = ApplicationProperties.getProperty("api.url") + "/update/dependency";
        String urlConParametros = String.format("%s?nombre=%s&dependencia=%s", baseUrl, nombre, dependencia);

        Map<String, String> cuerpo = Map.of("nombre", nombre, "dependencia", dependencia);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlConParametros))
                    .header("Authorization", ApplicationProperties.getProperty("api.security.token"))
                    .POST(HttpRequest.BodyPublishers.ofString(cuerpo.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                LOG.debug("Ha ocurrido un error al intentar actualizar " + nombreElemento);
                return "Ha ocurrido un error al intentar actualizar " + nombreElemento;
            }

            return response.body();
        } catch (Exception e) {
            LOG.error("Error al consultar la cliente: {}", e.getMessage());
            return "Error al consultar la cliente: " + e.getMessage();
        }
    }

    public static String instalarElemento(String nombreElemento, String tipo, String dependencia) {
        String nombre = URLEncoder.encode(nombreElemento, StandardCharsets.UTF_8);
        String tipoElemento = URLEncoder.encode(tipo, StandardCharsets.UTF_8);
        String baseUrl = ApplicationProperties.getProperty("api.url") + "/install";
        String urlConParametros;

        if (dependencia != null) {
            urlConParametros = String.format("%s/dependency?nombre=%s&tipo=%s&dependencia=%s", baseUrl, nombre, tipoElemento, URLEncoder.encode(dependencia, StandardCharsets.UTF_8));
        }else {
            urlConParametros = String.format("%s?nombre=%s&tipo=%s", baseUrl, nombre, tipoElemento);
        }

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlConParametros))
                    .header("Authorization", ApplicationProperties.getProperty("api.security.token"))
                    .POST(HttpRequest.BodyPublishers.ofString(nombreElemento))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                LOG.debug("Ha ocurrido un error al intentar instalar " + nombreElemento);
                return "Ha ocurrido un error al intentar instalar " + nombreElemento;
            }

            return response.body();
        } catch (Exception e) {
            LOG.error("Error al consultar la cliente: {}", e.getMessage());
            return "Error al consultar la cliente: " + e.getMessage();
        }
    }

}
