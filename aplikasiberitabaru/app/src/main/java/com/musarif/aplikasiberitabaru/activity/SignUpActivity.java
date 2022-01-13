package com.musarif.aplikasiberitabaru.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.musarif.aplikasiberitabaru.DBHelper;
import com.musarif.aplikasiberitabaru.R;

public class SignUpActivity extends AppCompatActivity {
    Button signup;
    EditText username, password, repassword;
    TextView tvLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if(getSupportActionBar()!= null){
            getSupportActionBar().hide();
        }

        username = findViewById(R.id.etUsernameSignUp);
        password = findViewById(R.id.etPasswordSignUp);
        repassword = findViewById(R.id.etRePasswordSignUp);
        signup = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvGoLogin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(SignUpActivity.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(SignUpActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(goToLogin);
            }
        });
    }
}