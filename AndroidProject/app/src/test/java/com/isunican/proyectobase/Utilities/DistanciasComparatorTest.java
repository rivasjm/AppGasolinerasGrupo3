package com.isunican.proyectobase.Utilities;


import android.os.Build;

import com.isunican.proyectobase.Model.Gasolinera;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class DistanciasComparatorTest {
    @Before
    public  void setUp(){


Gasolinera g1 = new Gasolinera(1,"","0","",3.2,3,3,3,3,"",10,25);
Gasolinera g2 = new Gasolinera(2,"","0","",3.2,3,3,3,3,"",43,-4);

    }
    @Test
    public void compareTest(){

            }
}
