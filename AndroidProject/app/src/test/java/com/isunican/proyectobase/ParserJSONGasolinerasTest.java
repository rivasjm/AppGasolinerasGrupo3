package com.isunican.proyectobase;

import android.util.JsonReader;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Utilities.ParserJSONGasolineras;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;



public class ParserJSONGasolinerasTest {


    private JsonReader reader;

    @Before
    public void setUp() {
        String jsonString = "[{" +
                "\"Rótulo\":\"Repsol\",\"Rótulo\":\"Repsol\",\"Localidad\":\"Santander\",\"Provincia\":\"Cantabria\"," +
                "\"IDEESS\":\"0\",\"Precio Gasoleo A\":\"0,95\",\"Precio Gasolina 95 E5\":\"1,01\"," +
                "\"Precio Gasolina 98 E5\":\"1,03\",\"Precio Biodiesel\":\"1,11\",\"Precio Gasoleo Premium\":\"0,99\"," +
                "\"Dirección\":\"Calle 001\"" +
                "}]";

        reader = new JsonReader(new StringReader(jsonString));
    }

    @Test
    public void readGasolinerTest() {
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
        assertTrue(g.getGasolina98() ==1.03);
        assertTrue(g.getGasoleoPremium() == 0.99);
        assertTrue(g.getBiodiesel() == 1.11);
    }
}

