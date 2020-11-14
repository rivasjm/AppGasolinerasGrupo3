package com.isunican.proyectobase;

import android.Manifest;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onIdle;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.pressBackUnconditionally;
import static androidx.test.espresso.action.ViewActions.pressMenuKey;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
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
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Test
    public void gasolineraTest(){

//      ENTRANDO A LA VISTA
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ListView ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        Gasolinera g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);



//comprobando datos de una gasolinera con gasoleo A
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtTipoGasolina)).check(matches(withText("Gasóleo A")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText(g.getGasoleoA()+"€")));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        pressBack();
        //comprobando datos de una gasolinera con gasolina 95

        onView(withId(R.id.buttonFiltros)).perform(click());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 95"))).inRoot(isPlatformPopup()).perform(click());
            onView(withText("Aceptar")).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
         g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtTipoGasolina)).check(matches(withText("Gasolina 95")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText(g.getGasolina95()+"€")));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        pressBack();

        //comprobando datos de una gasolinera con gasolina 98
        onView(withId(R.id.buttonFiltros)).perform(click());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasolina 98"))).inRoot(isPlatformPopup()).perform(click());
        onView(withText("Aceptar")).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtTipoGasolina)).check(matches(withText("Gasolina 98")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText(g.getGasolina98()+"€")));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        pressBack();
        //comprobando datos de una gasolinera con biodiesel
        onView(withId(R.id.buttonFiltros)).perform(click());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Biodiésel"))).inRoot(isPlatformPopup()).perform(click());
        onView(withText("Aceptar")).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtTipoGasolina)).check(matches(withText("Biodiésel")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText(g.getBiodiesel()+"€")));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        pressBack();
        //comprobando datos de una gasolinera con premium
        onView(withId(R.id.buttonFiltros)).perform(click());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is("Gasóleo Premium"))).inRoot(isPlatformPopup()).perform(click());
        onView(withText("Aceptar")).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewGasolineras)).atPosition(0).perform(click());
        ltmp = mActivityTestRule.getActivity().findViewById(R.id.listViewGasolineras);
        g=  ((ArrayAdapter<Gasolinera>) ltmp.getAdapter()).getItem(0);
        onView(withId(R.id.txtNomGasolinera)).check(matches(withText(g.getRotulo())));
        onView(withId(R.id.txtTipoGasolina)).check(matches(withText("Gasóleo Premium")));
        onView(withId(R.id.txtPrecioGasolina)).check(matches(withText(g.getGasoleoPremium()+"€")));
        onView(withId(R.id.txtDireccion)).check(matches(withText(g.getDireccion())));
        pressBack();

    }
}
