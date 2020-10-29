package com.isunican.proyectobase;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Views.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class BuscarGasolinerasPorUnTipoDeCombustibleUITest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void gasoleoA_Test() {



        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //
        onView(withId(R.id.buttonFiltros)).perform(click());

        String[] arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);

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

        onView(withText(arrayOperaciones[4])).perform(click());
        onView(withText(arrayOperaciones[3])).perform(click());
        onView(withText(arrayOperaciones[2])).perform(click());
        onView(withText(arrayOperaciones[1])).perform(click());


        //onView(withText("Aceptar")).check(matches(withText("Aceptar")));
        //onView(withText("Cancelar")).check(matches(withText("Cancelar")));

        onView(withText("Aceptar")).perform(click());

        onData(withId(R.id.textViewTipoGasolina))
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .check(matches(withText("Gasóleo A")));

        /*
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ListView ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        */

    }
    /*
    @Test
    public void gasolina95_Test() {

        //
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //
        onView(withId(R.id.buttonFiltros)).perform(click());
        //
        String[] arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);

        onView(withText(arrayOperaciones[1])).perform(click());
        onView(withText(arrayOperaciones[1])).check(matches(withText("Gasolina 95")));

        onView(withText("Aceptar")).perform(click());

        onData(withId(R.id.textViewTipoGasolina))
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .check(matches(withText("Gasolina 95")));

    }

    @Test
    public void gasolina98_Test() {

        //
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //
        onView(withId(R.id.buttonFiltros)).perform(click());
        //
        String[] arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);

        onView(withText(arrayOperaciones[2])).perform(click());
        onView(withText(arrayOperaciones[2])).check(matches(withText("Gasolina 98")));

        onView(withText("Aceptar")).perform(click());

        onData(withId(R.id.textViewTipoGasolina))
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .check(matches(withText("Gasolina 98")));

    }

    @Test
    public void biodiésel_Test() {

        //
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //
        onView(withId(R.id.buttonFiltros)).perform(click());
        //
        String[] arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);

        onView(withText(arrayOperaciones[3])).perform(click());
        onView(withText(arrayOperaciones[3])).check(matches(withText("Biodiésel")));

        onView(withText("Aceptar")).perform(click());

        onData(withId(R.id.textViewTipoGasolina))
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .check(matches(withText("Biodiésel")));

    }

    @Test
    public void gasóleoPremium_Test() {

        //
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //
        onView(withId(R.id.buttonFiltros)).perform(click());
        //
        String[] arrayOperaciones = appContext.getResources().getStringArray(R.array.operacionesArray);

        onView(withText(arrayOperaciones[4])).perform(click());
        onView(withText(arrayOperaciones[4])).check(matches(withText("Gasóleo Premium")));

        onView(withText("Aceptar")).perform(click());

        onData(withId(R.id.textViewTipoGasolina))
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .check(matches(withText("Gasóleo Premium")));

    }
    */
}
