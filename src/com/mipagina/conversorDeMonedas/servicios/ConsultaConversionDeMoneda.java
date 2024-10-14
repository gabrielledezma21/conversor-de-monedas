package com.mipagina.conversorDeMonedas.servicios;

import com.google.gson.Gson;
import com.mipagina.conversorDeMonedas.modelos.Conversor;
import com.mipagina.conversorDeMonedas.modelos.ConversionDeMoneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversionDeMoneda {
    public Conversor buscaConversionDeMoneda(String monedaInicial, String monedaFinal, Double montoAConvertir){
        String miClave = "fa6965953df7e078c50edb46";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+miClave+"/pair/"+monedaInicial+"/"+monedaFinal+"/"+montoAConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ConversionDeMoneda miConversion = new Gson().fromJson(response.body(),ConversionDeMoneda.class);
            return new Conversor(miConversion,montoAConvertir);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la conversión deseada.");
        }
    }

    public Conversor convertir(Integer monedaBase, Integer monedaDestino, Double montoAConvertir){

        String monedaInicial=moneda(monedaBase);
        String monedaFinal=moneda(monedaDestino);

        return buscaConversionDeMoneda(monedaInicial, monedaFinal, montoAConvertir);

    }

    public String moneda(Integer numMoneda){
        return switch (numMoneda) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "EUR";
            case 4 -> "BRL";
            case 5 -> "CLP";
            case 6 -> "COP";
            case 7 -> "PYG";
            case 8 -> "UYU";
            case 9 -> "PEN";
            default -> "";
        };
    }
}

