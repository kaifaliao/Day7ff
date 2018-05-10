package com.example.radiobutton_fragment.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bawei.jane.mxlistview.view.XListView;
import com.example.radiobutton_fragment.MainActivity;
import com.example.radiobutton_fragment.MyBase_SH;
import com.example.radiobutton_fragment.MyGson_SH;
import com.example.radiobutton_fragment.R;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    private XListView xListView;
    private MyBase_SH myBase_sh;
    private List<MyGson_SH.NewslistBean> newslists;

    //设置你点击的类型
    private int clickType = 1;//操作类型 1：刷新  2：加载更多操作

    private int pageIndex = 1;//加载的页面 默认为1
    private String myUrl = "http://api.tianapi.com/social/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen1,container,false);
        //获取资源id
        //listView = view.findViewById(R.id.listView_1);
        xListView = view.findViewById(R.id.xlv);

        newslists = new ArrayList<>();
        //初始化
        initXlv();
        //请求网络数据
        requestDataFunction();
        return view;
    }
    //请求数据
    private void requestDataFunction() {
        MyAsnk myAsnk = new MyAsnk();
        myAsnk.execute(myUrl);
    }
    //设置适配器
    private  void  setXLvAdapter(){
        if(myBase_sh == null){
            myBase_sh = new MyBase_SH(getActivity(), newslists);
            xListView.setAdapter(myBase_sh);
        }else {
            myBase_sh.notifyDataSetChanged();
        }
    }
    //初始化
    private void initXlv() {
        //1.设置支持的模式
        xListView.setPullLoadEnable(true);//支持上拉加载
        xListView.setPullRefreshEnable(true);//支持下拉刷新
        //2.设置上下拉刷新回调接口
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {//刷新时回调
                clickType = 1;
                pageIndex = 1;
                myUrl = "http://api.tianapi.com/social/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                requestDataFunction();
            }
            @Override
            public void onLoadMore() {//加载更多时回调
                clickType = 2;
                pageIndex++;
                Log.d("zzzz","他的页面是"+pageIndex);
                myUrl = "http://api.tianapi.com/social/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                requestDataFunction();
            }
        });
    }
    //异步框架
    class MyAsnk extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(strings[0]);
            try {
                HttpResponse response = httpClient.execute(httpGet);
                int code = response.getStatusLine().getStatusCode();
                if(code == 200){
                    HttpEntity entity = response.getEntity();
                    String s = EntityUtils.toString(entity);
                    return s;
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
            MyGson_SH myGson_sh = gson.fromJson(s, MyGson_SH.class);
            List<MyGson_SH.NewslistBean> newslist = myGson_sh.getNewslist();
            if(clickType == 1){
                newslists.clear();
            }
            newslists.addAll(newslist);
            //创建适配器
            setXLvAdapter();
            if(clickType == 1){
                //关闭头部视图
                xListView.stopRefresh();
            }else {
                //关闭底部视图
                xListView.stopLoadMore();
            }
        }
    }
}
