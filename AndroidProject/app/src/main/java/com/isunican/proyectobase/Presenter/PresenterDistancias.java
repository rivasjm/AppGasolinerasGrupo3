package com.isunican.proyectobase.Presenter;

import com.isunican.proyectobase.Model.Gasolinera;
import com.isunican.proyectobase.Utilities.CalculaDistancia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PresenterDistancias {
    private Map<Integer, Double> distancias = new HashMap<Integer, Double>();

    /**
     *
     * @param gasolineras
     * @param latidud
     * @param longitud
     */
    public void cargaDistancias(List<Gasolinera> gasolineras, double latidud, double longitud){
        for (Gasolinera g : gasolineras) {
            double distancia = CalculaDistancia.distanciaEntreDosCoordenadas(g.getLatitud(),
                    g.getLongitud(), latidud, longitud) ;

            this.distancias.put(g.getIdeess(), distancia);
        }
    }

    /**
     *
     * @param gasolineraId
     * @return
     */
    public double getDistancia(int gasolineraId){
        double distanciakm = Math.round(distancias.get(gasolineraId));
        return distanciakm;
    }
}
