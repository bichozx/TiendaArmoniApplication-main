package com.tiendaarmoni.tiendaarmoniapplication;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegistroActivity2 extends AppCompatActivity {

    EditText edtnombre,edtapellido, edtemail,edtpais,edtciudad,edpassword1,edtconfirpassword;
    Button btninicioregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_registro2);

        edtnombre = findViewById(R.id.eTNombre);
        edtapellido = findViewById(R.id.eTApellido);
        edtemail = findViewById(R.id.eTCorreo);
        edtpais = findViewById(R.id.eTPais);
        edtciudad = findViewById(R.id.eTCiudad);
        edpassword1 = findViewById(R.id.eTPassword2);
        edtconfirpassword = findViewById(R.id.eTConfigpassword);


    }
    public void  registrarusuario(View view)
    {
        if (registrar())
        {
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

        }

    }


    public boolean registrar()
    {
        boolean retornar = true;

        String nombre = edtnombre.getText().toString();
        String apellido = edtapellido.getText().toString();
        String email = edtemail.getText().toString();
        String pais = edtpais.getText().toString();
        String ciudad = edtciudad.getText().toString();
        String password = edpassword1.getText().toString();
        String confirpassword = edtconfirpassword.getText().toString();
        Pattern passworduser = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

        if (nombre.isEmpty())
        {
            edtnombre.setError("Campo Obligatorio");
            retornar = false;
        }

        if (apellido.isEmpty())
        {
            edtapellido.setError("Campo Obligatorio");
            retornar=false;
        }

        if (email.isEmpty())
        {
            edtemail.setError("Campo Obligatorio");
            retornar=false;

        }

        if (pais.isEmpty())
        {
            edtpais.setError("Campo Obligatorio");
            retornar=false;

        }

        if (ciudad.isEmpty())
        {
            edtciudad.setError("Campo Obligatorio");
            retornar = false;

        }

        if (password.isEmpty())
        {
            edpassword1.setError("Campo Obligatorio");
            retornar = false;

        }else  if (passworduser.matcher(password).matches() == false)

        {
            edpassword1.setError(" Debe incluir mayuscul, minuscula, @#$%^&+=, minimo 8 caracteres ");
            retornar = false;

        }else
        {
            edpassword1.setError(null);

        }

        if (confirpassword.equals(password))
        {
            Toast.makeText(getApplicationContext(), "las contraseña son iguales", Toast.LENGTH_SHORT).show();

        }

        return retornar;


    }




}