package com.isunican.proyectobase.Views;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.R;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * Clase para realizar las pruebas de interfaz de usuario (UI Test) para la historia
 * de usuario "Ordenas gasolineras por distancia".
 *
 * @author Jaime Eduardo Baires Escalante
 * @version Noviembre - 2020
 */
@RunWith(AndroidJUnit4.class)
public class OrdenarGasolinerasPorDistanciaUITest {

    private ListView ltmp;
    Gasolinera g1,g2,g3,gN1,gN2,gN3;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        //Se pondrá el tipo de combustible "Gasóleo A" para realizar esta prueba
        onView(ViewMatchers.withId(R.id.buttonFiltros)).perform(click());
        onView((withId(R.id.spinner))).perform(click());
        onData(allOf(is(instanceOf(String.class)),is("Gasóleo A"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Gasóleo A"))));
        onView(withText("Aceptar")).perform(click());
    }

    @Test
    public void ordenarPorDistanciaUITest() {

        /*
        * UIT.1A: Se comprobará que, al seleccionar el botón de criterio de ordenación, estén presentes en el
        * desplegable tanto la ordenación por precio como por distancia.
        * */
        onView(ViewMatchers.withId(R.id.buttonOrden)).perform(click()); //Accedo a ordenación
        onView((withId(R.id.spinner))).perform(click()); //Doy click al spinner de criterio de orden (CAMBIAR NOMBRE SPINNER)
        onData(allOf(is(instanceOf(String.class)),is("Distancia"))).inRoot(isPlatformPopup()).perform(click()); //Doy click a la opción de distancia
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Distancia")))); //Verifico que se haya seleccionado la opción (CAMBIAR NOMBRE SPINNER)
        onView((withId(R.id.spinner))).perform(click()); //Doy click al spinner de criterio de orden (CAMBIAR NOMBRE SPINNER)
        onData(allOf(is(instanceOf(String.class)),is("Precio"))).inRoot(isPlatformPopup()).perform(click()); //Doy click a la opción de precio
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Precio")))); //Verifico que se haya seleccionado la opción (CAMBIAR NOMBRE SPINNER)


        /*
        * UIT.1B: Se verificará que, al escoger el criterio de ordenación por distancia, y al darle “Aceptar”,
        * se ordenen las gasolineras de menor a mayor distancia (ya que el criterio por defecto es ordenar de forma ascendente),
        * comprobando que la primera gasolinera tiene una distancia menor que la segunda, y la segunda una distancia menor que la tercera.
        * */
        onView((withId(R.id.spinner))).perform(click()); //Doy click al spinner de criterio de orden (CAMBIAR NOMBRE SPINNER)
        onData(allOf(is(instanceOf(String.class)),is("Distancia"))).inRoot(isPlatformPopup()).perform(click()); //Doy click a la opción de distancia
        onView(withText("Aceptar")).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        g2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        g3 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
        assertTrue(g1.getGasoleoA()<=g2.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA
        assertTrue(g2.getGasoleoA()<=g3.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA


        /*
        * UIT.1C: Se verificará que, al seleccionar el botón de criterio de ordenación, aparezca
        * seleccionado en el desplegable el criterio “Distancia”.
        * */
        onView(ViewMatchers.withId(R.id.buttonOrden)).perform(click()); //Accedo a ordenación
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Distancia")))); //Verifico que se esté seleccionada la opción (CAMBIAR NOMBRE SPINNER)


        /*
        * UIT.1D: Se verificará que, al escoger el criterio de ordenación por precio y darle
        * “Cancelar”, las gasolineras no han cambiado de lugar, es decir, no se ha aplicado la ordenación por precio.
        * */
        onView((withId(R.id.spinner))).perform(click()); //Doy click al spinner de criterio de orden (CAMBIAR NOMBRE SPINNER)
        onData(allOf(is(instanceOf(String.class)),is("Precio"))).inRoot(isPlatformPopup()).perform(click()); //Doy click a la opción de precio
        onView(withText("Cancelar")).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        gN1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        gN2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        gN3 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
        //Comprobaciones gasolinera 1
        assertEquals(gN1.getDireccion(),g1.getDireccion());
        assertEquals(gN1.getRotulo(),g1.getRotulo());
        assertEquals(gN1.getLocalidad(),g1.getLocalidad());
        assertEquals(gN1.getProvincia(),g1.getProvincia());
        assertTrue(gN1.getGasoleoA()==g1.getGasoleoA());
        assertTrue(gN1.getGasoleoPremium()==g1.getGasoleoPremium());
        assertTrue(gN1.getGasolina95()==g1.getGasolina95());
        assertTrue(gN1.getGasolina98()==g1.getGasolina98());
        assertTrue(gN1.getBiodiesel()==g1.getBiodiesel());
        //Comprobaciones gasolinera 2
        assertEquals(gN2.getDireccion(),g2.getDireccion());
        assertEquals(gN2.getRotulo(),g2.getRotulo());
        assertEquals(gN2.getLocalidad(),g2.getLocalidad());
        assertEquals(gN2.getProvincia(),g2.getProvincia());
        assertTrue(gN2.getGasoleoA()==g2.getGasoleoA());
        assertTrue(gN2.getGasoleoPremium()==g2.getGasoleoPremium());
        assertTrue(gN2.getGasolina95()==g2.getGasolina95());
        assertTrue(gN2.getGasolina98()==g2.getGasolina98());
        assertTrue(gN2.getBiodiesel()==g2.getBiodiesel());
        //Comprobaciones gasolinera 3
        assertEquals(gN3.getDireccion(),g3.getDireccion());
        assertEquals(gN3.getRotulo(),g3.getRotulo());
        assertEquals(gN3.getLocalidad(),g3.getLocalidad());
        assertEquals(gN3.getProvincia(),g3.getProvincia());
        assertTrue(gN3.getGasoleoA()==g3.getGasoleoA());
        assertTrue(gN3.getGasoleoPremium()==g3.getGasoleoPremium());
        assertTrue(gN3.getGasolina95()==g3.getGasolina95());
        assertTrue(gN3.getGasolina98()==g3.getGasolina98());
        assertTrue(gN3.getBiodiesel()==g3.getBiodiesel());



        /*
        * UIT.1E: Se verificará que, al pulsar sobre la flecha de la derecha, se cambie el orden
        * de las gasolineras a descendente, es decir, que aparezcan ordenadas de mayor a menor distancia.
        * */
        onView(ViewMatchers.withId(R.id.cambioOrden)).perform(click()); //Doy click a la imagen de cambio de orden (CAMBIAR NOMBRE IMAGEN)
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        g2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        g3 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
        assertTrue(g1.getGasoleoA()>=g2.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA
        assertTrue(g2.getGasoleoA()>=g3.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA


        /*
        * UIT.1F: Se verificará que, al pulsar de nuevo sobre la flecha de la derecha, se cambie
        * el orden de las gasolineras a ascendente, es decir, que aparezcan ordenadas de menor a mayor distancia.
        * */
        onView(ViewMatchers.withId(R.id.cambioOrden)).perform(click()); //Doy click a la imagen de cambio de orden (CAMBIAR NOMBRE IMAGEN)
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        g2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        g3 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
        assertTrue(g1.getGasoleoA()<=g2.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA
        assertTrue(g2.getGasoleoA()<=g3.getGasoleoA()); //CAMBIAR LO QUE SE COMPRUEBA
    }

}
