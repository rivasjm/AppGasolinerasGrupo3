package com.isunican.proyectobase;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Presenter.PresenterGasolineras;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Pruebas unitarias para comprobar el correcto funcionamiento de los metodos
 * ordenarGasolineras y getPrecioGasolinera
 *
 * @author Juan David Corrales Gil (jcg700@alumnos.unican.es)
 * @version Nov - 2020
 */
public class PresenterGasolinerasTest {

    // Gasolineras para utilizarlas posteriormente
    Gasolinera gasolinera;
    Gasolinera gasolinera1;
    Gasolinera gasolinera2;
    Gasolinera gasolinera3;
    Gasolinera gasolinera4;
    Gasolinera gasolinera5;
    Gasolinera gasolinera6;

    // Objeto de la clase Presentergasolineras para implementar los siguientes metodos Test
    PresenterGasolineras presenter = new PresenterGasolineras();

    /**
     * Preparo los datos necesarios para la posterior ejecucion de las pruebas
     */
    @Before
    public  void setUp(){

        gasolinera = new Gasolinera(1, "Santander", "Cantabria", "",
                3.0, 2.0, 1.0, 4.0, 5.0, "TEXACO");

        gasolinera1 = new Gasolinera(1, "Santander", "Cantabria", "",
                1.0, 6.0, 5.0, 3.0, 5.0, "TEXACO");

        gasolinera2 = new Gasolinera(1, "Santander", "Cantabria", "",
                2.0, 5.0, 1.0, 2.0, 4.0, "TEXACO");

        gasolinera3 = new Gasolinera(1, "Santander", "Cantabria", "",
                3.0, 4.0, 2.0, 6.0, 1.0, "TEXACO");

        gasolinera4 = new Gasolinera(1, "Santander", "Cantabria", "",
                4.0, 3.0, 3.0, 1.0, 6.0, "TEXACO");

        gasolinera5 = new Gasolinera(1, "Santander", "Cantabria", "",
                5.0, 2.0, 6.0, 4.0, 2.0, "TEXACO");

        gasolinera6 = new Gasolinera(1, "Santander", "Cantabria", "",
                6.0, 1.0, 4.0, 5.0, 3.0, "TEXACO");

        presenter.getGasolineras().add(gasolinera);
        presenter.getGasolineras().add(gasolinera1);
        presenter.getGasolineras().add(gasolinera2);
        presenter.getGasolineras().add(gasolinera3);
        presenter.getGasolineras().add(gasolinera4);
        presenter.getGasolineras().add(gasolinera5);
        presenter.getGasolineras().add(gasolinera6);

    }


    /*
     * Test para el metodo ordenarGasolineras
     * Se comprobara si funciona correctamente ascender y descender dependiendo
     * del precio de las gasolineras creadas anteriormente.
     */
    @Test
    public void ordenarGasolineras()
    {

        try {
            presenter.ordernarGasolineras(true, null);
            fail();
        } catch (NullPointerException e) {

        }
        
        presenter.ordernarGasolineras(true, "Gasóleo A");
        assertEquals(1.0, presenter.getGasolineras().get(0).getGasoleoA(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasóleo A");
        assertEquals(6.0, presenter.getGasolineras().get(0).getGasoleoA(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasolina 95");
        assertEquals(1.0, presenter.getGasolineras().get(0).getGasolina95(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasolina 95");
        assertEquals(6.0, presenter.getGasolineras().get(0).getGasolina95(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasolina 98");
        assertEquals(1.0, presenter.getGasolineras().get(0).getGasolina98(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasolina 98");
        assertEquals(6.0, presenter.getGasolineras().get(0).getGasolina98(), 0.00001);

        presenter.ordernarGasolineras(true, "Biodiésel");
        assertEquals(1.0, presenter.getGasolineras().get(0).getBiodiesel(), 0.00001);

        presenter.ordernarGasolineras(false, "Biodiésel");
        assertEquals(6.0, presenter.getGasolineras().get(0).getBiodiesel(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasóleo Premium");
        assertEquals(1.0, presenter.getGasolineras().get(0).getGasoleoPremium(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasóleo Premium");
        assertEquals(6.0, presenter.getGasolineras().get(0).getGasoleoPremium(), 0.00001);
    }

    /*
     * Test para el metodo getPrecioGasolinera
     * Se comprobara si retorna correctamente el precio de cada tipo de combustible
     * de las gasolineras creadas anteriormente.
     */
    @Test
    public void getPrecioGasolinera()
    {
        try {
            assertEquals(0.0 , presenter.getPrecioCombustible(null,null), 0.000001);
            fail();
        } catch (NullPointerException e) {

        }

        assertEquals(3.0 , presenter.getPrecioCombustible("Gasóleo A", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(2.0 , presenter.getPrecioCombustible("Gasolina 95", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.0 , presenter.getPrecioCombustible("Gasolina 98", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(4.0 , presenter.getPrecioCombustible("Biodiésel", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(5.0 , presenter.getPrecioCombustible("Gasóleo Premium", presenter.getGasolineras().get(0)), 0.000001);

    }
}
