package com.danicc.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.danicc.guessnumber.R;
import com.danicc.guessnumber.databinding.ActivityEndPlayBinding;
/**
 * clase que responde segun si se ha superado el juego o no mediante el dato recibido en el bundle
 *<p>
 * si el booleano recibido es true: se informa de que se ha ganado el juego y el numero
 * de intentos necesarios.
 *<p>
 * si el booleano recibido es false: se informa de que se ha perdido y se muestra el numero oculto.
 * @author Dani Casado
 *  * @version 1.0
 */

public class EndPlayActivity extends AppCompatActivity {
   ActivityEndPlayBinding binding;
   boolean win=false;
   int intentos;
   int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        win=bundle.getBoolean("acertado");
        intentos=bundle.getInt("intentos");
        numero = bundle.getInt("random");
        if (win) {
            binding.tvFinalMessage.setText(getString(R.string.ganado) + String.valueOf(intentos) + " " + getString(R.string.intentos));
        }
       else {
            binding.tvFinalMessage.setText(getString(R.string.perdido)  + numero);
        }
    }
}