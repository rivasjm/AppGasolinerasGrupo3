package com.isunican.proyectobase.Views;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.isunican.proyectobase.R;
import com.isunican.proyectobase.Model.*;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;


/*
------------------------------------------------------------------
    Vista de detalle

    Presenta datos de detalle de una Gasolinera concreta.
    La gasolinera a mostrar se le pasa directamente a la actividad
    en la llamada por intent (usando putExtra / getExtra)
    Para ello Gasolinera implementa la interfaz Parcelable
------------------------------------------------------------------
*/
public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageView imgG;
    TextView txtNomG;
    TextView txtPrecioGasoil;
    TextView txtPrecioGasolina;
    TextView txtDir;
    MapView mapDir;
    Gasolinera g;

    /**
     * onCreate
     * <p>
     * Crea los elementos que conforman la actividad
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // muestra el logo en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.por_defecto_mod);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                99);

        mapDir = (MapView) findViewById(R.id.mapGasolinera);
        mapDir.onCreate(savedInstanceState);
        mapDir.getMapAsync(this);


        // captura el TextView
        // obtiene el objeto Gasolinera a mostrar
        // y lo introduce en el TextView convertido a cadena de texto
        imgG = findViewById(R.id.imgGasolinera);
        txtNomG = findViewById(R.id.txtNomGasolinera);
        txtPrecioGasoil = findViewById(R.id.txtPrecioGasoil);
        txtPrecioGasolina = findViewById(R.id.txtPrecioGasolina);
        txtDir = findViewById(R.id.txtDireccion);
        g = getIntent().getExtras().getParcelable(getResources().getString(R.string.pasoDatosGasolinera));

        txtNomG.setText(g.getRotulo());
        txtPrecioGasoil.setText("Diesel " + g.getGasoleoA() + "€");
        txtPrecioGasolina.setText("Gasolina " + g.getGasolina95() + "€");
        txtDir.setText(g.getDireccion());

        String rotuleImageID = g.getRotulo().toLowerCase();

        // Tengo que protegerme ante el caso en el que el rotulo solo tiene digitos.
        // En ese caso getIdentifier devuelve esos digitos en vez de 0.
        int imageID = this.getResources().getIdentifier(rotuleImageID,
                "drawable", this.getPackageName());

        if (imageID == 0 || TextUtils.isDigitsOnly(rotuleImageID)) {
            imageID = this.getResources().getIdentifier(getResources().getString(R.string.pordefecto),
                    "drawable", this.getPackageName());
        }
        imgG.setImageResource(imageID);

    }

    @Override
    public void onResume() {
        super.onResume();
        mapDir.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mapDir.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapDir.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }


    @Override
    public void onPause() {
        mapDir.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapDir.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapDir.onLowMemory();
    }

    /*
    public void onRequestPermissionsResults(int requestCode, String[] permissions,
                                            int[] grantResults) {
        switch (requestCode) {
            case 99:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                }  //else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
               // }
                return;
    }*/
}

