package com.example.computer_calc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<String> {
    //Поля
    Context context;
    String[] names;
    int[] images;
    //Конструктор
    public CustomAdapter(@NonNull Context context, String[] names, int[] images) {
        super(context, R.layout.spinner_item, names);
        this.context = context;
        this.names = names;
        this.images = images;
    }
    //Переопределение методов
    // Отвечает за внешний вид выпадающего списка в развёрнутом состоянии
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, null);
        TextView t1 = (TextView) row.findViewById(R.id.textView);
        ImageView i1 = (ImageView) row.findViewById(R.id.imageView);
        t1.setText(names[position]);
        i1.setImageResource(images[position]);
        return  row;
    }
    //Отвечает за внещний вид выпадающего списка в свёрнутом состоянии
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, null);
        TextView t1 = (TextView) row.findViewById(R.id.textView);
        ImageView i1 = (ImageView) row.findViewById(R.id.imageView);
        t1.setText(names[position]);
        i1.setImageResource(images[position]);
        return  row;
    }
}
