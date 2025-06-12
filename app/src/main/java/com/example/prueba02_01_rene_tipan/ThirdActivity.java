package com.example.prueba02_01_rene_tipan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    EditText rstn_nombre, rstn_apellido, rstn_dividendo, rstn_divisor, rstn_numero;
    Button rstn_btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rstn_nombre = findViewById(R.id.rstn_nombre);
        rstn_apellido = findViewById(R.id.rstn_apellido);
        rstn_dividendo = findViewById(R.id.rstn_dividendo);
        rstn_divisor = findViewById(R.id.rstn_divisor);
        rstn_numero = findViewById(R.id.rstn_numero);
        rstn_btnCerrar = findViewById(R.id.rstn_btn_cerrar_3);

        rstn_nombre.setEnabled(false);
        rstn_apellido.setEnabled(false);
        rstn_btnCerrar.setBackgroundColor(Color.parseColor("#FFFF00"));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            rstn_nombre.setText(extras.getString("rstn_nombre", ""));
            rstn_apellido.setText(extras.getString("rstn_apellido", ""));
            rstn_dividendo.setText(String.valueOf(extras.getInt("rstn_dividendo", 0)));
            rstn_divisor.setText(String.valueOf(extras.getInt("rstn_divisor", 1)));
            rstn_numero.setText(String.valueOf(extras.getInt("rstn_numero", 0)));
        }

        rstn_btnCerrar.setOnClickListener(v -> {
            Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
            i.putExtra("rstn_nombre", rstn_nombre.getText().toString());
            i.putExtra("rstn_apellido", rstn_apellido.getText().toString());
            i.putExtra("rstn_dividendo", Integer.parseInt(rstn_dividendo.getText().toString().isEmpty() ? "0" : rstn_dividendo.getText().toString()));
            i.putExtra("rstn_divisor", Integer.parseInt(rstn_divisor.getText().toString().isEmpty() ? "1" : rstn_divisor.getText().toString()));
            i.putExtra("rstn_numero", Integer.parseInt(rstn_numero.getText().toString().isEmpty() ? "0" : rstn_numero.getText().toString()));
            startActivity(i);
            finish();
        });
    }
}
