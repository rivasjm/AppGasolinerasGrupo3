package com.isunican.proyectobase.Views;
/*
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Views.DetailActivity;
import com.isunican.proyectobase.Views.MainActivity;

import org.junit.Rule;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class US_mejorar_la_vista_detalleUITest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void gasolineraTest(){

        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ListView ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        Gasolinera g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        onView(withId(R.id.txtPrecioGasoil)).check(matches(withText("Diesel "+g.getGasoleoA()+"€")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText("Gasolina "+g.getGasolina95()+"€")));

    }
}*/
