package com.example.kalc_degiskenler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    Button b;
    TextView tv;
    int say;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("kalıcıdeğişkenler ",say);  //iki tarafında bildiği bir mesaj olmalı


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textView);
        b=(Button)findViewById(R.id.button);

        if(savedInstanceState !=null){//yani telefonu yan cevirmeden önce telefona bişiler save edilmişse
            say = savedInstanceState.getInt("kalıcıdeğişkenler ");
            //telefonu yan cevirdiğimizdede elimizde bir değer varsa save edilip kaldıgı yerden devam edecek
            tv.setText("sayac: "+say);
        }else {
            say=0;
            //eger uygulamaya girip hicbir sey yapmadan telefonu yan cevirip baslarsak say=0 dan baslayacak

        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                say++;
                tv.setText("sayac: "+say);
            }
        });



    }
}