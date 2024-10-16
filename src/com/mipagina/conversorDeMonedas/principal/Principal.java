package com.mipagina.conversorDeMonedas.principal;

import com.mipagina.conversorDeMonedas.modelos.Conversor;
import com.mipagina.conversorDeMonedas.servicios.ConsultaConversionDeMoneda;
import com.mipagina.conversorDeMonedas.servicios.GeneradorDeArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversionDeMoneda consulta = new ConsultaConversionDeMoneda();
        int monedaBase = -1;
        int monedaDestino = -1;
        double monto = -1.0;
        List<Conversor> conversiones = new ArrayList<>();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        System.out.println("\n"+"Bienvenidos a nuestro conversor de monedas!!!");
        do{
            menu();
            try {
                monedaBase = Integer.valueOf(lectura.nextLine());
                if (monedaBase > 0 && monedaBase <= 9) {
                    do {
                        menuSecundario();
                        try {
                            monedaDestino = Integer.valueOf(lectura.nextLine());
                            if (monedaDestino > 9 || monedaDestino < 1) {
                                System.out.println("Opción incorrecta."+"\n");
                            } else {
                                do {
                                    System.out.println("\n"+"Ingrese el monto a convertir: "+"\n");
                                    try {
                                        monto = Double.valueOf(lectura.nextLine());
                                        if (monto < 0.0) {
                                            System.out.println("El monto a convertir debe ser mayor a cero"+"\n");
                                        } else {
                                            Conversor c = consulta.convertir(monedaBase, monedaDestino, monto);
                                            conversiones.add(c);
                                            generador.guardarJson(c);
                                            System.out.println("\n"+c.toString());
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("El caracter ingresado no es un número."+"\n");
                                    }
                                } while (monto < 0.0);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("El caracter ingresado no es un número."+"\n");
                        }

                    } while (monedaDestino < 1 || monedaDestino > 9);

                } else if( monedaBase == 10){
                    System.out.println("\n"+"********************"+"\n");
                    System.out.println("HISTORIAL DE CONVERSIONES"+"\n");
                    for (int i = 0; i < conversiones.size(); i++) {
                        System.out.println(conversiones.get(i).toString()+"\n");
                    }
                    System.out.println("********************"+"\n");
                } else if(monedaBase == 0){
                    System.out.println("\n"+"Gracias por confiar en nosotros! Hasta pronto!");
                } else {
                    System.out.println("Opción incorrecta.");
                }
            } catch(NumberFormatException e){
                System.out.println("El caracter ingresado no es un número.");
            }
        }while(monedaBase != 0);

    }

    public static void menu(){
        String menu = """
                ********************
                
                Ingrese la moneda desde la cual desea convertir:  
                
                1. Pesos Argentinos
                2. Dólares Estadounidenses
                3. Euros
                4. Reales Brasileños 
                5. Pesos Chilenos
                6. Pesos Colombianos 
                7. Guaraníes 
                8. Pesos Uruguayos 
                9. Soles
                10. Ver historial de conversiones
                0. Salir
                
                ********************
                """;
        System.out.println("\n"+menu);
    }

    public static void menuSecundario(){
        String menu = """
                ********************
                
                Ingrese la moneda de destino:  
                
                1. Pesos Argentinos
                2. Dólares Estadounidenses
                3. Euros
                4. Reales Brasileños 
                5. Pesos Chilenos 
                6. Pesos Colombianos 
                7. Guaraníes 
                8. Pesos Uruguayos 
                9. Soles 
                                
                ********************
                """;
        System.out.println("\n"+menu);
    }
}
