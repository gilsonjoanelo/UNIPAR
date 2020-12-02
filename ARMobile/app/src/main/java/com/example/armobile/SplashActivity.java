package com.example.armobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private final int PERMISSION_ALL_INTENT = 5;
    private boolean retornoResult;

    private final String[] permissions = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean liberado = true;
        if (!retornoResult) {
            if (!hasPermissions(this, permissions)) {
                liberado = false;
                ActivityCompat.requestPermissions(this, permissions, PERMISSION_ALL_INTENT);
            }
        }

        if (liberado) {
            iniciarApp();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSION_ALL_INTENT) {
            retornoResult = true;
            iniciarApp();
        }
    }

    private static boolean hasPermissions(AppCompatActivity context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.shouldShowRequestPermissionRationale(context, permission);
                    return false;
                }
            }
        }
        return true;
    }

    private void iniciarApp(){
        iniciarAnimacao();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mostrarMainActivity();
            }
        }, 3000);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void iniciarAnimacao() {
        ProgressBar mProgressBar = findViewById(R.id.progressBar);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
        progressAnimator.setDuration(2000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }
}