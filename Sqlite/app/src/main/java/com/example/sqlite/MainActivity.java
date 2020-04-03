package com.example.sqlite;

import android.os.Bundle;

import java.util.List;

import com.example.sqlite.MySQLiteHelper;
import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MySQLiteHelper db = new MySQLiteHelper(this);


        db.addDatos(new DatosEMP("aaa", "aaa"));
        db.addDatos(new DatosEMP("bbb", "ccc"));
        db.addDatos(new DatosEMP("ddd", "eee"));


        List<DatosEMP> list = db.getAllDatos();


        db.deleteDatos(list.get(0));


        db.getAllDatos();


    }

}

