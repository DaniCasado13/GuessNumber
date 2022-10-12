package com.danicc.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.danicc.guessnumber.R;
import com.danicc.guessnumber.data.Juego;
import com.danicc.guessnumber.databinding.ActivityConfigBinding;
/**
 * Clase  que recoge el nombre del usuario y el numero de intentos que utilizara para jugar en un
 * objeto de la clase juego(nombre,numeroIntentos) y envia dicho objeto
 * a la activity controladora del juego mediante el evento Onclick del boton
 *
 * @author Dani Casado
 * @version 1.0
 */
public class ConfigActivity extends AppCompatActivity {
    ActivityConfigBinding binding;
    private EditText etnombre;
    private EditText etintentos;
    private Button btnjugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        etnombre = binding.etNombreUser;
        etintentos = binding.etIntentos;
        btnjugar = binding.btnJugar;

        //OnClick a traves de una expresion lambda
        btnjugar.setOnClickListener(v -> {
            Play();
        });
    }

    //metodo que se llama desde el onClickListener del boton
    private void Play() {
        //controlar que los editext no estan vacios
        if (Campovacio()) {
            Toast.makeText(this, R.string.ErrorEmpty, Toast.LENGTH_LONG).show();
        } else
            //controlar que el numero de intentos es al menos 1
            if (IntentosValidos()) {
                Toast.makeText(this, R.string.ErrorZero, Toast.LENGTH_LONG).show();
            } else {
                //se inicia el juego
                Bundle bundle = new Bundle();
                Juego juego = new Juego();
                juego.setNombre(etnombre.getText().toString());
                juego.setNumeroIntentos(Integer.parseInt(etintentos.getText().toString()));
                bundle.putSerializable("juego", juego);
                Intent intent = new Intent(this, PlayActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
    }
    private boolean Campovacio(){
        return TextUtils.isEmpty(etnombre.getText())
                || TextUtils.isEmpty(etintentos.getText());
    }
    private boolean IntentosValidos(){

        return Integer.parseInt(etintentos.getText().toString()) < 1;
    }
}


