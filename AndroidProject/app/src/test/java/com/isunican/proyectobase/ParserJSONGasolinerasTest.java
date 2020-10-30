package com.isunican.proyectobase;

import android.os.Build;
import android.util.JsonReader;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Utilities.ParserJSONGasolineras;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)

public class ParserJSONGasolinerasTest {


    private JsonReader reader;
    private JsonReader readerGasolineras;

    @Before
    public void setUp() {
        //Gasolinera en formato Json
        String jsonString = "{" +
                "\"Rótulo\":\"Repsol\",\"Localidad\":\"Santander\",\"Provincia\":\"Cantabria\"," +
                "\"IDEESS\":\"0\",\"Precio Gasoleo A\":\"0,95\",\"Precio Gasolina 95 E5\":\"1,01\"," +
                "\"Precio Gasolina 98 E5\":\"1,03\",\"Precio Biodiesel\":\"1,11\",\"Precio Gasoleo Premium\":\"0,99\"," +
                "\"Dirección\":\"Calle 001\"" +
                "}";

        reader = new JsonReader(new StringReader(jsonString));

        //String con varias gasolineras en formato array Json
        String jsonGasolineras = "{ \"ListaEESSPrecio\" : [{" +
                "\"Rótulo\":\"REPSOL\",\"Localidad\":\"Torrelavega\",\"Provincia\":\"Cantabria\"," +
                "\"IDEESS\":\"0\",\"Precio Gasoleo A\":\"0,95\",\"Precio Gasolina 95 E5\":\"1,01\"," +
                "\"Precio Gasolina 98 E5\":\"1,03\",\"Precio Biodiesel\":\"1,11\",\"Precio Gasoleo Premium\":\"0,99\"," +
                "\"Dirección\":\"Calle 002\"" +
                "}, {" +
                "\"Rótulo\":\"SHELL\",\"Localidad\":\"Castro Urdiales\",\"Provincia\":\"Cantabria\"," +
                "\"IDEESS\":\"0\",\"Precio Gasoleo A\":\"0,92\",\"Precio Gasolina 95 E5\":\"1,10\"," +
                "\"Precio Gasolina 98 E5\":\"1,13\",\"Precio Biodiesel\":\"1,19\",\"Precio Gasoleo Premium\":\"0,97\"," +
                "\"Dirección\":\"Calle 003\"" +
                "}]}";

        readerGasolineras = new JsonReader(new StringReader(jsonGasolineras));
    }

    @Test
    public void readGasolineraTest() {
        Gasolinera g = null;
        try {
            g = ParserJSONGasolineras.readGasolinera(reader);
        } catch (IOException e) {
            fail();
        }

        assertEquals(g.getLocalidad(), "Santander");
        assertEquals(g.getProvincia(), "Cantabria");
        assertEquals(g.getDireccion(), "Calle 001");

        assertTrue(g.getGasoleoA() == 0.95);
        assertTrue(g.getGasolina95() == 1.01);
        assertTrue(g.getGasolina98() == 1.03);
        assertTrue(g.getGasoleoPremium() == 0.99);
        assertTrue(g.getBiodiesel() == 1.11);

        //caso donde el Json pasado no tiene formato correcto
        reader = new JsonReader(new StringReader(""));
        try{
            g = ParserJSONGasolineras.readGasolinera(reader);
            fail();
        }catch (IOException e ){

        }
    }

    @Test
    public void readGasolinerasTest() {
        List<Gasolinera> gasolineras = new ArrayList<>();
        try {
            gasolineras = ParserJSONGasolineras.readArrayGasolineras(readerGasolineras);
        } catch (IOException e) {
            fail();
        }

        assertEquals(gasolineras.get(0).getLocalidad(), "Torrelavega");
        assertEquals(gasolineras.get(0).getProvincia(), "Cantabria");
        assertEquals(gasolineras.get(0).getDireccion(), "Calle 002");

        assertTrue(gasolineras.get(0).getGasoleoA() == 0.95);
        assertTrue(gasolineras.get(0).getGasolina95() == 1.01);
        assertTrue(gasolineras.get(0).getGasolina98() == 1.03);
        assertTrue(gasolineras.get(0).getGasoleoPremium() == 0.99);
        assertTrue(gasolineras.get(0).getBiodiesel() == 1.11);

        assertEquals(gasolineras.get(1).getLocalidad(), "Castro Urdiales");
        assertEquals(gasolineras.get(1).getProvincia(), "Cantabria");
        assertEquals(gasolineras.get(1).getDireccion(), "Calle 003");

        assertTrue(gasolineras.get(1).getGasoleoA() == 0.92);
        assertTrue(gasolineras.get(1).getGasolina95() == 1.10);
        assertTrue(gasolineras.get(1).getGasolina98() == 1.13);
        assertTrue(gasolineras.get(1).getGasoleoPremium() == 0.97);
        assertTrue(gasolineras.get(1).getBiodiesel() == 1.19);


        //caso donde el Json pasado no tiene formato correcto
        readerGasolineras = new JsonReader(new StringReader(""));
        try{
          gasolineras = ParserJSONGasolineras.readArrayGasolineras(readerGasolineras);
          fail();
        }catch (IOException e ){

        }
    }
}

