package ru.dimonmubmail.pharmacy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Dmitriy on 16.10.2014.
 */

public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {

    int layoutResourceId;
    public ArrayAdapterItem(Context mContext, int layoutResourceId, ObjectItem[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null) {
            LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.mTextView = (TextView)convertView.findViewById(R.id.medicineName);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.mTextView.setText(getItem(position).itemName);

        return convertView;
    }

    public static class ViewHolder {
        public TextView mTextView;
    }

}
