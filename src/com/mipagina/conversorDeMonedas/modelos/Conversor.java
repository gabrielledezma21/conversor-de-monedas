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


}
