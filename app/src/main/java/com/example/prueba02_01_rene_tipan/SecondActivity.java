package com.example.prueba02_01_rene_tipan;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView rstn_textoRecibido;
    Button rstn_btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rstn_textoRecibido = findViewById(R.id.rstn_textoRecibido);
        rstn_btnVolver = findViewById(R.id.rstn_btnVolver);

        String recibido = getIntent().getStringExtra("rstn_dato");
        rstn_textoRecibido.setText("Recibido: " + recibido);

        rstn_btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


    }
}