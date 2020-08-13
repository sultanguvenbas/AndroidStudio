package com.example.kart_oyunu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;
//import android.support.v7.widget.AppCompatDrawableManager;

import androidx.appcompat.widget.AppCompatDrawableManager;

public class kart extends androidx.appcompat.widget.AppCompatButton {
    boolean kart_acık = false;
    boolean cevrililebilir=true;
    int arkaPlanID;
    int onPlanID = 0;
    Drawable on;
    Drawable arka;

    public kart(Context context,int id) {
        super(context);
        setId(id);//buttonların id'ilerini burda değiştiriyorum
        arkaPlanID = R.drawable.backk; // arka plan id'sini aldık,


        if(id%8 ==1) // 1 ise veya 9 ise
            onPlanID =R.drawable.c1;
        if(id%8 ==2)
            onPlanID =R.drawable.c2;
        if(id%8 ==3)
            onPlanID =R.drawable.c3;
        if(id%8 ==4)
            onPlanID =R.drawable.c4;
        if(id%8 ==5)
            onPlanID =R.drawable.c5;
        if(id%8 ==6)
            onPlanID =R.drawable.c6;
        if(id%8 ==7)
            onPlanID =R.drawable.c7;
        if(id%8 ==0)
            onPlanID =R.drawable.c8;
        //System.out.println(onPlanID);
        arka = AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arka);
    }
    public void kartı_cevir(){
        if(!cevrililebilir){
            if(!kart_acık){//arkası cevrili ise
                setBackground(on);
                kart_acık=true;
            }else {
                setBackground(arka);
                kart_acık = false;
            }
        }
    }
}











