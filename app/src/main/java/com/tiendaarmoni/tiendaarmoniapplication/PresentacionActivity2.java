package com.tiendaarmoni.tiendaarmoniapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class PresentacionActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btInciarSesion, btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_presentacion2);
        btInciarSesion = findViewById(R.id.btinicio);
        btRegistrar = findViewById(R.id.btregistro);
        btRegistrar.setOnClickListener(this);
        btInciarSesion.setOnClickListener(this);
    }

    public  void  iniciosesion(){
        Intent intent =new Intent(this, InicioActivity2.class);
        startActivity(intent);
    }

    public void registro(){
        Intent intent =new Intent(this, RegistroActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btinicio:
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                iniciosesion();
                break;

            case R.id.btregistro:
                Toast.makeText(this, "Vamos a Registrarnos", Toast.LENGTH_SHORT).show();
                registro();
                break;
        }
    }
}