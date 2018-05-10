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
import com.example.radiobutton_fragment.MyBase_YLL;
import com.example.radiobutton_fragment.MyGson_YL;
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

public class Fragment3 extends Fragment {
    private XListView xListView;

    private int pageIndex = 1;
    private int clickType = 1;

    private String myDiZhi = "http://api.tianapi.com/huabian/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
    private List<MyGson_YL.NewslistBean> newslists;//用于累加集合中的数据
    private MyBase_YLL base_yll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen3,container,false);
        xListView = view.findViewById(R.id.xlv3);
        newslists = new ArrayList<>();
        //初始化
        initXList();
        //调用获取数据的方法
        requestDatas();

        return view;
    }

    private void requestDatas() {
        new MyTanks().execute(myDiZhi);
    }

    private void initXList() {
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                pageIndex = 1;
                clickType = 1;
                myDiZhi = "http://api.tianapi.com/huabian/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                requestDatas();
            }

            @Override
            public void onLoadMore() {
                pageIndex++;
                clickType = 2;
                myDiZhi = "http://api.tianapi.com/huabian/?key=48a7d7193e11bd2dd4a683b6e2f90a4f&num=10&page="+pageIndex;
                requestDatas();
            }
        });
    }
    class MyTanks extends AsyncTask<String,Void,String>{

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
            MyGson_YL myGson_yl = gson.fromJson(s, MyGson_YL.class);
            List<MyGson_YL.NewslistBean> newslist = myGson_yl.getNewslist();
            if(clickType == 1){
                newslists.clear();
            }
            newslists.addAll(newslist);
            //设置适配器
            setShiPeiQi();
            if(clickType == 1){
                xListView.stopRefresh();
            }else {
                xListView.stopLoadMore();
            }

        }
    }
    private void setShiPeiQi(){
        if(base_yll == null){
            base_yll = new MyBase_YLL(getActivity(),newslists);
            xListView.setAdapter(base_yll);
        }else {
            base_yll.notifyDataSetChanged();
        }
    }
}
