package com.example.rentacarapptestphase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Logout extends AppCompatActivity
{

    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        tvLogin=(TextView)findViewById(R.id.lgoinAgain);
        tvLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                startActivity(intent);



            }
        });

    }
}