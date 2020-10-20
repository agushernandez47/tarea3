package com.agushernandez.semanados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.DatePicker;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView miDisplayDate;
    private DatePickerDialog.OnDateSetListener miDateSetListener;
    private View.OnClickListener OnClickListener;

    String p_nombre_completo;
    String p_fecha_nacimiento;
    String p_telefono;
    String p_email;
    String p_descripcion;
    Button siguiente;

    private EditText nombre_completo;
    private EditText fecha_nacimiento;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miDisplayDate = (TextView) findViewById(R.id.calendarView2);
        miDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario = Calendar.getInstance();
                int year = calendario.get(Calendar.YEAR);
                int month = calendario.get(Calendar.MONTH);
                int day = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, miDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        miDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth +"/"+ month +"/"+ year;
                miDisplayDate.setText(date);
            }
        };

        siguiente = (Button) findViewById(R.id.button2);
        siguiente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nombre_completo     = (EditText) findViewById(R.id.editTextTextPersonName);
                fecha_nacimiento    = (EditText) findViewById(R.id.calendarView2);
                telefono            = (EditText) findViewById(R.id.editTextNumberSigned);
                email               = (EditText) findViewById(R.id.editTextTextEmailAddress);
                descripcion         = (EditText) findViewById(R.id.editTextTextPersonName2);

                Intent i = new Intent(getApplicationContext(), Confirmar.class);

                i.putExtra("p_nombre_completo", nombre_completo.getText().toString());
                i.putExtra("p_fecha_nacimiento", miDisplayDate.getText().toString());
                i.putExtra("p_telefono", telefono.getText().toString());
                i.putExtra("p_email", email.getText().toString());
                i.putExtra("p_descripcion", descripcion.getText().toString());

                startActivity(i);
            }
        });
    }

}