package com.example.listview_imageloader_duotiaomu.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview_imageloader_duotiaomu.R;
import com.example.listview_imageloader_duotiaomu.gson.MyGson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

public class MyBase extends BaseAdapter {
    private static int IMG_YI = 0;
    private static int IMG_ER = 1;
    private static int IMG_SAN = 2;
    private Context context;
    private List<MyGson.ResultBean.DataBean> list;
    private final DisplayImageOptions options;

    public MyBase(Context context, List<MyGson.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int t = getItemViewType(position);
        if(t == IMG_YI){
            ViewHolder1 holder1;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase1,null);
                holder1 = new ViewHolder1();
                holder1.txt_title1 = convertView.findViewById(R.id.txt_title1);
                holder1.img_tu1 = convertView.findViewById(R.id.img_tu01);
                convertView.setTag(holder1);
            }else {
                holder1 = (ViewHolder1) convertView.getTag();
            }
            holder1.txt_title1.setText(list.get(position).getTitle());
            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder1.img_tu1,options);
            return convertView;
        }else if(t == IMG_ER){
            ViewHolder2 holder2;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase2,null);
                holder2 = new ViewHolder2();
                holder2.txt_title2 = convertView.findViewById(R.id.txt_title2);
                holder2.img_021 = convertView.findViewById(R.id.img_021);
                holder2.img_022 = convertView.findViewById(R.id.img_022);
                convertView.setTag(holder2);
            }else {
                holder2 = (ViewHolder2) convertView.getTag();
            }
            holder2.txt_title2.setText(list.get(position).getTitle());

            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder2.img_021,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder2.img_022,options);
            return convertView;
        }else {
            ViewHolder3 holder3;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase3,null);
                holder3 = new ViewHolder3();
                holder3.txt_title3 = convertView.findViewById(R.id.txt_title3);
                holder3.img_031 = convertView.findViewById(R.id.img_031);
                holder3.img_032 = convertView.findViewById(R.id.img_032);
                holder3.img_033 = convertView.findViewById(R.id.img_033);
                convertView.setTag(holder3);
            }else {
                holder3 = (ViewHolder3) convertView.getTag();
            }
            holder3.txt_title3.setText(list.get(position).getTitle());
            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder3.img_031,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder3.img_032,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),holder3.img_033,options);
            return convertView;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
        public int getItemViewType(int position) {
        //得到三站图片的地址
        String tu1 = list.get(position).getThumbnail_pic_s();
        String tu2 = list.get(position).getThumbnail_pic_s02();
        String tu3 = list.get(position).getThumbnail_pic_s03();
        if(tu1!=null && tu2==null && tu3==null){
            return IMG_YI;
        }else  if(tu1!=null && tu2!=null && tu3==null ){
            return IMG_ER;
        }else if(tu1!=null && tu2!=null && tu3!=null ) {
            return IMG_SAN;
        }
        return -1;
    }

    class ViewHolder1{
        TextView txt_title1;
        ImageView img_tu1;
    }
    class ViewHolder2{
        TextView txt_title2;
        ImageView img_021,img_022;
    }
    class ViewHolder3{
        TextView txt_title3;
        ImageView img_031,img_032,img_033;
    }


    /* if(t == IMG_YI){
            ViewHolder1 holder1;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase1,null);
                holder1 = new ViewHolder1();
                holder1.txt_title1 = convertView.findViewById(R.id.txt_title1);
                holder1.img_tu1 = convertView.findViewById(R.id.img_tu01);
                convertView.setTag(holder1);
            }else {
                holder1 = (ViewHolder1) convertView.getTag();
            }
            holder1.txt_title1.setText(list.get(position).getTitle());
            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder1.img_tu1,options);
            return convertView;
        }else if(t == IMG_ER){
            ViewHolder2 holder2;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase2,null);
                holder2 = new ViewHolder2();
                holder2.txt_title2 = convertView.findViewById(R.id.txt_title2);
                holder2.img_021 = convertView.findViewById(R.id.img_021);
                holder2.img_022 = convertView.findViewById(R.id.img_022);
                convertView.setTag(holder2);
            }else {
                holder2 = (ViewHolder2) convertView.getTag();
            }
            holder2.txt_title2.setText(list.get(position).getTitle());

            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder2.img_021,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder2.img_022,options);
            return convertView;
        }else {
            ViewHolder3 holder3;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context, R.layout.activity_mybase3,null);
                holder3 = new ViewHolder3();
                holder3.txt_title3 = convertView.findViewById(R.id.txt_title3);
                holder3.img_031 = convertView.findViewById(R.id.img_031);
                holder3.img_032 = convertView.findViewById(R.id.img_032);
                holder3.img_033 = convertView.findViewById(R.id.img_033);
                convertView.setTag(holder3);
            }else {
                holder3 = (ViewHolder3) convertView.getTag();
            }
            holder3.txt_title3.setText(list.get(position).getTitle());
            //下载图片
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder3.img_031,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder3.img_032,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),holder3.img_033,options);
            return convertView;
        }
*/
}
