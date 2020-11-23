package com.example.armobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SobreActivity extends AppCompatActivity {

    SwitchCompat item1;
    SwitchCompat item2;
    SwitchCompat item3;
    SwitchCompat item4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        item1 = findViewById(R.id.switchItem1);
        item2 = findViewById(R.id.switchItem2);
        item3 = findViewById(R.id.switchItem3);
        item4 = findViewById(R.id.switchItem4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadConfig();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveConfig();
    }

    public void voltarClick(View view){
        finish();
    }

    private void loadConfig(){
        SharedPreferences share = this.getPrefs();
        item1.setChecked(share.getBoolean("SW_Item1", false));
        item2.setChecked(share.getBoolean("SW_Item2", false));
        item3.setChecked(share.getBoolean("SW_Item3", false));

        Bundle extras= getIntent().getExtras();
        item4.setChecked(extras.getBoolean("TrocaDados"));
        item4.setEnabled(false);

        Toast.makeText(this, "A opção \"Troca de dados entre activities\", sempre iniciará ativada. Condição implícita", Toast.LENGTH_LONG).show();
    }

    private void saveConfig(){
        SharedPreferences share = this.getPrefs();
        SharedPreferences.Editor editor = share.edit();
        editor.putBoolean("SW_Item1", item1.isChecked());
        editor.putBoolean("SW_Item2", item2.isChecked());
        editor.putBoolean("SW_Item3", item3.isChecked());
        editor.commit();
    }

    private SharedPreferences getPrefs() {
        SharedPreferences share = this.getSharedPreferences("SobreConfig", this.MODE_PRIVATE);
        return share;
    }
}