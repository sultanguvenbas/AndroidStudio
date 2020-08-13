package com.example.kart_oyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class screen_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_3);


        TextView tv =(TextView)findViewById(R.id.son);
        Intent i =getIntent();
        String isim = i.getStringExtra("isim");
        int skor = i.getIntExtra("puan",0);
        tv.setText("Tebrikler "+ isim + "\n"+skor + " hata ile kazandınız");
    }
}