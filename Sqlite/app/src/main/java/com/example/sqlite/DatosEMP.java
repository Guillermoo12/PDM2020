package com.example.sqlite;

public class DatosEMP {
    private int id;
    private String Nombre;
    private String Cargo;
    private String Correo;

    public DatosEMP(){}

    public DatosEMP(String Nombre, String Cargo, String Correo) {
        super();
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Correo = Correo;
    }

    public DatosEMP(String ddd, String eee) {
    }

    public static void add(DatosEMP datos) {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getCargo() {
        return Cargo;
    }
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    @Override
    public String toString() {
        return "Datos[id=" + id + ", Nombre=" + Nombre + ", Cargo=" + Cargo +",Correo=" +Correo
                + "]";
    }


}

