package com.isunican.proyectobase;

import android.content.Context;
import android.view.Gravity;

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
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
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
    public void establecerTipoCombustibleTest() {

        onView(withId(R.id.navigationDrawerButton)).perform(click());

        onView(withId(R.id.buttonConfigurar)).check(matches(withText("Configuración")));

        onView(withId(R.layout.nav_drawer_layout)).check(matches(isDisplayed()));

        onView(withId(R.id.buttonConfigurar)).perform(click());

        /*
        Thread.sleep(2000);

        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_slideshow));
        Thread.sleep(1000);

        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_send));
        Thread.sleep(1000);

        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_gallery));
        Thread.sleep(1000);



        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getContext());
        onView(withText("Filtrar por Semana Actual")).perform(click());


        // Check drawer
        is closed
        onView(withId(R.layout.nav_drawer_layout)).check(matches(isClosed(Gravity.START)));

        // Click drawer icon
        onView(
                withContentDescription(
                        scenario.getToolbarNavigationContentDescriptor()
                )
        ).perform(click());

        // Check if drawer is open
        onView(withId(R.id.drawer_layout)).check(matches(isOpen(Gravity.START)));

        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.your_navigation_menu_item));

        // Check that you Activity was opened.
        String expectedNoStatisticsText = InstrumentationRegistry.getTargetContext()
                .getString(R.string.no_item_available);
        onView(withId(R.id.no_statistics)).check(matches(withText(expectedNoStatisticsText)));
        */

    }
}