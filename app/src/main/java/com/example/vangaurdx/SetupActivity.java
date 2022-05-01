package com.example.vangaurdx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText UserName, FullName, CountryName;
    private Button SaveInfoButton;
    private CircleImageView UserProfileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        UserName= (EditText) findViewById(R.id.set_username);
        FullName= (EditText) findViewById(R.id.set_fullname);
        CountryName= (EditText) findViewById(R.id.set_country);

        SaveInfoButton= (Button) findViewById(R.id.set_data_button);
        UserProfileImage= (CircleImageView) findViewById(R.id.set_user_image);




    }
}