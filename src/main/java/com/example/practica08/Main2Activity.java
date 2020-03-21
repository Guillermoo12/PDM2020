package com.example.practica08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import static com.example.practica08.R.layout.activity_main2;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setContentView(activity_main2);
        Bundle extras = getIntent().getExtras();
        String valor1 = extras.getString("Valor1");
        String valor2 = extras.getString("Valor2");

        Toast.makeText(getApplicationContext(), "Valores:\nuno: "+valor1+"\ndos: "+valor2, Toast.LENGTH_LONG).show();
        Button button1 = findViewById(R.id.btnPrimera);

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}