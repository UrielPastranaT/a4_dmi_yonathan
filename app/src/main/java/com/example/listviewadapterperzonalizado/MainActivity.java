package com.example.listviewadapterperzonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lvAlumnos;
    private AdapterPersonalizado adaptadorPersonalizado;
    private ArrayList<Alumnos> arrayAlumnos;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAlumnos = new ArrayList<>();
        arrayAlumnos.add(new Alumnos("Uriel", "Pastrana"));
        arrayAlumnos.add(new Alumnos("Kevin", "Camacho"));
        arrayAlumnos.add(new Alumnos("Yosef", "Flores"));
        arrayAlumnos.add(new Alumnos("Amado", "Perez"));
        arrayAlumnos.add(new Alumnos("Victor", "Nieves"));

        lvAlumnos = (ListView)findViewById(R.id.lvAlumnos);
        adaptadorPersonalizado = new AdapterPersonalizado(this,  R.layout.list_nombres,arrayAlumnos);
        lvAlumnos.setAdapter(adaptadorPersonalizado);

        lvAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "Has seleccionado: "+ arrayAlumnos.get(position).getNombre() + " " + arrayAlumnos.get(position).getApellidos(), Toast.LENGTH_LONG).show();
            }
        });
    }
}