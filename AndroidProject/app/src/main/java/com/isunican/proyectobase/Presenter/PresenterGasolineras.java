package com.isunican.proyectobase.Presenter;

import android.util.Log;

import com.isunican.proyectobase.Model.*;
import com.isunican.proyectobase.Utilities.ParserJSONGasolineras;
import com.isunican.proyectobase.Utilities.RemoteFetch;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

/*
------------------------------------------------------------------
    Clase presenter con la logica de gasolineras
    Mantiene un objeto ListaGasolineras que es el que mantendrá
    los datos de las gasolineras cargadas en nuestra aplicación
    Incluye métodos para gestionar la lista de gasolineras y
    cargar datos en ella.
------------------------------------------------------------------
*/
public class PresenterGasolineras {

    private List<Gasolinera> gasolineras;

    //URLs para obtener datos de las gasolineras
    //https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/help
    public static final String URL_GASOLINERAS_SPAIN="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/";
    public static final String URL_GASOLINERAS_CANTABRIA="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroCCAA/06";
    public static final String URL_GASOLINERAS_SANTANDER="https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipio/5819";
    public static final String SANTANDER="Santander";

    /**
     * Constructor, getters y setters
     */
    public PresenterGasolineras(){
        gasolineras = new ArrayList<>();
    }

    public List<Gasolinera> getGasolineras(){
        return gasolineras;
    }

    public void setGasolineras(List<Gasolinera> l) {
        this.gasolineras = l;
    }


    /**
     * cargaDatosGasolineras
     *
     * Carga los datos de las gasolineras en la lista de gasolineras de la clase.
     * Para ello llama a métodos de carga de datos internos de la clase ListaGasolineras.
     * En este caso realiza una carga de datos remotos dada una URL
     *
     * Habría que mejorar el método para que permita pasar un parámetro
     * con los datos a cargar (id de la ciudad, comunidad autónoma, etc.)
     *
     * @param
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosGasolineras() {
        return cargaDatosRemotos(URL_GASOLINERAS_CANTABRIA);
    }

    /**
     * cargaDatosDummy
     *
     * Carga en la lista de gasolineras varias gasolineras definidas a "mano"
     * para hacer pruebas de funcionamiento
     *
     * @param
     * @return boolean
     */
    public boolean cargaDatosDummy(){
        this.gasolineras.add(new Gasolinera(1000,SANTANDER,SANTANDER, "Av Valdecilla", 1.299,1.359, 1.3,1.2,2,"AVIA"));
        this.gasolineras.add(new Gasolinera(1053,SANTANDER,SANTANDER, "Plaza Matias Montero", 1.270,1.349,1.22,1.11,1.21,"CAMPSA"));
        this.gasolineras.add(new Gasolinera(420,SANTANDER,SANTANDER, "Area Arrabal Puerto de Raos", 1.249,1.279,1.3,1.2,1.5,"E.E.S.S. MAS, S.L."));
        this.gasolineras.add(new Gasolinera(9564,SANTANDER,SANTANDER, "Av Parayas", 1.189,1.269,1.11,1.28,1.25,"EASYGAS"));
        this.gasolineras.add(new Gasolinera(1025,SANTANDER,SANTANDER, "Calle el Empalme", 1.259,1.319,1.65,1.27,1.01,"CARREFOUR"));
        return true;
    }

    /**
     * cargaDatosLocales
     *
     * A partir de la dirección de un fichero JSON pasado como parámetro:
     * Parsea la información para obtener una lista de gasolineras.
     * Finalmente, dicha lista queda almacenada en la clase.
     *
     * @param String Nombre del fichero
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosLocales(String fichero){
        return(fichero != null);
    }

    /**
     * cargaDatosRemotos
     *
     * A partir de la dirección pasada como parámetro:
     * Utiliza RemoteFetch para cargar el fichero JSON ubicado en dicha URL
     * en un stream de datos.
     * Luego utiliza ParserJSONGasolineras para parsear dicho stream
     * y extraer una lista de gasolineras.
     * Finalmente, dicha lista queda almacenada en la clase.
     *
     * @param String Dirección URL del JSON con los datos
     * @return boolean Devuelve true si se han podido cargar los datos
     */
    public boolean cargaDatosRemotos(String direccion){
        try {
            BufferedInputStream buffer = RemoteFetch.cargaBufferDesdeURL(direccion);
            gasolineras = ParserJSONGasolineras.parseaArrayGasolineras(buffer);
            Log.d("ENTRA", "Obten gasolineras:" + gasolineras.size());
            return true;
        } catch (Exception e) {
            Log.e("ERROR", "Error en la obtención de gasolineras: " + e.getMessage());
            return false;
        }
    }


    /**
     * Elimina las gasolinera si el precio el combustible indicado es negativo
     * @param combustible combustible por el cual se esta filtrando
     */
    public void eliminaGasolinerasConPrecioNegativo(String combustible){
        int i=0;
        while(i < gasolineras.size()){
            Gasolinera g = gasolineras.get(i);
            //se calcula el precio del combustible en cuetion
            double precio = getPrecioCombustible(combustible, g);
            //si el precio del combustible es negativo la gasolinera se borra de la lista
            if(precio < 0) {
                gasolineras.remove(g);
                i--;
            }
            i++;
        }
    }

    /**
     * Develve el precio del combustible de la gasolinera indicada segun el combustible indicado
     * @param combustible combustible del que se desao conocer el precio
     * @param g gasolinera de la que se desea conocer el precio
     * @return el precio del combustible de la gasolinera indicada segun el combustible indicado
     */
    public double getPrecioCombustible(String combustible, Gasolinera g){
        double precio = 0.0;
        switch(combustible) {
            case "Gasóleo A":
                precio = g.getGasoleoA();
                break;
            case "Gasolina 95":
                precio = g.getGasolina95();
                break;
            case "Gasolina 98":
                precio = g.getGasolina98();
                break;
            case "Biodiésel":
                precio = g.getBiodiesel();
                break;
            case "Gasóleo Premium":
                precio = g.getGasoleoPremium();
                break;
            default:
                break;
        }
        return precio;
    }


}
