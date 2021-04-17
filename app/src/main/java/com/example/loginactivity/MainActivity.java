package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editTextPassword;
    EditText editTextUsername;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextUsername = findViewById(R.id.edit);
        editTextPassword = findViewById(R.id.edit_password);
        btn = findViewById(R.id.button);

        editTextUsername.addTextChangedListener(loginTextWatcher);
        editTextPassword.addTextChangedListener(loginTextWatcher);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toast = Toast.makeText(getApplicationContext(),
                        "Вы вошли в аккаунт ", Toast.LENGTH_LONG);
                toast.show();
            }
        });



    }
    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = editTextUsername.getText().toString().trim();
            String passwordInput = editTextPassword.getText().toString().trim();
            btn.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
            btn.setBackgroundResource(R.drawable.colorback);


        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };
}