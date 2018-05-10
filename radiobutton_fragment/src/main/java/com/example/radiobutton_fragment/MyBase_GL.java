package com.example.radiobutton_fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by John on 2018/4/18 0018.
 */

public class MyBase_GL extends BaseAdapter {

    private Context context;
    private List<MyGson_GL.NewslistBean> newslist;

    public MyBase_GL(Context context, List<MyGson_GL.NewslistBean> newslist) {
        this.context = context;
        this.newslist = newslist;
    }

    @Override
    public int getCount() {
        return newslist.size();
    }

    @Override
    public Object getItem(int position) {
        return newslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(context,R.layout.activity_mybase_gl,null);
            holder = new ViewHolder();
            holder.txt_title2 = convertView.findViewById(R.id.txt_title2);
            holder.txt_ctime2 = convertView.findViewById(R.id.txt_ctime2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txt_title2.setText(newslist.get(position).getTitle());
        holder.txt_ctime2.setText(newslist.get(position).getCtime());

        return convertView;
    }
    class ViewHolder{
        TextView txt_title2,txt_ctime2;
        ImageView img_tu2;
    }
}
