package com.danicc.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.danicc.guessnumber.databinding.ActivityEndPlayBinding;
/**CLASE PARA MOSTRAR LOS RESULTADOS
 * En esta clase se muestra si el jugador a acertado o no,
 * el numero de intentos consumidos y el numero oculto.
 * @author Daniel
 * @version 1.0
 */
public class EndPlayActivity extends AppCompatActivity {
ActivityEndPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();


  binding.tvnumoculto.setText(bundle.getString("numfin"));
            binding.tvresultadotexto.setText(bundle.getString("mensaje"));
        binding.tvintentosgastados.setText(bundle.getString("nintentosconsumidos"));

    }
}