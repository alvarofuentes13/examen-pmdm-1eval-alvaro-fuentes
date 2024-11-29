package com.examalvarofuentes.examenpmdm;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.examalvarofuentes.examenpmdm.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        String contraseña = getString(R.string.password);
        TextInputLayout loginUsernameTIL = findViewById(R.id.loginUsernameTIL);
        TextInputLayout loginPasswordTIL = findViewById(R.id.loginPasswordTIL);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(loginUsernameTIL.getEditText().getText());
                String password = String.valueOf(loginPasswordTIL.getEditText().getText());

               if(password.equals(contraseña)){
                   SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor = preferences.edit();
                   editor.putString("username", username);
                   editor.putString("password", password);
                   editor.apply();
                   launchMain();
               }


            }
        });

    }



    public void launchMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
/**
    public void launchRegister() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
 **/
}
