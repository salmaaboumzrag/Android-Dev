package com.example.myapplication4_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.List;

public class VilleAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public VilleAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size(); //Attention!!!!!!!
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layoutItem;
        LayoutInflater mInflater = LayoutInflater.from(context);
        //(1) : Réutilisation du layout
        if (convertView == null) {
            layoutItem = (ConstraintLayout)
                    mInflater.inflate(R.layout.item_layout, parent, false);
        } else { layoutItem = (ConstraintLayout) convertView; }

        ViewHolder viewHolder = (ViewHolder) layoutItem.getTag();
        if(viewHolder == null) {
            viewHolder = new ViewHolder();
        //(2) : Récupération des TextView de notre layout
            viewHolder.tv = (TextView) layoutItem.findViewById(R.id.textView);
            viewHolder.img = layoutItem.findViewById(R.id.imageView);
            layoutItem.setTag(viewHolder);
        }
        //(3) : Mise à jour des valeurs
        viewHolder.tv.setText(list.get(position));
        int resID = context.getResources().getIdentifier('i'+list.get(position),"mipmap",context.getPackageName());
        if (resID != 0)  viewHolder.img.setImageResource(resID);
        else viewHolder.img.setImageResource(R.mipmap.ic_launcher);
        //On retourne l'item créé.
        return layoutItem;
    }
    private class ViewHolder {
        public TextView tv;
        public ImageView img;
    }
}