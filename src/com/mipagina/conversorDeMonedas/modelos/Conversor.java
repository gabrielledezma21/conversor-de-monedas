package com.mipagina.conversorDeMonedas.modelos;

public class Conversor {
    private String monedaInicial;
    private String monedaFinal;
    private Double tipoDeCambio;
    private Double resultado;
    private Double montoAConvertir;

    public Conversor(ConversionDeMoneda miConversion, Double montoAConvertir){
        this.monedaInicial = miConversion.base_code();
        this.monedaFinal = miConversion.target_code();
        this.tipoDeCambio = miConversion.conversion_rate();
        this.resultado = miConversion.conversion_result();
        this.montoAConvertir = montoAConvertir;
    }

    public Double getResultado() {
        return resultado;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public Double getMontoAConvertir() {
        return montoAConvertir;
    }

    public Double getResultadoCalculado(){
        return this.montoAConvertir * this.tipoDeCambio;
    }

    public String toString(){
        return "Sus $" + montoAConvertir
                + " " + stringDeMoneda(monedaInicial)
                + " equivalen a: $"
                + resultado
                + " " + stringDeMoneda(monedaFinal);
    }

    //podria utilizar en lugar de resultado, getResultadoCalculado

    public  String stringDeMoneda(String abreviacion){
        return switch(abreviacion) {
            case "ARS" -> "pesos argentinos";
            case "EUR" -> "euros";
            case "USD" -> "dólares estadounidenses";
            case "BRL" -> "reales brasileños";
            case "CLP" -> "pesos chilenos";
            case "COP" -> "pesos colombianos";
            case "PYG" -> "guaraníes";
            case "UYU" -> "pesos uruguayos";
            case "PEN" -> "soles";
            default -> "";
        };
    }
}
