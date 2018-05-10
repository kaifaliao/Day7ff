package com.example.radiobutton_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.radiobutton_fragment.fragment.Fragment1;
import com.example.radiobutton_fragment.fragment.Fragment2;
import com.example.radiobutton_fragment.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        group = findViewById(R.id.group);
        getFragment(new Fragment1());

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_sh:
                        getFragment(new Fragment1());
                        break;
                    case R.id.btn_gn:
                        getFragment(new Fragment2());
                        break;
                    case R.id.btn_yl:
                        getFragment(new Fragment3());
                        break;
                }
            }
        });

    }
    public void getFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragm,fragment);
        fragmentTransaction.commit();
    }
}
