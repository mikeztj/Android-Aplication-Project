package com.example.michael.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText edittxt_username;
    private EditText edittxt_password;

    private Button btn_login;
    private Button btn_register;

    private Vibrator vibrator;

    private TextInputLayout loginInputLayoutUsername;
    private TextInputLayout loginInputLayoutPassword;

    Database_Helper mDatabase_helper = new Database_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginInputLayoutUsername = findViewById(R.id.login_input_layout_username);
        loginInputLayoutPassword = findViewById(R.id.login_input_layout_password);

        edittxt_username = findViewById(R.id.login_input_username);
        edittxt_password = findViewById(R.id.login_input_password);
        edittxt_username.setHintTextColor(Color.WHITE);
        edittxt_password.setHintTextColor(Color.WHITE);

        btn_login = findViewById(R.id.button_login);
        btn_register = findViewById(R.id.button_register);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edittxt_username.getText().toString().trim();
                String password = edittxt_password.getText().toString();

                if(username.isEmpty())
                {
                    //Toast.makeText(Login.this, "Username & password must be filled", Toast.LENGTH_SHORT).show();
                    loginInputLayoutUsername.setErrorEnabled(true);
                    loginInputLayoutUsername.setError("Username must be filled");
                    edittxt_username.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (password.isEmpty())
                {
                    loginInputLayoutPassword.setErrorEnabled(true);
                    loginInputLayoutPassword.setError("Password must be filled");
                    edittxt_password.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else
                {
                    loginInputLayoutUsername.setErrorEnabled(false);
                    loginInputLayoutPassword.setErrorEnabled(false);

                   boolean cek = mDatabase_helper.checkLogin(username,password);

                   if (cek == true)
                   {
                       Toast.makeText(Login.this, "berhasil gan", Toast.LENGTH_SHORT).show();

                       Log.d("hasil ID", mDatabase_helper.IDResult());

                       String hasilID = mDatabase_helper.IDResult();

                       Intent intent = new Intent(getApplicationContext(), Destination_List.class);
                       intent.putExtra("ID", hasilID );

                       startActivity(intent);
                   }
                   else if(cek == false)
                   {
                       Toast.makeText(Login.this, "gagal gan", Toast.LENGTH_SHORT).show();
                   }



                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }

}
