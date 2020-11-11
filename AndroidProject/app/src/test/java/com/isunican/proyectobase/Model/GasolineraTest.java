package com.isunican.proyectobase.Model;

import com.isunican.proyectobase.Model.Gasolinera;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GasolineraTest {

    private Gasolinera g;

    /**
     * Preparo los datos necesarios para la posterior ejecucion de las pruebas
     */
    @Before
    public  void setUp(){
        g=new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, 1.06, 1.07, 1.26, 0.97, "CEPSA", 40, -3);
    }

    @Test
    public void constructorGasolineraTest(){
        assertEquals("Torrelavega", g.getLocalidad());
        assertEquals("Cantabria", g.getProvincia());
        assertEquals("Calle 1", g.getDireccion());

        assertEquals(0.94, g.getGasoleoA(), 0.001);
        assertEquals(1.06, g.getGasolina95(), 0.001);
        assertEquals(1.07, g.getGasolina98(), 0.001);
        assertEquals(0.97, g.getGasoleoPremium(), 0.001);
        assertEquals(1.26, g.getBiodiesel(), 0.001);

        assertEquals("CEPSA", g.getRotulo());
    }

    @Test
    public void getLatitudLongitudTest() {
        //Se comprueba que se ha almacenado correctamente el valor de latitud
        assertEquals(40,g.getLatitud(),0.001);

        //Se comprueba que se ha almacenado correctamente el valor de longitud
        assertEquals(-3,g.getLongitud(),0.001);
    }
}
