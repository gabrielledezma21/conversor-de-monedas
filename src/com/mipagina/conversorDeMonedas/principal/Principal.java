package com.mipagina.conversorDeMonedas.principal;

import com.mipagina.conversorDeMonedas.modelos.Conversion;
import com.mipagina.conversorDeMonedas.servicios.ConsultaConversionDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversionDeMoneda consulta = new ConsultaConversionDeMoneda();
        int opcion = -1;
        do{
            menu();
            try {
                opcion = Integer.valueOf(lectura.nextLine());
                if (opcion > 0 && opcion <= 6) {
                    System.out.println("Ingrese el monto a convertir: ");
                    Double monto = Double.valueOf(lectura.nextLine());
                    consulta.convertir(opcion, Math.abs(monto));
                } else if (opcion == 0) {
                    System.out.println("Gracias por confiar en nosotros! Hasta pronto!");
                } else {
                    System.out.println("Opción incorrecta.");
                }
            } catch(NumberFormatException e){
                System.out.println("El caracter ingresado no es un número.");
            }
        }while(opcion != 0);

    }

    public static void menu(){
        String menu = """
                ********************
                
                Escriba la conversión que desea realizar: 
                
                1. Peso Argentino a Dolar
                2. Peso Argentino a Euro
                3. Dolar a Peso Argentino
                4. Dolar a Euro
                5. Euro a Peso Argentino
                6. Euro a Dolar
                0. Salir
                
                ********************
                """;
        System.out.println(menu);
    }




}
