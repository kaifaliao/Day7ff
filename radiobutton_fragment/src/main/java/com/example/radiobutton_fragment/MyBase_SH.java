package com.example.radiobutton_fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

public class MyBase_SH extends BaseAdapter {
    private Context context;
    private List<MyGson_SH.NewslistBean> newslist;
    private static int ING_ZUO = 0;
    private static int ING_YOU = 1;
    private final DisplayImageOptions options;

    public MyBase_SH(Context context, List<MyGson_SH.NewslistBean> newslist) {
        this.context = context;
        this.newslist = newslist;

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

        int t = getItemViewType(position);
        if(t==ING_ZUO){
            ViewHolderz holderz;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context,R.layout.activity_mybasesh_zuo,null);
                holderz = new ViewHolderz();
                holderz.txt_tielez = convertView.findViewById(R.id.txt_title);
                holderz.txt_description = convertView.findViewById(R.id.txt_description);
                holderz.img_ztu = convertView.findViewById(R.id.img_ytu);
                convertView.setTag(holderz);
            }else {
                holderz = (ViewHolderz) convertView.getTag();
            }
            holderz.txt_tielez.setText(newslist.get(position).getTitle());
            holderz.txt_description.setText(newslist.get(position).getDescription());
            //下载图片
            ImageLoader.getInstance().displayImage(newslist.get(position).getPicUrl(),holderz.img_ztu,options);
            return convertView;
        }else {
            ViewHoldery holdery;
            if(convertView == null){
                //加载自定义布局
                convertView = View.inflate(context,R.layout.activity_mybasesh_you,null);
                holdery = new ViewHoldery();
                holdery.txt_tieley = convertView.findViewById(R.id.txt_titley);
                holdery.txt_ctime = convertView.findViewById(R.id.txt_ctime);
                holdery.img_ytu = convertView.findViewById(R.id.img_ytu);
                convertView.setTag(holdery);
            }else {
                holdery = (ViewHoldery) convertView.getTag();
            }
            holdery.txt_tieley.setText(newslist.get(position).getTitle());
            holdery.txt_ctime.setText(newslist.get(position).getCtime());
            //下载图片
            ImageLoader.getInstance().displayImage(newslist.get(position).getPicUrl(),holdery.img_ytu,options);
            return convertView;
        }


    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0?ING_ZUO:ING_YOU;
    }

    class ViewHolderz{
        TextView txt_tielez,txt_description;
        ImageView img_ztu;
    }
    class ViewHoldery{
        TextView txt_tieley,txt_ctime;
        ImageView img_ytu;
    }
}
