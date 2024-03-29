package com.danicc.guessnumber.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
//todo Internacionalizacion de la app
/**
 * Clase modelo que contiene el nombre del usuario y el numero de intentos que utilizara para jugar
 * @author Dani Casado
 * @version 1.0
 */
public class Juego implements Serializable, Parcelable {
    String nombre;
    int numeroIntentos;

    public Juego(String nombre, int numeroIntentos) {
        this.nombre = nombre;
        this.numeroIntentos = numeroIntentos;
    }

    public Juego() {
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", numeroIntentos=" + numeroIntentos +
                '}';
    }
//region interfaz serializable
    public static final Creator<Juego> CREATOR = new Creator<Juego>() {
        @Override
        public Juego createFromParcel(Parcel in) {
            return new Juego(in);
        }


        @Override
        public Juego[] newArray(int size) {
            return new Juego[size];
        }
    };
    //endregion
    //region interfaz parcelable
    protected Juego(Parcel in) {
        nombre = in.readString();
        numeroIntentos = in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(numeroIntentos);
    }
    //endregion
}
