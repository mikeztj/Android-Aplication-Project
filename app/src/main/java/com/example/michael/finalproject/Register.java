package com.example.michael.finalproject;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class Register extends AppCompatActivity {

    private EditText edittxt_username;
    private EditText edittxt_password;
    private EditText edittxt_conpass;
    private EditText edittxt_PhoneNumber;
    private EditText edittxt_Concode;

    private Button btn_login;
    private Button btn_register;
    private Button btn_concode;

    private Vibrator vibrator;

    private TextInputLayout registerInputLayoutUsername;
    private TextInputLayout registerInputLayoutPassword;
    private TextInputLayout registerInputLayoutConpass;
    private TextInputLayout registerInputLayoutPhoneNumber;
    private TextInputLayout registerInputLayoutConcode;

    private Random numbergenerator = new Random();

    private String Total;

    String UserID;

    Database_Helper mDatabase_helper = new Database_Helper(this);

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 123) {
            int Send_Permission = this.checkSelfPermission(Manifest.permission.SEND_SMS);
            int Receive_Permission = this.checkSelfPermission(Manifest.permission.RECEIVE_SMS);

            if (Send_Permission == PackageManager.PERMISSION_DENIED || Receive_Permission == PackageManager.PERMISSION_DENIED) {
                btn_concode.setEnabled(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerInputLayoutUsername = findViewById(R.id.register_input_layout_username);
        registerInputLayoutPassword = findViewById(R.id.register_input_layout_password);
        registerInputLayoutConpass = findViewById(R.id.register_input_layout_confirmPassword);
        registerInputLayoutPhoneNumber = findViewById(R.id.register_input_layout_phoneNumber);
        registerInputLayoutConcode = findViewById(R.id.register_input_layout_confirmationCode);

        edittxt_username = findViewById(R.id.register_input_username);
        edittxt_password = findViewById(R.id.register_input_password);
        edittxt_conpass = findViewById(R.id.register_input_confirmPassword);
        edittxt_PhoneNumber = findViewById(R.id.register_input_phoneNumber);
        edittxt_Concode = findViewById(R.id.register_input_confirmationCode);

        btn_login = findViewById(R.id.button_login_register);
        btn_register = findViewById(R.id.button_register_register);
        btn_concode = findViewById(R.id.button_confirmation_code_register);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        SMS();

        btn_concode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edittxt_PhoneNumber.getText().toString();

                if (phoneNumber.length() <10 || phoneNumber.length()>12)
                {
                    //Toast.makeText(register.this, "phone number must be between 10 and 12 digits", Toast.LENGTH_SHORT).show();
                    registerInputLayoutPhoneNumber.setErrorEnabled(true);
                    registerInputLayoutPhoneNumber.setError("Phone number must be between 10 and 12 digits");
                    edittxt_PhoneNumber.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else
                {
                    registerInputLayoutPhoneNumber.setErrorEnabled(false);

                    int number1 = numbergenerator.nextInt(9);
                    int number2 = numbergenerator.nextInt(9);
                    int number3 = numbergenerator.nextInt(9);
                    int number4 = numbergenerator.nextInt(9);
                    int number5 = numbergenerator.nextInt(9);
                    int number6 = numbergenerator.nextInt(9);

                    Total = Integer.toString(number1)+ Integer.toString(number2)+ Integer.toString(number3)+ Integer.toString(number4)+ Integer.toString(number5)+ Integer.toString(number6);

                    Log.d("angka ", Total);

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, Total,null,null);
                }

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edittxt_username.getText().toString().trim();
                String password = edittxt_password.getText().toString();
                String conpass = edittxt_conpass.getText().toString();
                String phoneNumber = edittxt_PhoneNumber.getText().toString();
                String concode = edittxt_Concode.getText().toString();

                if (username.length() <3 || username.length()>25)
                {
                    //Toast.makeText(register.this, "username must be between 3 and 25 characters", Toast.LENGTH_SHORT).show();
                    registerInputLayoutUsername.setErrorEnabled(true);
                    registerInputLayoutUsername.setError("Username must be between 3 and 25 characters");
                    edittxt_username.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (password.length()<6)
                {
                    //Toast.makeText(register.this, "password must be more than 6 characters", Toast.LENGTH_SHORT).show();
                    registerInputLayoutPassword.setErrorEnabled(true);
                    registerInputLayoutPassword.setError("Password must be more than 6 characters");
                    edittxt_password.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if(password.equals(password.toLowerCase()))
                {
                    registerInputLayoutPassword.setErrorEnabled(true);
                    registerInputLayoutPassword.setError("password must contains at least 1 lowercased letter");
                    edittxt_password.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if(password.equals(password.toUpperCase()))
                {
                    registerInputLayoutPassword.setErrorEnabled(true);
                    registerInputLayoutPassword.setError("password must contains at least 1 uppercased letter");
                    edittxt_password.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (numeric_check(password) == false){
                    //Toast.makeText(register.this, "password must contains at least 1 digit, 1 uppercased letter and 1 lowercased letter", Toast.LENGTH_SHORT).show();
                    registerInputLayoutPassword.setErrorEnabled(true);
                    registerInputLayoutPassword.setError("Password must contains at least 1 digit");
                    edittxt_password.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (!conpass.equals(password))
                {
                    //Toast.makeText(register.this, "confirmation password must be the same with password", Toast.LENGTH_SHORT).show();
                    registerInputLayoutConpass.setErrorEnabled(true);
                    registerInputLayoutConpass.setError("Confirmation password must be the same with password");
                    edittxt_conpass.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (phoneNumber.length() <10 || phoneNumber.length()>12)
                {
                    //Toast.makeText(register.this, "phone number must be between 10 and 12 digits", Toast.LENGTH_SHORT).show();
                    registerInputLayoutPhoneNumber.setErrorEnabled(true);
                    registerInputLayoutPhoneNumber.setError("Phone number must be between 10 and 12 digits");
                    edittxt_PhoneNumber.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else if (Total != concode)
                {
                    registerInputLayoutConcode.setErrorEnabled(true);
                    registerInputLayoutConcode.setError("Confirmation code must be the same with the confirmation code from SMS");
                    edittxt_Concode.setError("valid input required");
                    vibrator.vibrate(120);
                }
                else
                {
                    registerInputLayoutUsername.setErrorEnabled(false);
                    registerInputLayoutPassword.setErrorEnabled(false);
                    registerInputLayoutConpass.setErrorEnabled(false);
                    registerInputLayoutPhoneNumber.setErrorEnabled(false);

                    user_check();

                    Users usr = new Users();
                    usr.setUserID(UserID);
                    usr.setUsername(username);
                    usr.setPassword(password);
                    usr.setPhoneNumber(phoneNumber);
                    mDatabase_helper.addTableUser(usr);

                    Toast.makeText(getApplicationContext(), "You are successfully Register !!", Toast.LENGTH_SHORT).show();

                    List<Users> users_list = mDatabase_helper.getAllUsers();
                    for(Users users: users_list)
                    {
                        Log.d("Users: ",users.getUserID() + " " + users.getUsername()+ " " + users.getPassword()+ " " + users.getPhoneNumber());
                    }
                }

            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    public void user_check()
    {
        if (mDatabase_helper.checkUsers()==0)
        {
            UserID = "US001";
        }
        else
        {
            String id = mDatabase_helper.checkUserID();

            String split = id.substring(id.length()-3);

            int pecah = Integer.parseInt(split);

            pecah++;

            UserID = "US"+String.format("%03d", pecah);
        }
    }

    public boolean numeric_check(String pass){
        int counterNumeric = 0;

        for(char c : pass.toCharArray()){
            if(Character.isDigit(c)){
                counterNumeric++;
            }
        }

        if (counterNumeric>=1){
            counterNumeric=0;
            return true;
        }
        return false;
    }

    public void SMS()
    {
        int send_Permission = this.checkSelfPermission(Manifest.permission.SEND_SMS);
        int receive_Permission = this.checkSelfPermission(Manifest.permission.RECEIVE_SMS);

        if (send_Permission == PackageManager.PERMISSION_DENIED || receive_Permission == PackageManager.PERMISSION_DENIED)
        {
            String[] permissions = new String[]{
                    Manifest.permission.SEND_SMS,
                    Manifest.permission.RECEIVE_SMS
            };
            this.requestPermissions(permissions, 123);
        }
    }
}
