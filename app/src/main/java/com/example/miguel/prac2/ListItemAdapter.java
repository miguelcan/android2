package com.example.miguel.prac2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miguel on 20/11/2014.
 */
public class ListItemAdapter extends BaseAdapter {
    //Variables
    private Context mContext = null;
    private ArrayList<ListItem> mArrayList = null;
    private LayoutInflater mLayoutInflater = null;

    public ListItemAdapter (Context context, ArrayList <ListItem> arrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = arrayList;
    }

    @Override
    public Object getItem(int position) {

        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getCount (){
        return mArrayList.size();
    }

    static class Holder {
        ImageView imageComp;
        TextView txtCompany;
        TextView txtBusiness;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view = convertView;
        //Check if view is null
        if (view == null){
            holder = new Holder ();
            view = mLayoutInflater.inflate(R.layout.list_item,null);
            holder.imageComp = (ImageView)view.findViewById(R.id.image_comp);
            holder.txtCompany = (TextView)view.findViewById(R.id.txt_company);
            holder.txtBusiness = (TextView)view.findViewById(R.id.txt_business);
            view.setTag(holder);
        }
        else{
            holder=(Holder)view.getTag();

        }
        holder.imageComp.setImageDrawable(mArrayList.get(position).getCompLogo());
        holder.txtCompany.setText(mArrayList.get(position).getCompany());
        holder.txtBusiness.setText(mArrayList.get(position).getBusiness());

        return view;
    }



}



