package com.example.listview_imageloader_duotiaomu;

import android.media.midi.MidiDeviceService;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.listview_imageloader_duotiaomu.base.MyBase;
import com.example.listview_imageloader_duotiaomu.gson.MyGson;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        listView = findViewById(R.id.listView);

        MyTask myTask = new MyTask();
        myTask.execute("http://v.juhe.cn/toutiao/index?type=top&key=444da40ec8ee43818073d7131c2ffa8f");

    }
    class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                Log.d("zzzz","获取到的地址是："+strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(5000);
                urlConnection.setConnectTimeout(5000);
                Log.d("aaaa","得到的结果吗是："+urlConnection.getResponseCode());
                if(urlConnection.getResponseCode() == 200){
                    InputStream inputStream = urlConnection.getInputStream();
                    //调用将流转换陈字符串的方法
                    String s = zhuanString(inputStream);
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
            MyGson myGson = gson.fromJson(s, MyGson.class);
            List<MyGson.ResultBean.DataBean> list = myGson.getResult().getData();
            //创建适配器
            MyBase base = new MyBase(MainActivity.this,list);
            listView.setAdapter(base);
        }
    }

    private String zhuanString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len;
        byte[] b = new byte[1024];
        try {
            while ((len = inputStream.read(b))!=-1){
                byteArrayOutputStream.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}
