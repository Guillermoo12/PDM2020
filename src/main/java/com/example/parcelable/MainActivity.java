package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public cPersona usuario=new cPersona();
    String nombre;
    String email;
    int edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String edades[]={"10","20","30","40","50","60","70","80","90","100"};
        Button btnEnviar=(Button)findViewById(R.id.btnEnviar);
        Button btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        final EditText edtNombre=(EditText)findViewById(R.id.edtNombre);
        final EditText edtEmail=(EditText)findViewById(R.id.edtEmail);
        final Spinner spnEdad=(Spinner)findViewById(R.id.spnEdad);
        final TextView txtResultado=(TextView)findViewById(R.id.txtResultado);
        spnEdad.setAdapter(new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,edades));
        spnEdad.setOnItemSelectedListener(new
                                                  AdapterView.OnItemSelectedListener() {
                                                      @Override
                                                      public void onItemSelected(AdapterView<?> parent, View view, int
                                                              position , long id) {
                                                          edad=Integer.parseInt(parent.getItemAtPosition(position).toString());
                                                      }
                                                      @Override
                                                      public void onNothingSelected(AdapterView<?> parent) {
                                                      }
                                                  });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=edtNombre.getText().toString();
                email=edtEmail.getText().toString();
                usuario.setEdad(edad);
                usuario.setMail(email);
                usuario.setNombre(nombre);
                txtResultado.setText(usuario.getDatos());
                Intent intent = new Intent(MainActivity.this,
                        Main2Activity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtEmail.setText("");
                edtNombre.setText("");
                edad=0;
                nombre="";
                email="";
                edtNombre.requestFocus();
            }
        });
    }
}
