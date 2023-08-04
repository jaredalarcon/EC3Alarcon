package com.example.hunnids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.example.hunnids.databinding.ActivityLoginBinding;
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();


            if (email.equals("ejemplo@idat.com.pe") && password.equals("Peru123.")) {
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Aquí puedes mostrar un mensaje de error o realizar cualquier otra acción en caso de credenciales incorrectas.
            }
        });


        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString();
                String password = binding.password.getEditText().getText().toString();
                boolean isOK = email.equals("ejemplo@idat.com.pe") && password.equals("Peru123.");
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = binding.tilEmail.getEditText().getText().toString();
                String password = s.toString();
                boolean isOK = email.equals("ejemplo@idat.com.pe") && password.equals("Peru123.");
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}