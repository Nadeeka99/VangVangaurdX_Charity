package com.example.vangaurdx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button LoginButton;
    private EditText UserEmail,UserPassword;
    private TextView NeedNewAccouuntLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        NeedNewAccouuntLink = (TextView) findViewById(R.id.register_account_link);
        UserEmail = (EditText) findViewById(R.id.login_email);
        UserPassword = (EditText) findViewById(R.id.login_password);
        LoginButton = (Button) findViewById(R.id.login_button);


        NeedNewAccouuntLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                sendUserToRegisterActivity();
            }
        });
    }

    private void sendUserToRegisterActivity()
    {
        Intent registerIntent= new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(registerIntent);
        finish();
    }
}