package com.mipagina.conversorDeMonedas.modelos;

public class Conversion {
    private String monedaInicial;
    private String monedaFinal;
    private Double tipoDeCambio;
    private Double resultado;
    private Double montoAConvertir;

    public Conversion(ConversionDeMoneda miConversion, Double montoAConvertir){
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
}
