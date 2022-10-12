package com.danicc.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.danicc.guessnumber.R;
import com.danicc.guessnumber.data.Juego;
import com.danicc.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

/**
 * Clase  que recibe el nombre del usuario y el numero de intentos que utilizara para jugar en un
 * objeto de la clase juego(nombre,numeroIntentos) enviada por la config activity
 * <p>
 * Al pulsar sobre el boton probar se comprobara si el numero introducido es mayor menor o igual
 * que el creado como random en esta clase y se actuara segun el caso.
 * <p>
 * al pulsar sobre el boton borrar se dejara vacio el campo para introducir un numero
 * <p>
 * finalmente se envia a traves de un bundle si se ha acertado o no, el numero de intentos
 * gastados y el numero aleatorio a adivinar.
 *
 * @author Dani Casado
 * @version 1.0
 */
public class PlayActivity extends AppCompatActivity {
    ActivityPlayBinding binding;
    Random rnd = new Random();
    int rndint = rnd.nextInt(100) + 1;
    Juego juego;
    int maxIntentos;
    boolean acertado = false;
    int gastados = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        juego = (Juego) bundle.getSerializable("juego");
        maxIntentos = juego.getNumeroIntentos();
    }

    /**
     * Metodo que dependiendo del id del view(Button) ejecutara un metodo u otro
     *
     * @param view
     */
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btnProbar:
                ProbarNumero();
                break;

            case R.id.btnBorrar:
                BorrarCampos();
                break;
        }
    }

    //metodo para comprobar si el numero es correcto/menor/mayor
    private void ProbarNumero() {

        if (!ComprobarNumeroVacio()) {
            if (ComprobarDigito()) {
                int numero = Integer.parseInt(binding.etNumeroIntentado.getText().toString());
                if (numero == rndint) {
                    acertado = true;
                    CargarEndPlay();
                    return;
                } else {
                    gastados++;
                    if (gastados == maxIntentos) {
                        CargarEndPlay();
                        return;
                    }
                    if (numero < rndint) {
                        binding.tvInfo.setText(getString(R.string.msgMayor));
                    } else {
                        binding.tvInfo.setText(getString(R.string.msgMenor));
                    }
                }
            } else {
                Toast.makeText(this, R.string.ErrorType, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.ErrorEmpty, Toast.LENGTH_LONG).show();
        }
    }

    boolean ComprobarNumeroVacio() {
        return TextUtils.isEmpty(binding.etNumeroIntentado.getText());

    }

    boolean ComprobarDigito() {
        return (TextUtils.isDigitsOnly(binding.etNumeroIntentado.getText()));
    }

    private void CargarEndPlay() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("acertado", acertado);
        bundle.putInt("intentos", gastados);
        bundle.putInt("random", rndint);
        Intent intent = new Intent(this, EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Metodo del evento onClick del boton borrar
     * Encargado de vaciar los EditText
     */
    private void BorrarCampos() {
        binding.etNumeroIntentado.setText("");
        binding.tvInfo.setText("_");
    }
}