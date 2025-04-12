package xd_pakc;

import java.util.ArrayList;

public class ActividadSismica {
    float[] horas = new float[24];
    int day;
    String mes;
    String localidad;

    public ActividadSismica(int day, String mes, String localidad) {
        this.day = day;
        this.mes = mes;
        this.localidad = localidad;
        for (int i = 0; i < 24; ++i) horas[i] = 0.0f;
    }
    public ActividadSismica() {
        this(0, null, null);
        for (int i = 0; i < 24; ++i) horas[i] = 0.0f;
    }

    public void setHoras(int hora, float val) {
        this.horas[hora] = val;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public float getHoras(int x) {
        return horas[x];
    }

    public int getDay() {
        return day;
    }

    public String getMes() {
        return mes;
    }

    public String getLocalidad() {
        return localidad;
    }
    public String getDatos() {
        String tabla = "";
        for (int i = 0; i < 24; i++) {
             tabla += "\nHora " + String.format("%02d", i) + ": " + getHoras(i);
        }
        return "Localidad: " + getLocalidad() +
                "\nMes: " + getMes() +
                "\nDia: " + getDay()  +
                tabla;


    }
}
