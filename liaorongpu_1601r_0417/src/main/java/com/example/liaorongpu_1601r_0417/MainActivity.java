package com.example.liaorongpu_1601r_0417;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    //File temFile = new File(Environment.getExternalStorageDirectory().getPath()+"/.jpg");
    private String temFile = Environment.getExternalStorageDirectory().getPath()+"/.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //加载资源id
        imageView = findViewById(R.id.img_tu);
        //给图片偏添加点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("修改图像");
                builder.setPositiveButton("相机", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //调用系统的拍照功能
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //设置图片储存的路径
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, new File(temFile));
                        startActivityForResult(intent,2000);
                    }
                });
                builder.setNegativeButton("从相册中选区", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2000 && resultCode == RESULT_OK){
            Bitmap bitmap = data.getParcelableExtra("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
