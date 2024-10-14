package com.mipagina.conversorDeMonedas.principal;

import com.mipagina.conversorDeMonedas.servicios.ConsultaConversionDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversionDeMoneda consulta = new ConsultaConversionDeMoneda();
        int monedaBase = -1;
        int monedaDestino = -1;
        Double monto = -1.0;
        System.out.println("Bienvenidos a nuestro conversor de monedas!!!");
        do{
            menu();
            try {
                monedaBase = Integer.valueOf(lectura.nextLine());
                if (monedaBase > 0 && monedaBase <= 9) {
                    do {
                        menuSecundario();
                        try{
                            monedaDestino = Integer.valueOf(lectura.nextLine());
                            if(monedaDestino > 9 || monedaDestino <1){
                                System.out.println("Opción incorrecta.");
                            } else {
                                do {
                                    System.out.println("Ingrese el monto a convertir: ");
                                    try {
                                        monto = Double.valueOf(lectura.nextLine());
                                        if (monto < 0.0) {
                                            System.out.println("El monto a convertir debe ser mayor a cero");
                                        } else {
                                            consulta.convertir(monedaBase, monedaDestino, monto);
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("El caracter ingresado no es un número.");
                                    }
                                } while (monto < 0.0);
                            }
                        }catch(NumberFormatException e){
                            System.out.println("El caracter ingresado no es un número.");
                        }

                    }while(monedaDestino < 1 || monedaDestino > 9);

                } else {
                    System.out.println("Opción incorrecta.");
                }

            } catch(NumberFormatException e){
                System.out.println("El caracter ingresado no es un número.");
            }
        }while(monedaBase != 0);
        System.out.println("Gracias por confiar en nosotros! Hasta pronto!");

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
                0. Salir
                
                ********************
                """;
        System.out.println(menu);
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
        System.out.println(menu);
    }
}
