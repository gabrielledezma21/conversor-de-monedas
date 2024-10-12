package com.mipagina.conversorDeMonedas.modelos;

public record ConversionDeMoneda(String base_code,String target_code, Double conversion_rate ,Double conversion_result) {
}
