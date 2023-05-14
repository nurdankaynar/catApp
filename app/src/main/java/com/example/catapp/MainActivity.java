package com.example.catapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button loginButton;
    String UsrName, UsrPass, CorrUsr="user", CorrPass ="1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsrName = username.getText().toString();
                UsrPass = password.getText().toString();
                if (!TextUtils.isEmpty(UsrName) && !TextUtils.isEmpty(UsrPass)) {
                    if (UsrName.equals(CorrUsr) && UsrPass.equals(CorrPass)) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("intentUserName",UsrName);
                        finish();
                        startActivity(intent);
                    }else
                        Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre boş bırakılamaz", Toast.LENGTH_SHORT).show();
            }

        });
    }
}