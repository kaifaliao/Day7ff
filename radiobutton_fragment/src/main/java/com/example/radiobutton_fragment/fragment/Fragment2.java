package com.example.radiobutton_fragment.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jane.mxlistview.view.XListView;
import com.example.radiobutton_fragment.MyBase_GL;
import com.example.radiobutton_fragment.MyGson_GL;
import com.example.radiobutton_fragment.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private List<MyGson_GL.NewslistBean> newslists;
    private XListView xListView;
    private int clickType = 1;//用于设置是 下拉加载还是上拉刷新
    private int pageIndex = 1;//设置加载的那一页 默认1
    private String myUri = "http://api.tianapi.com/guonei/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
    private MyBase_GL base_gl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen2,container,false);
        xListView = view.findViewById(R.id.xlv2);
        newslists = new ArrayList<>();
        //初始化
        initXListView();
        //调用获取网络数据的方法
        requestDataFunction();
        return view;
    }

    private void initXListView() {
        xListView.setPullRefreshEnable(true);//设置下拉刷新
        xListView.setPullLoadEnable(true);//设置加载跟多
        //2.设置上下拉刷新回调接口
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {//下拉刷新
                clickType = 1;
                pageIndex = 1;//设置下拉刷新是加载第一面的内容
                myUri = "http://api.tianapi.com/guonei/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                //请求数据
                requestDataFunction();
            }

            @Override
            public void onLoadMore() {//加载跟多
                clickType = 2;
                pageIndex++;
                myUri = "http://api.tianapi.com/guonei/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                //请求数据
                requestDataFunction();
            }
        });
    }

    private void requestDataFunction() {
        MyTank myTank = new MyTank();
        myTank.execute(myUri);
    }

    class MyTank extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(5000);
                urlConnection.setConnectTimeout(5000);
                if(urlConnection.getResponseCode() == 200){
                    InputStream inputStream = urlConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int len;
                    byte[] b = new byte[1024];
                    while ((len = inputStream.read(b))!=-1){
                        byteArrayOutputStream.write(b,0,len);
                    }
                    return byteArrayOutputStream.toString();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            MyGson_GL myGson_gl = gson.fromJson(s, MyGson_GL.class);
            List<MyGson_GL.NewslistBean> newslist = myGson_gl.getNewslist();
            if(clickType == 1){
                newslists.clear();
            }
            newslists.addAll(newslist);
            //获得适配器
            getShiPeiQi();
            if(clickType == 1){//判断你的操作时下拉还是上拉
                xListView.stopRefresh();
            }else {
                xListView.stopLoadMore();
            }
        }
    }

    //获取适配器的方法
    private  void getShiPeiQi(){
        if(base_gl == null){
            base_gl = new MyBase_GL(getActivity(),newslists);
            xListView.setAdapter(base_gl);
        }else {
            base_gl.notifyDataSetChanged();
        }
    };
}
