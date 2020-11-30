package com.isunican.proyectobase.Views;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.view.WindowManager;

import androidx.test.annotation.UiThreadTest;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.isunican.proyectobase.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.Context.KEYGUARD_SERVICE;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class PruebaUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @UiThreadTest
    @Before
    public void setUp() throws Throwable {
        final Activity activity = mActivityTestRule.getActivity();
        mActivityTestRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                KeyguardManager mKG = (KeyguardManager) activity.getSystemService(Context.KEYGUARD_SERVICE);
                KeyguardManager.KeyguardLock mLock = mKG.newKeyguardLock(KEYGUARD_SERVICE);
                mLock.disableKeyguard();

                //turn the screen on
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                        | WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
            }
        });
    }
    @Test
    public void tiposCombustible_Test() {
        onView(ViewMatchers.withId(R.id.info)).perform(click());
        onView(ViewMatchers.withText("Filtros")).perform(click());
    }
}
