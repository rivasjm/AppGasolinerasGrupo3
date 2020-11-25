package com.isunican.proyectobase.Utilities;

import android.location.Location;

public class CalculaDistancia {
    public static double distanciaEntreDosCoordenadas(double latitudX, double longitudX, double latitudY, double longitudY){
        double resul = 0.0;
        Location locX = new Location("");
        locX.setLatitude(latitudX);
        locX.setLongitude(longitudX);

        Location locY = new Location("");
        locY.setLatitude(latitudY);
        locY.setLongitude(longitudY);

        resul = locX.distanceTo(locY);

        return resul;
    }
}
