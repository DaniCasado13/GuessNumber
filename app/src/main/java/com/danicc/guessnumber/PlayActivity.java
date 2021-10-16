package com.danicc.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.danicc.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

/**
 * CLASE DE IMPLEMENTACION DEL JUEGO
 * En esta clase se le pide al jugador que introduzca el numero que piensa
 * que es el acertado.
 * Mediante el boton comprobar: se comprueba si el numero es acertado, menor o mayor.
 * Mediante el boton borrar: se vacia el campo del numero para que el jugador vuelva a intentarlo.
 * Mediante un cuadro de texto informamos al usuario si el numero es menor o mayor del introducido
 * Una vez se halla acabado el juego(Bien acertando el numero o gastanto el numero de intentos)
 * Se pasa a la siguiente activity que muestra el resultado final.
 * @author Daniel
 * @version 1.0
 */
public class PlayActivity extends AppCompatActivity {

ActivityPlayBinding binding;
Random rnd = new Random();
public Integer numRandom=rnd.nextInt(101);
    Integer _nIntentosMaximo;
    public   Integer _nIntentosConsumidos=0;
    String _user;
Bundle bnd;

Intent intento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();

        _nIntentosConsumidos=0;
        _nIntentosMaximo=bundle.getInt("intentos");
        _user= bundle.getString("name");

    }
    public void onClickButtonPlay(View view) {
        switch (view.getId()) {
            case R.id.btncomprobar:
                btnComprobarclick();
                break;
            case R.id.btnborrar:
                btnBorrar();
                break;
        }
    }
    public void btnComprobarclick() {
        int numeroIntentado = Integer.parseInt(binding.etnumpropuesto.getText().toString());
        if (numeroIntentado == numRandom) {

                  bnd= new Bundle();
                  bnd.putString("numfin",numRandom.toString());
                  bnd.putString("mensaje", getResources().getString(R.string.acierto));
                  bnd.putString("nintentosconsumidos",_nIntentosConsumidos.toString());
                   intento = new Intent(this,EndPlayActivity.class);
                  intento.putExtras(bnd);
                  startActivity(intento);
        } else {
            _nIntentosMaximo--;
            _nIntentosConsumidos++;
            if (_nIntentosMaximo == 0) {

                bnd= new Bundle();
                bnd.putString("numfin",numRandom.toString());
                bnd.putString("mensaje",getResources().getString(R.string.fallo));
                bnd.putString("nintentosconsumidos",_nIntentosConsumidos.toString());
                intento = new Intent(this,EndPlayActivity.class);
                intento.putExtras(bnd);
                startActivity(intento);
            }
            if (numeroIntentado < numRandom) {
                binding.tvestado.setText(_user+" "+getResources().getString(R.string.nocultomayor)+" " +" Intentos: "+_nIntentosMaximo);
            } if(numeroIntentado>numRandom)
                binding.tvestado.setText(_user+" "+getResources().getString(R.string.nocultomenor)+" "+ " Intentos: " +_nIntentosMaximo);
            }
        }


    public void btnBorrar() {
        binding.etnumpropuesto.setText("");
        binding.tvestado.setText("");
    }
}