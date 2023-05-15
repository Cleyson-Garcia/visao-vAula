package com.example.visao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.visao.R;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView numberLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        numberLogin = (TextView) findViewById(R.id.numberLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListaAulasActivity.class);
                i.putExtra("id",Integer.parseInt(numberLogin.getText().toString()));
                startActivity(i);
            }
        });
    }
}