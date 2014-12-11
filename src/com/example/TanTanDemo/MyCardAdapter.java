package com.example.TanTanDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChenHao on 2014-12-02 下午3:42.
 *
 * @modify:
 */
public class MyCardAdapter extends BaseAdapter {
    private List<CardModel> mlist;
    private LayoutInflater inflater;

    public MyCardAdapter(Context context, List<CardModel> list) {
        mlist = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_card, parent, false);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_age = (TextView) convertView.findViewById(R.id.tv_age);
            holder.tv_pictures = (TextView) convertView.findViewById(R.id.tv_pictures);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CardModel model = mlist.get(position);
        holder.tv_name.setText(model.getName());
        holder.tv_age.setText(String.valueOf(model.getAge()));
        holder.tv_pictures.setText(String.valueOf(model.getPictures()));
        return convertView;
    }

    static class ViewHolder {
        //        ImageView iv_image;
        TextView tv_age;
        TextView tv_name;
        TextView tv_pictures;
    }
}
