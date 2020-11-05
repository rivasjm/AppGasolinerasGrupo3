package com.isunican.proyectobase;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Presenter.PresenterGasolineras;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    ArrayList<Gasolinera> gasolineras;

    // Objeto de la clase Presentergasolineras para implementar los siguientes metodos Test
    PresenterGasolineras presenter = new PresenterGasolineras();

    /**
     * Preparo los datos necesarios para la posterior ejecucion de las pruebas
     */
    @Before
    public  void setUp(){
        presenter = new PresenterGasolineras();//se inicializa el presenter
        gasolineras = new ArrayList<>();//se crea lista de de tipo Gasolina para probar
        /*Se anhaden varias gasolineras a la lista para pasarselas al presenter y utilizarlas en la pruebas*/
        gasolineras.add(new Gasolinera(0, "Castro", "Cantabria", "Calle 1",
                0.91, 1.06, 1.11, 1.31, 1.01, "CEPSA"));
        gasolineras.add(new Gasolinera(0, "Viesgo", "Cantabria", "Calle 2",
                1.01, 1.09, 1.11, 1.26, 1.16, "Respol"));
        gasolineras.add(new Gasolinera(0, "Puente San Miguel", "Cantabria", "Calle 1",
                0.92, 1.12, 1.09, 1.26, 0.97, "Shell"));
        gasolineras.add(new Gasolinera(0, "Tanos", "Cantabria", "Calle 3",
                1.02, 1.21, 1.08, 1.35, 0.93, "Repsol"));
        gasolineras.add(new Gasolinera(0, "Ganzo", "Cantabria", "Calle 4",
                0.96, 0.99, 1.07, 1.15, 0.94, "CEPSA"));
        gasolineras.add(new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 5",
                0.97, 1.11, 1.07, 1.10, 0.92, "Shell"));
        gasolineras.add(new Gasolinera(0, "Santander", "Cantabria", "Calle 6",
                0.90, 1.03, 1.07, 1.14, 0.97, "CEPSA"));
        presenter.setGasolineras(gasolineras);
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
        assertEquals(0.90, presenter.getGasolineras().get(0).getGasoleoA(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasóleo A");
        assertEquals(1.02, presenter.getGasolineras().get(0).getGasoleoA(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasolina 95");
        assertEquals(0.99, presenter.getGasolineras().get(0).getGasolina95(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasolina 95");
        assertEquals(1.21, presenter.getGasolineras().get(0).getGasolina95(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasolina 98");
        assertEquals(1.07, presenter.getGasolineras().get(0).getGasolina98(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasolina 98");
        assertEquals(1.11, presenter.getGasolineras().get(0).getGasolina98(), 0.00001);

        presenter.ordernarGasolineras(true, "Biodiésel");
        assertEquals(1.10, presenter.getGasolineras().get(0).getBiodiesel(), 0.00001);

        presenter.ordernarGasolineras(false, "Biodiésel");
        assertEquals(1.35, presenter.getGasolineras().get(0).getBiodiesel(), 0.00001);

        presenter.ordernarGasolineras(true, "Gasóleo Premium");
        assertEquals(0.92, presenter.getGasolineras().get(0).getGasoleoPremium(), 0.00001);

        presenter.ordernarGasolineras(false, "Gasóleo Premium");
        assertEquals(1.16, presenter.getGasolineras().get(0).getGasoleoPremium(), 0.00001);
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

        assertEquals(0.91 , presenter.getPrecioCombustible("Gasóleo A", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.06 , presenter.getPrecioCombustible("Gasolina 95", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.11 , presenter.getPrecioCombustible("Gasolina 98", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.31 , presenter.getPrecioCombustible("Biodiésel", presenter.getGasolineras().get(0)), 0.000001);

        assertEquals(1.01 , presenter.getPrecioCombustible("Gasóleo Premium", presenter.getGasolineras().get(0)), 0.000001);

    }

}
