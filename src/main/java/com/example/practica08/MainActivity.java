package com.example.practica08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btnPrimera);

        button1.setOnClickListener(new OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("Valor1", "Android");
                i.putExtra("Valor2", "Fácil");
                startActivity(i);
            }
        });
    }
}