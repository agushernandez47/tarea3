package com.agushernandez.semanados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btn_editar_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("p_nombre_completo");
        String fecha = extras.getString("p_fecha_nacimiento");
        String telefono = extras.getString("p_telefono");
        String email = extras.getString("p_email");
        String descripcion = extras.getString("p_descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(nombre);

        tvFechaNacimiento = (TextView) findViewById(R.id.tvFecha);
        tvFechaNacimiento.setText(fecha);

        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvTelefono.setText(telefono);

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEmail.setText(email);

        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvDescripcion.setText(descripcion);

        btn_editar_datos = (Button) findViewById(R.id.btn_editar);
        btn_editar_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}