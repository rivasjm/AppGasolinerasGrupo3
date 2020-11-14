package com.isunican.proyectobase;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.isunican.proyectobase.Views.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/*
 * Clase para realizar las pruebas de interfaz de usuario (UI Test) para la historia
 * de usuario "Establecer Tipo De Combustible".
 *
 * @author Juan David Corrales Gil (jcg700@alumnos.unican.es)
 * @version Noviembre - 2020
 */
@RunWith(AndroidJUnit4.class)
public class EstablecerTipoDeCombustibleUITest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void establecerTipoCombustibleTest() throws InterruptedException {

        // Caso UIT.1A
        // Se pulsa sobre el icono de las tres barras de arriba a la izquierda para abrir el Drawer Layout
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.START))) // Start Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Se pulsa sobre el icono de las tres barras de arriba a la izquierda para abrir el Drawer Layout
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen(Gravity.START))); // Start Drawer should be open.

        //onView(withId(R.id.imagenDrawer)).perform(click());

        // Start the screen of your activity.
        onView(withId(R.layout.nav_drawer_layout))
                .perform(NavigationViewActions.navigateTo(R.id.combustible_por_defecto));

        // Check that you Activity was opened.
        onView(withId(R.id.btnConfiguracion)).check(matches(withText("Configuración")));

        // Caso UIT.1B
        onView(withId(R.id.btnConfiguracion)).perform(click());

        onView(withId(R.id.defecto)).check(matches(withText("Selecciona un tipo de combustible por defecto")));

        //onView(withId(R.id.porDefecto)).check(matches(withText("Combustible actual: ")));

        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se comprueba seleccionando cada elemento existente dentro del spinner
        // y se comprueba su correspondiente nombre si es el correcto
        onData(allOf(is(instanceOf(String.class)),
                is("Combustible"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Combustible"))));

        onView((withId(R.id.combustible_por_defecto))).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasóleo A"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Gasóleo A"))));

        onView((withId(R.id.combustible_por_defecto))).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 95"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Gasolina 95"))));

        onView((withId(R.id.combustible_por_defecto))).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 98"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Gasolina 98"))));

        onView((withId(R.id.combustible_por_defecto))).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Biodiésel"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Biodiésel"))));

        onView((withId(R.id.combustible_por_defecto))).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasóleo Premium"))).inRoot(isPlatformPopup()).perform(click());
        onView(withId(R.id.combustible_por_defecto)).check(matches(withSpinnerText(containsString("Gasóleo Premium"))));

        // Caso UIT.1C
        // Se comprueban que los botones aplicar y cancelar son los correctos
        onView(withText("Cancelar")).check(matches(withText("Cancelar")));

        onView(withText("Aplicar")).check(matches(withText("Aplicar")));

        // Caso UIT.1G
        // Se comprueba que al pulsar el boton Cancelar no efectua ningun cambio.
        // Se pulsa sobre la opción “Cancelar” de la ventana flotante luego de haber seleccionado un tipo de combustible del desplegable.
        onView(withText("Cancelar")).perform(click());

        // Comprobamos que el combustible establecido es el mismo que al principio, es decir, Gasoleo A
        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo A")));


        // Caso UIT.1F
        // Se comprueba que al pulsar el boton Cancelar no efectua ningun cambio.
        // Se pulsa sobre la opción “Cancelar” de la ventana flotante sin haber seleccionado ningún combustible del desplegable.
        onView(withId(R.id.btnConfiguracion)).perform(click());

        onView((withId(R.id.combustible_por_defecto))).perform(click());

        onView(withText("Cancelar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(10)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo A")));


        // Caso UIT.1E
        // Se comprueba que al pulsar el boton Aplicar no efectua ningun cambio.
        // Se pulsa sobre la opción “Aplicar” de la ventana flotante sin haber seleccionado ningún combustible del desplegable.
        onView(withId(R.id.btnConfiguracion)).perform(click());

        onView((withId(R.id.combustible_por_defecto))).perform(click());

        onView(withText("Aplicar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(15)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo A")));


        /*
         * Se comprueba establecer cada tipo de combustible y probar su correcto funcionamiento
         * pulsando sobre una gasolineras de la lista despues de que se haya refrescado correctamente.
         *
         * Excepto para el tipo de combustible Gasolina 98 en el cual se va a comporbar que todas las gasolineras
         * de la lista son del tipo de combustible establecido, es decir, gasolina 98.
         * Casos UIT.1D
         */
        /** gasoleoA_Test() **/


        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasoleo A
        onData(allOf(is(instanceOf(String.class)),
                is("Gasóleo A"))).inRoot(isPlatformPopup()).perform(click());

        // Se pulsa el botón Aceptar dentro del menú desplegable
        onView(withText("Aplicar")).perform(click());

        // Se comprueba que el tipo de combustible se ha cambiado correctamente accediendo
        // a la primera gasolinera y comprobando su textViewTipoGasolina
        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(5)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo A")));

        /** gasolina95_Test() **/

        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasolina 95
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 95"))).inRoot(isPlatformPopup()).perform(click());

        onView(withText("Aplicar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasolina 95")));

        /** gasolina98_Test() **/

        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasolina 98
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 98"))).inRoot(isPlatformPopup()).perform(click());

        onView(withText("Aplicar")).perform(click());

        for (int i=0; i<50; i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.listViewGasolineras))
                    .atPosition(i)
                    .onChildView(withId(R.id.textViewTipoGasolina))
                    .check(matches(withText("Gasolina 98")));
        }


        /** biodiésel_Test() **/

        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se selecciona el segundo tipo de combustible que se corresponde con Biodiésel
        onData(allOf(is(instanceOf(String.class)),
                is("Biodiésel"))).inRoot(isPlatformPopup()).perform(click());

        onView(withText("Aplicar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(1)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Biodiésel")));

        /**gasóleoPremium_Test() **/

        // Antes de cada test se pulsa el spinner para ver su contenido
        onView((withId(R.id.combustible_por_defecto))).perform(click());

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasóleo Premium
        onData(allOf(is(instanceOf(String.class)),
                is("Gasóleo Premium"))).inRoot(isPlatformPopup()).perform(click());

        onView(withText("Aplicar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(5)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo Premium")));

    }
}