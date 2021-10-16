package com.danicc.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.danicc.guessnumber.databinding.ActivityConfigBinding;

/**
 * En esta clase se implementa la funcionalidad del botón jugar
 * y manda la informacion recogida en el bundle la siguiente activity
 * @author Daniel
 * @version 1.0
 */
public class ConfigActivity extends AppCompatActivity {

private ActivityConfigBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btSend.setOnClickListener(view -> {
            btSendOnClick();
        });
    }

    private void btSendOnClick() {
        Bundle bundle= new Bundle();

if(!binding.etnombre.getText().toString().isEmpty()||!binding.etintentos.getText().toString().isEmpty()) {
    bundle.putString("name", binding.etnombre.getText().toString());
    bundle.putInt("intentos", Integer.parseInt(binding.etintentos.getText().toString()));
    Intent intent = new Intent(this, PlayActivity.class);
    intent.putExtras(bundle);
    startActivity(intent);
}
    }
}