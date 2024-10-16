package com.mipagina.conversorDeMonedas.servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mipagina.conversorDeMonedas.modelos.Conversor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeneradorDeArchivo {
    public void guardarJson(Conversor conversion) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("Conversiones.json", true);
        escritura.write(gson.toJson(conversion) + "\n");
        escritura.close();

    }
}
