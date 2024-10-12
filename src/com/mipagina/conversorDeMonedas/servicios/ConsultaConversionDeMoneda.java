package com.mipagina.conversorDeMonedas.servicios;

import com.google.gson.Gson;
import com.mipagina.conversorDeMonedas.modelos.Conversion;
import com.mipagina.conversorDeMonedas.modelos.ConversionDeMoneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversionDeMoneda {
    public Conversion buscaConversionDeMoneda(String monedaInicial, String monedaFinal, Double montoAConvertir){
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
            return new Conversion(miConversion,montoAConvertir);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la conversión entre esas monedas.");
        }
    }

    public void convertir(Integer opcion, Double montoAConvertir){

        String monedaInicial="";
        String monedaFinal="";
        switch(opcion){
            case 1:
                monedaInicial="ARS";
                monedaFinal="USD";
                break;
            case 2:
                monedaInicial="ARS";
                monedaFinal="USD";
                break;
            case 3:
                monedaInicial="USD";
                monedaFinal="ARS";
                break;
            case 4:
                monedaInicial="USD";
                monedaFinal="EUR";
                break;
            case 5:
                monedaInicial="EUR";
                monedaFinal="ARS";
                break;
            case 6:
                monedaInicial="EUR";
                monedaFinal="USD";
                break;

        }
        Conversion conversion = buscaConversionDeMoneda(monedaInicial,monedaFinal, montoAConvertir);
        System.out.println("Sus $"+montoAConvertir+" "+moneda(monedaInicial)
                +" equivalen a: $"+conversion.getResultado()+" "+moneda(monedaFinal));
    }

    public  String moneda(String abreviacion){
        String resultado="";
        switch(abreviacion){
            case "ARS":
                resultado="pesos argentinos";
                break;
            case "EUR":
                resultado="euros";
                break;
            case "USD":
                resultado="dólares estadounidenses";
                break;
        }
        return resultado;
    }
}

