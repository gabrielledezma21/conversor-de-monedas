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
            throw new RuntimeException("No encontré la conversión entre esas monedas.");
        }
    }

    public void convertir(Integer monedaBase, Integer monedaDestino, Double montoAConvertir){

        String monedaInicial=moneda(monedaBase);
        String monedaFinal=moneda(monedaDestino);

        String salida1="Sus $"+montoAConvertir+" de "+stringDeMoneda(monedaInicial)
                +" equivalen a: $";
        String salida2=" "+stringDeMoneda(monedaFinal);
        Double resultado = montoAConvertir;
        //Double resultado2 = 0.0;
        if(monedaBase != monedaDestino){
            Conversor conversion = buscaConversionDeMoneda(monedaInicial,monedaFinal, montoAConvertir);
            resultado = conversion.getResultado();
            //resultado2 = conversion.getResultadoCalculado();


        }
        System.out.println(salida1+resultado+salida2);
        //System.out.println(salida1+resultado2+salida2);
    }

    public String moneda(Integer numMoneda){
        String resultado="";
        switch(numMoneda){
            case 1:
                resultado = "ARS";
                break;
            case 2:
                resultado = "USD";
                break;
            case 3:
                resultado = "EUR";
                break;
            case 4:
                resultado = "BRL";
                break;
            case 5:
                resultado = "CLP";
                break;
            case 6:
                resultado = "COP";
                break;
            case 7:
                resultado = "PYG";
                break;
            case 8:
                resultado = "UYU";
                break;
            case 9:
                resultado = "PEN";
                break;

        }
        return resultado;
    }

    public  String stringDeMoneda(String abreviacion){
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
            case "BRL":
                resultado="reales brasileños";
                break;
            case "CLP":
                resultado="pesos chilenos";
                break;
            case "COP":
                resultado="pesos colombianos";
                break;
            case "PYG":
                resultado="guaraníes";
                break;
            case "UYU":
                resultado="pesos uruguayos";
                break;
            case "PEN":
                resultado="soles";
                break;
        }
        return resultado;
    }
}

