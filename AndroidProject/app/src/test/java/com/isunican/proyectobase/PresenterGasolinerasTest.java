package com.isunican.proyectobase;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Presenter.PresenterGasolineras;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Clase de prueba donde se realizan las pruebas unitarias correspondiente a la clase
 * PresenterGasolineras.
 *
 * @author Corocotta
 */
public class PresenterGasolinerasTest {
    private PresenterGasolineras pr;
    private ArrayList<Gasolinera> gasolineras;

    @Before
    public void setUp(){
        pr = new PresenterGasolineras();//se inicializa el presenter
        gasolineras = new ArrayList<>();//se crea lista de de tipo Gasolina para probar
        /*Se anhaden varias gasolineras a la lista para pasarselas al presenter y utilizarlas en la pruebas*/
        gasolineras.add(new Gasolinera(0, "Castro", "Cantabria", "Calle 1",
                0.94, 1.06, 1.07, 1.26, 0.97, "CEPSA"));
        gasolineras.add(new Gasolinera(0, "Viesgo", "Cantabria", "Calle 2",
                0.94, 1.06, 1.07, 1.26, 0.97, "Respol"));
        gasolineras.add(new Gasolinera(0, "Puente San Miguel", "Cantabria", "Calle 1",
                0.94, 1.06, 1.07, 1.26, 0.97, "Shell"));
        gasolineras.add(new Gasolinera(0, "Tanos", "Cantabria", "Calle 3",
                0.94, 1.06, 1.07, 1.26, 0.97, "Repsol"));
        gasolineras.add(new Gasolinera(0, "Ganzo", "Cantabria", "Calle 4",
                0.94, 1.06, 1.07, 1.26, 0.97, "CEPSA"));
        gasolineras.add(new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 5",
                0.94, 1.06, 1.07, 1.26, 0.97, "Shell"));
        gasolineras.add(new Gasolinera(0, "Santander", "Cantabria", "Calle 6",
                0.94, 1.06, 1.07, 1.26, 0.97, "CEPSA"));
        pr.setGasolineras(gasolineras);
    }//setUp

    @Test
    public void eliminarGasolinerasConPrecionNegativoTest(){
        //caso donde la cadena pasada esta vacia
        pr.eliminaGasolinerasConPrecioNegativo("");
        boolean noCambiaLista = gasolineras.size() == 7;
        //se comprueba que el metodo no realiza ningun cambio en la lista
        assertTrue(noCambiaLista);

        //caso donde una gasolinera tiene el gasoleao con precio negativo
        Gasolinera gasolineraConPrecioGasoleoNegativo = new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                -0.3, 1.06, 1.07, 1.26, 0.97, "CEPSA");
        pr.eliminaGasolinerasConPrecioNegativo("Gasóleo A");
        //se comprueba que despues de ejecutar el metodo la gasoliner con precio negativo ya no esta en la lista
        assertFalse(gasolineras.contains(gasolineraConPrecioGasoleoNegativo));

        //caso donde una gasolinera tiene el gasolina 95 con precio negativo
        Gasolinera gasolineraConPrecioGasolina95Negativo = new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, -1.01, 1.07, 1.26, 0.97, "CEPSA");
        pr.eliminaGasolinerasConPrecioNegativo("Gasolina 95");
        //se comprueba que despues de ejecutar el metodo la gasoliner con precio negativo ya no esta en la lista
        assertFalse(gasolineras.contains(gasolineraConPrecioGasolina95Negativo));

        //caso donde una gasolinera tiene la gasolina 98 con precio negativo
        Gasolinera gasolineraConPrecioGasolina98Negativo = new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, -1.01, 1.07, 1.26, 0.97, "CEPSA");
        pr.eliminaGasolinerasConPrecioNegativo("Gasolina 98");
        //se comprueba que despues de ejecutar el metodo la gasoliner con precio negativo ya no esta en la lista
        assertFalse(gasolineras.contains(gasolineraConPrecioGasolina98Negativo));

        //caso donde una gasolinera tiene el biodiesel con precio negativo
        Gasolinera gasolineraConPrecioBiodieselNegativo = new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, -1.01, 1.07, 1.26, 0.97, "CEPSA");
        pr.eliminaGasolinerasConPrecioNegativo("Biodiésel");
        //se comprueba que despues de ejecutar el metodo la gasoliner con precio negativo ya no esta en la lista
        assertFalse(gasolineras.contains(gasolineraConPrecioBiodieselNegativo));

        //caso donde una gasolinera tiene el gasoleao premium con precio negativo
        Gasolinera gasolineraConPrecioGasoleoPremiumNegativo = new Gasolinera(0, "Torrelavega", "Cantabria", "Calle 1",
                0.94, -1.01, 1.07, 1.26, 0.97, "CEPSA");
        pr.eliminaGasolinerasConPrecioNegativo("Gasóleo Premium");
        //se comprueba que despues de ejecutar el metodo la gasoliner con precio negativo ya no esta en la lista
        assertFalse(gasolineras.contains(gasolineraConPrecioGasoleoPremiumNegativo));

        //caso donde el parametro pasado es nulo
        String parametro = null;
        //se comprueba que se lanza la excepcion NullPointerException
        try {
            pr.eliminaGasolinerasConPrecioNegativo(parametro);
            fail();
        }catch (NullPointerException e){}
        //se comprueba que el metodo no realiza ningun cambio en la lista
        assertTrue(noCambiaLista);

    }//eliminarGasolinerasConPrecionNegativoTest
}//class
