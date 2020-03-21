package com.example.practica02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
        CheckBox pizza,cafe,hamb;
        Button btnOrden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {
        pizza=(CheckBox)findViewById(R.id.checkbox1);
        cafe=(CheckBox)findViewById(R.id.checkbox2);
        hamb=(CheckBox)findViewById(R.id.checkbox3);
        btnOrden=(Button) findViewById(R.id.button1);

        btnOrden.setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;
                StringBuilder result=new StringBuilder();
                result.append("Productos Seleccionados:");
                if(pizza.isChecked()){
                    result.append("\nPizza $50");
                    total +=50;
                }
                if(cafe.isChecked()){
                    result.append("\nCafe $25");
                    total +=25;
                }
                if(hamb.isChecked()){
                    result.append("\nHamburguesa $45");
                    total +=45;
                }
                result.append("\nTotal: "+total+" pesos");
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        }));
    }

}
