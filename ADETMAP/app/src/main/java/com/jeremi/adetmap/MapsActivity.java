package com.jeremi.adetmap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        LatLng sydney = new LatLng(-34, 151);
        LatLng urdaneta = new LatLng(15.9758, 120.5707);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(urdaneta).title("Marker in Urdaneta City"));

        mMap.addPolyline(new PolylineOptions()
        .add(new LatLng(-37.81319,144.96298),
                new LatLng(-31.95285, 115.85734),
                new LatLng(-34, 151),
                new LatLng(-27,129))
        .width(10)
        .color(Color.BLUE));


        mMap.addPolygon( new PolygonOptions()
        .add(new LatLng(15.9758, 120.5707),
                new LatLng(15.9061, 120.5853),
                new LatLng(16.0044, 120.6545),
                new LatLng(15.9758, 120.5707))
        .strokeColor(Color.BLACK)
        .fillColor(Color.GREEN));

        mMap.addCircle(new CircleOptions()
        .center(urdaneta)
        .radius(10000)
        .strokeWidth(5)
        .strokeColor(Color.RED)
        .fillColor(Color.BLUE));

        //if you want to see the difference, remove the forward slash below before running
//        CameraPosition cameraPosition= new CameraPosition.Builder()
//                .target(urdaneta)
//                .zoom(17)
//                .bearing(90)
//                .tilt(40)
//                .build();
//
//        mMap.animateCamera(CameraUpdateFactory. newCameraPosition(cameraPosition));

    }
}