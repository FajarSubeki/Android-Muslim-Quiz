package com.example.muslimquiz.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muslimquiz.R;

public class QuranHardAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] img;
    private final String[] s;

    public QuranHardAdapter(Activity context, Integer[] img, String[] s) {
        super(context, R.layout.list_grid_quran_hard, s);
        this.context = context;
        this.img = img;
        this.s = s;
    }

    private class MyViewHolder {
        ImageView imageView;
        TextView mQueNo;

        MyViewHolder(View v) {
            imageView = v.findViewById(R.id.tick);
            mQueNo = v.findViewById(R.id.pfirst);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_grid_quran_hard,null, true);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }

        holder.imageView.setImageResource(img[position]);
        holder.mQueNo.setText(s[position]);

        return row;
    }
}
