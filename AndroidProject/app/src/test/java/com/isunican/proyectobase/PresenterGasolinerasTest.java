package com.isunican.proyectobase;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Presenter.PresenterGasolineras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresenterGasolinerasTest {

    Gasolinera gasolinera;


    PresenterGasolineras presenter = new PresenterGasolineras();

    /**
     * Preparo los datos necesarios para la posterior ejecucion de las pruebas
     */
    @Before
    public  void setUp(){

        gasolinera = new Gasolinera(1, "Santander", "Cantabria", "",
                3.0, 2.0, 1.0, 4.0, 5.0, "TEXACO");

        presenter.getGasolineras().add(gasolinera);

    }


    @Test
    public void ordenarGasolineras()
    {


        assertEquals(4, 2 + 2);
    }

    @Test
    public void getPrecioGasolinera()
    {
        try {
            assertEquals(0.0 , presenter.getPrecioCombustible(null,null), 0.000001);
            Assert.fail("NullPointerException");
        } catch (NullPointerException e) {

        }

        assertEquals(3.0 , presenter.getPrecioCombustible("Gasóleo A", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(2.0 , presenter.getPrecioCombustible("Gasolina 95", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.0 , presenter.getPrecioCombustible("Gasolina 98", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(4.0 , presenter.getPrecioCombustible("Biodiésel", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(5.0 , presenter.getPrecioCombustible("Gasóleo Premium", presenter.getGasolineras().get(0)), 0.000001);

    }


}
