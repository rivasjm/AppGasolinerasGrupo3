package com.isunican.proyectobase;

import com.isunican.proyectobase.Model.Gasolinera;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GasolineraTest {

    Gasolinera g;

    /**
     * Preparo los datos necesarios para la posterior ejecucion de las pruebas
     */
    @Before
    public  void setUp(){
        g=new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, 1.06, 1.07, 1.26, 0.97, "CEPSA");
    }

    @Test
    public void constructorGasolineraTest(){
        assertEquals( g.getLocalidad(), "Torrelavega");
        assertEquals( g.getProvincia(), "Cantabria");
        assertEquals(g.getDireccion(), "Calle 1");

        assertTrue( g.getGasoleoA() == 0.94);
        assertTrue( g.getGasolina95() == 1.06);
        assertTrue( g.getGasolina98() ==1.07);
        assertTrue( g.getGasoleoPremium() == 0.97);
        assertTrue( g.getBiodiesel() == 1.26);

        assertEquals(g.getRotulo(), "CEPSA");
    }
}
