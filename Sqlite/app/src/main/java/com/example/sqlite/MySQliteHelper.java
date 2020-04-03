package com.example.sqlite;

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "DatosEmpDB";
    private String CREATE_Datos_TABLE;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOK_TABLE = "CREATE TABLE Datos ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT, "+
                "Cargo TEXT,Correo TEXT )";
        db.execSQL(CREATE_Datos_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Datos");
        this.onCreate(db);
    }

    private static final String TABLE_Datos = "Datos";

    private static final String KEY_ID = "id";
    private static final String KEY_Nombre = "Nombre";
    private static final String KEY_Cargo = "Cargo";
    private static final String KEY_Correo = "Correo";

    private static final String[] COLUMNS = {KEY_ID,KEY_Nombre,KEY_Cargo,KEY_Correo};

    public void addDatos(DatosEMP datos){
        Log.d("addDatos", datos.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Nombre, datos.getNombre());
        values.put(KEY_Cargo, datos.getCargo());
        values.put(KEY_Correo, datos.getCorreo());
        db.insert(TABLE_Datos,null,values);
        db.close();
    }

    public DatosEMP getDatos(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =
                db.query(TABLE_Datos,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);
        if (cursor != null)
            cursor.moveToFirst();
        DatosEMP Datos = new DatosEMP();
        Datos.setId(Integer.parseInt(cursor.getString(0)));
        Datos.setId(Integer.parseInt(cursor.getString(0)));
        Datos.setNombre(cursor.getString(1));
        Datos.setCargo(cursor.getString(2));
        Datos.setCorreo(cursor.getString(3));

        Log.d("getBook("+id+")", Datos.toString());
        return Datos;
    }


    public List<DatosEMP> getAllDatos() {
        String query = "SELECT  * FROM " + TABLE_Datos;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        DatosEMP Datos = null;
        if (cursor.moveToFirst()) {
            do {
                Datos = new DatosEMP();
                Datos.setId(Integer.parseInt(cursor.getString(0)));
                Datos.setNombre(cursor.getString(1));
                Datos.setCargo(cursor.getString(2));
                Datos.setCorreo(cursor.getString(3));


                DatosEMP.add(Datos);
            } while (cursor.moveToNext());
        }
        Log.d("getAllDatos()", Datos.toString());
        return (List<DatosEMP>) Datos;
    }


    public int updateDatos(DatosEMP Datos) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", Datos.getNombre());
        values.put("Cargo", Datos.getCargo());
        values.put("Correo", Datos.getCorreo());

        int i = db.update(TABLE_Datos,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(Datos.getId()) });
        db.close();
        return i;

    }

    public void deleteDatos(DatosEMP Datos) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Datos,
                KEY_ID+" = ?",
                new String[] { String.valueOf(Datos.getId()) });
        db.close();
        Log.d("deleteDatos", Datos.toString());
    }




}
