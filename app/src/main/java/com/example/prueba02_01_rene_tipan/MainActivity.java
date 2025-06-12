package com.example.prueba02_01_rene_tipan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText rstn_nombre, rstn_apellido, rstn_dividendo, rstn_divisor, rstn_parteEntera, rstn_residuo, rstn_numInvertido;
    Button rstn_btnSiguiente, rstn_btnMostrar;
    String nombre = "", apellido = "";
    int dividendo = 0, divisor = 1, numero = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rstn_nombre = findViewById(R.id.rstn_nombre);
        rstn_apellido = findViewById(R.id.rstn_apellido);
        rstn_dividendo = findViewById(R.id.rstn_dividendo);
        rstn_divisor = findViewById(R.id.rstn_divisor);
        rstn_parteEntera = findViewById(R.id.rstn_parte_entera);
        rstn_residuo = findViewById(R.id.rstn_residuo);
        rstn_numInvertido = findViewById(R.id.rstn_invertido);
        rstn_btnSiguiente = findViewById(R.id.rstn_btn_siguiente_1);
        rstn_btnMostrar = findViewById(R.id.rstn_btn_resultados);

        rstn_btnMostrar.setEnabled(false);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombre = extras.getString("rstn_nombre", "");
            apellido = extras.getString("rstn_apellido", "");
            dividendo = extras.getInt("rstn_dividendo", 0);
            divisor = extras.getInt("rstn_divisor", 0);
            numero = extras.getInt("rstn_numero", 0);

            rstn_nombre.setText(nombre);
            rstn_apellido.setText(apellido);
            rstn_dividendo.setText(String.valueOf(dividendo));
            rstn_divisor.setText(String.valueOf(divisor));

            rstn_btnMostrar.setEnabled(true);
            rstn_btnMostrar.setBackgroundColor(Color.parseColor("#008000"));
        }

        rstn_btnSiguiente.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("rstn_nombre", rstn_nombre.getText().toString());
            i.putExtra("rstn_apellido", rstn_apellido.getText().toString());
            i.putExtra("rstn_dividendo", Integer.parseInt(rstn_dividendo.getText().toString().isEmpty() ? "0" : rstn_dividendo.getText().toString()));
            i.putExtra("rstn_divisor", Integer.parseInt(rstn_divisor.getText().toString().isEmpty() ? "0" : rstn_divisor.getText().toString()));
            i.putExtra("rstn_numero", numero);
            startActivity(i);
        });

        rstn_btnMostrar.setOnClickListener(v -> {

            rstn_parteEntera.setText(String.valueOf(calcularParteEntera(dividendo, divisor)));
            rstn_residuo.setText(String.valueOf(calcularResiduo(dividendo, divisor)));
            rstn_numInvertido.setText(calcularInvertido(numero));
        });
    }

    public int calcularParteEntera(int dividendo, int divisor) {
        int contador = 0;
        int suma = divisor;

        while (suma <= dividendo) {
            suma += divisor;
            contador++;
        }
        return contador;
    }

    public int calcularResiduo(int dividendo, int divisor) {
        int suma = divisor;

        while (suma <= dividendo) {
            suma += divisor;
        }

        int residuo = dividendo - (suma - divisor);
        return residuo;
    }

    public String calcularInvertido(int numero) {
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero = numero / 10;
        }

        return String.valueOf(invertido);
    }

}

