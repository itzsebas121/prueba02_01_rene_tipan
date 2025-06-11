package com.example.prueba02_01_rene_tipan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText rstn_input;
    Button rstn_btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rstn_input = findViewById(R.id.rstn_input);
        rstn_btnEnviar = findViewById(R.id.rstn_btnEnviar);

        rstn_btnEnviar.setOnClickListener(v -> {
            String mensaje = rstn_input.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("rstn_dato", mensaje);
            startActivity(intent);
        });

    }
}
