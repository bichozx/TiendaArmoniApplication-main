package com.tiendaarmoni.tiendaarmoniapplication;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class InicioActivity2 extends AppCompatActivity {

    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_inicio2);

        edtEmail = findViewById(R.id.eTEmail);
        edtPassword = findViewById(R.id.eTTPassword);
    }

    public void acceso(View view)
    {
        if(inicio())
        {
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

        }
    }



    public boolean inicio()
    {
       String email = edtEmail.getText().toString();
       String passwordinicio = edtPassword.getText().toString();
        Pattern validar = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

        boolean iniciar =true;

        if(email.isEmpty())
        {
            edtEmail.setError("Campo Obligatorio");
            iniciar = false;
        }

        if (passwordinicio.isEmpty())
        {
            edtPassword.setError("Campo Obligatorio");
            iniciar = false;

        }else if (validar.matcher(passwordinicio).matches() == false)
        {
            edtPassword.setError("Debe incluir mayuscul, minuscula, @#$%^&+=, minimo 8 caracteres");
            iniciar = false;

        }else
        {
            edtPassword.setError(null);
        }

        return iniciar;


    }


}
