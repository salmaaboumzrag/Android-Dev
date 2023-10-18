package fr.lbuathier.tp_contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> list;
    private Context context;

    public ContactAdapter(Context context, ArrayList<Contact> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layoutItem;
        LayoutInflater mInflater = LayoutInflater.from(context);
        //(1) : Réutilisation du layout
        if (convertView == null) {
            layoutItem = (ConstraintLayout) mInflater.inflate(R.layout.item_layout, parent, false);
        } else {
            layoutItem = (ConstraintLayout) convertView;
        }
//(2) : Récupération des TextView de notre layout
        TextView tv = layoutItem.findViewById(R.id.tvEquipe);
        ImageView imv = layoutItem.findViewById(R.id.imvFanion);

        //(3) : Mise à jour des valeurs
        String nom = list.get(position).getName();
        tv.setText(nom);
   /*    int resID = context.getResources().getIdentifier("ic_"+nom.toLowerCase(),"mipmap", context.getPackageName());
        if (resID !=0) imv.setImageResource(resID);
        else imv.setImageResource(R.mipmap.ic_launcher);
*/
        //On retourne l'item créé.
        return layoutItem;


    }
}
