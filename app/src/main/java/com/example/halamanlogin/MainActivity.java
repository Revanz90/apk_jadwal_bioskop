package com.example.halamanlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    TextView menu1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);

        login=(Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, jadwal_bioskop.class);
                startActivity(intent);
            }
        });

        menu1 = findViewById(R.id.pindah);

        menu1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        cek_form(username);
        cek_form(password);
    }
    void login()
    {
        if (username.getText().length()<1)
        {
            username.setBackgroundResource(R.drawable.form_error);
        }
        if (password.getText().length()<1)
        {
            password.setBackgroundResource(R.drawable.form_error);
        }
    }
    void cek_form(EditText editText)
    {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2<1)
                {
                    username.setBackgroundResource(R.drawable.form_error);
                }
                else {
                    username.setBackgroundResource(R.drawable.form);
                }
                if (i2<1)
                {
                    password.setBackgroundResource(R.drawable.form_error);
                }
                else {
                    password.setBackgroundResource(R.drawable.form);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}