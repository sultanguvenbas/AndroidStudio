package com.example.kart_oyunu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.content.Intent;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class screen_2 extends AppCompatActivity {
    int sonKart=0;
    int skor=0;
    int hata=0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_2);


        Intent i = getIntent();
        final String alınan_mesaj = i.getStringExtra("mesaj");
        TextView tv = (TextView)findViewById(R.id.alınanmesaj);
        tv.setText(alınan_mesaj); // set ile yazdırıyoruz

        GridLayout g =(GridLayout)findViewById(R.id.gridlayout);

        kart kartlar[]=new kart[16];
        for(int j =1; j<=16; j++) {
            kartlar[j-1]=new kart(this,j); //1 den 16 kadar kartları tanımladık
            //diziler 0 dan baslar 16. elemana erişemediğim için -1 yapmayılıyız
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k=(kart)v;
                    k.kartı_cevir();
                    if(sonKart > 0){
                        final kart k2=(kart)findViewById(sonKart);

                        if(k2.onPlanID==k.onPlanID ){//kartlar eşlesti
                            k2.cevrililebilir=false;
                            k.cevrililebilir=false;
                            skor++;
                            TextView tv =(TextView)findViewById(R.id.skor);
                            tv.setText("Skorunuz: "+skor);
                            if(skor==8){
                                //oyun bitti
                                Intent i = new Intent(screen_2.this,screen_3.class);
                                i.putExtra("puan",hata);
                                i.putExtra("isim",alınan_mesaj);
                                startActivity(i);
                            }
                        }else{//kartlar eşleşmedi
                            Handler h =new Handler();//burada zamanlama yapıyorum
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.kartı_cevir();
                                    k2.kartı_cevir();

                                }
                            },500);
                            hata++;

                            TextView tv =(TextView)findViewById(R.id.hata);
                            tv.setText("Hatanız: "+skor);
                            sonKart=0;
                        }
                    }else{//ilk kez kart cevirince
                        sonKart=k.getId();
                    }
                }
            });
        }
        //kariştır
        for(int j=0; j<16;j++){
           int rg=(int)Math.random()*16;//1 ile 16 arasında random sayı alıyorum
            kart k = kartlar[rg]; //swap yapıyorum
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }
        for(int j =0; j<16; j++)
            g.addView(kartlar[j]);
    }
}