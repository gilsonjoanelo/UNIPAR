package com.example.armobile.ui.home;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.armobile.BuildConfig;
import com.example.armobile.R;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragment extends Fragment implements LocationListener {

    public static final int LOCATION_UPDATE_MIN_DISTANCIA = 10;
    public static final int LOCATION_UPDATE_MIN_TEMPO = 5000;

    private GoogleMap map;
    private LocationManager locationManager;
    private SupportMapFragment mapFragment;
    private boolean isGPSEnabled;
    private AlertDialog.Builder builder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(v -> exibirPesquisaEndereco());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {

                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getActivity(), "Para utilizar este aplicativo, requer liberar acesso ao GPS", Toast.LENGTH_LONG).show();
                    } else {
                        map = googleMap;
                        map.setMyLocationEnabled(true);
                        map.getUiSettings().setMyLocationButtonEnabled(true);
                        map.getUiSettings().setAllGesturesEnabled(true);
                        recuperarLocalizacaoAtual();
                    }
                }
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //recuperarLocalizacaoAtual();
    }

    @Override
    public void onResume() {
        super.onResume();
        recuperarLocalizacaoAtual();
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(location != null){
            adicionarMarcador(location);
            locationManager.removeUpdates(this);
        } else {
            Log.d(BuildConfig.APPLICATION_ID, "Localização não encontrada");
        }
    }

    private void recuperarLocalizacaoAtual() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "Para utilizar este aplicativo, requer liberar acesso ao GPS", Toast.LENGTH_LONG).show();
        } else {
            Log.d(BuildConfig.APPLICATION_ID, "recuperarLocalizacaoAtual");
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            Location location = null;
            if (!isGPSEnabled || !isNetworkEnabled) {
                Toast.makeText(getActivity(), "Para utilizar este aplicativo, requer liberar acesso ao GPS", Toast.LENGTH_LONG).show();
            } else {
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                            LOCATION_UPDATE_MIN_TEMPO, LOCATION_UPDATE_MIN_DISTANCIA, this);
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }

                if(isGPSEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                            LOCATION_UPDATE_MIN_TEMPO, LOCATION_UPDATE_MIN_DISTANCIA, this);
                    location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                }
            }
            if(location != null) {
                adicionarMarcador(location);
            }
        }
    }

    private void adicionarMarcador(Location location) {
        if(map != null) {
            map.clear();
            LatLng latitude = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions options = new MarkerOptions()
                    .position(latitude)
                    .title("Meu local");
            map.addMarker(options);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latitude, 12));
        }
    }

    private void exibirPesquisaEndereco(){
        if(builder == null){
            builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Informe o endereço desejado");
            View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.pesquisar_endereco, (ViewGroup) getView(), false);
            final TextInputEditText input = viewInflated.findViewById(R.id.inputPesquisaEndereco);
            builder.setView(viewInflated);

            builder.setPositiveButton(android.R.string.ok, (dialog, which) -> {
                dialog.dismiss();
                //m_Text = input.getText().toString();
            });
            builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.cancel());
        }
        builder.show();
    }
}