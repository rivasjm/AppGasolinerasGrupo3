package com.isunican.proyectobase;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.test.espresso.ViewAssertion;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Views.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class OrdenarGasolinerasPorPrecioUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private ListView ltmp;
    private Gasolinera gBarata;
    private Gasolinera gCara;

    @Before
    public void setUp() {
        //clickamos en la opcion de ordenar gasolineras
        onView(withId(R.id.buttonOrden)).perform(click());

        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        gBarata = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        int lng = ltmp.getAdapter().getCount();
        gCara = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(lng - 1);



    }

    @Test
    public void ordenPorPrecio() {

        onView(withId(R.id.buttonprecio)).check(matches(withText("Precio (asc)")));

        Gasolinera tmp1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        assertTrue(tmp1.getGasoleoA() > gBarata.getGasoleoA());
        Gasolinera tmp2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
        assertTrue(tmp2.getGasoleoA() > tmp1.getGasoleoA());


        onView(withId(R.id.buttonprecio)).perform(click());
        onView(withId(R.id.buttonprecio)).check(matches(withText("Precio (des)")));

         tmp1 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(1);
        assertTrue(tmp1.getGasoleoA() < gCara.getGasoleoA());
         tmp2 = ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(2);
       // assertTrue(tmp2.getGasoleoA() < tmp1.getGasoleoA());

        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewGasoleoA))
                .check(matches(withText(gCara.getGasoleoA()+ "€")));


        onView(withId(R.id.buttonprecio)).perform(click());
        onView(withId(R.id.buttonprecio)).check(matches(withText("Precio (asc)")));
        onData(anything())
                .inAdapterView(withId(R.id.listViewGasolineras))
                .atPosition(0)
                .onChildView(withId(R.id.textViewGasoleoA))
                .check(matches(withText(gBarata.getGasoleoA() + "€")));

    }
}
