package com.isunican.proyectobase;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.isunican.proyectobase.Views.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;


@RunWith(AndroidJUnit4.class)
public class BuscarGasolinerasPorUnTipoDeCombustibleUITest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    String[] arrayOperaciones;

    @Before
    public void preparacionTest() {

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // Se pulsa el boton para acceder a los Filtros.
        onView(withId(R.id.buttonFiltros)).perform(click());

        // Se guarda en un array los tipos de combustible que existen.
        arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);
    }

    @Test
    public void tiposCombustible_Test() {

        // Se comprueba seleccionando todos los tipos existentes y se comprueba su correspondiente nombre
        onView(withText(arrayOperaciones[0])).perform(click());
        onView(withText(arrayOperaciones[0])).check(matches(withText("Gasóleo A")));

        onView(withText(arrayOperaciones[1])).perform(click());
        onView(withText(arrayOperaciones[1])).check(matches(withText("Gasolina 95")));

        onView(withText(arrayOperaciones[2])).perform(click());
        onView(withText(arrayOperaciones[2])).check(matches(withText("Gasolina 98")));

        onView(withText(arrayOperaciones[3])).perform(click());
        onView(withText(arrayOperaciones[3])).check(matches(withText("Biodiésel")));

        onView(withText(arrayOperaciones[4])).perform(click());
        onView(withText(arrayOperaciones[4])).check(matches(withText("Gasóleo Premium")));

        // Se deseleccionan todos los tipos de combustible existentes
        onView(withText(arrayOperaciones[4])).perform(click());
        onView(withText(arrayOperaciones[3])).perform(click());
        onView(withText(arrayOperaciones[2])).perform(click());
        onView(withText(arrayOperaciones[1])).perform(click());
        onView(withText(arrayOperaciones[0])).perform(click());

    }

    @Test
    public void gasoleoA_Test() {

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasolina 95
        onView(withText(arrayOperaciones[0])).perform(click());

        // Se pulsa el botón Aceptar dentro del menú desplegable
        onView(withText("Aceptar")).perform(click());

        // Se comprueba que el tipo de combustible se ha cambiado correctamente accediendo
        // a la primera gasolinera y comprobando su textViewTipoGasolina
        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo A")));

    }

    @Test
    public void gasolina95_Test() {

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasolina 95
        onView(withText(arrayOperaciones[1])).perform(click());

        onView(withText("Aceptar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasolina 95")));

    }

    @Test
    public void gasolina98_Test() {

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasolina 98
        onView(withText(arrayOperaciones[2])).perform(click());

        onView(withText("Aceptar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasolina 98")));

    }

    @Test
    public void biodiésel_Test() {

        // Se selecciona el segundo tipo de combustible que se corresponde con Biodiésel
        onView(withText(arrayOperaciones[3])).perform(click());

        onView(withText("Aceptar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Biodiésel")));

    }

    @Test
    public void gasóleoPremium_Test() {

        // Se selecciona el segundo tipo de combustible que se corresponde con Gasóleo Premium
        onView(withText(arrayOperaciones[4])).perform(click());

        onView(withText("Aceptar")).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewTipoGasolina))
                .check(matches(withText("Gasóleo Premium")));

    }

}
