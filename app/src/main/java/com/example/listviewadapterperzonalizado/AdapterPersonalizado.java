package com.example.listviewadapterperzonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizado extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<Alumnos> alumnos;

    public AdapterPersonalizado(Context context, int layout, ArrayList<Alumnos> alumnos)
    {
        this.context = context;
        this.layout = layout;
        this.alumnos = alumnos;
    }

    @Override public int getCount()
    {
        return alumnos.size();
    }

    @Override public Object getItem(int position)
    {
        return alumnos.get(position);
    }

    @Override public long getItemId(int id)
    {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        Alumnos datos = alumnos.get(position);

        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_nombres, null);

        TextView tvNombre = (TextView)v.findViewById(R.id.tvNombre);
        TextView tvApellidos = (TextView)v.findViewById(R.id.tvApellidos);

        tvNombre.setText(datos.getNombre());
        tvApellidos.setText(datos.getApellidos());

        return v;
    }
}
