package com.example.w;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Main3Activity extends AppCompatActivity {
    WallpaperManager wallpaperManager;
    DisplayMetrics displayMetrics;
    Bitmap bitmap1,bitmap2;
    int width,height;
    BitmapDrawable bitmapDrawable;
    ImageView view, imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        button=(Button)findViewById(R.id.button);
        view=(ImageView)findViewById(R.id.imageView);
        Intent intent=getIntent();
        view.setImageResource(intent.getIntExtra("SOURCE ",0 ));

        wallpaperManager=WallpaperManager.getInstance(getApplicationContext()) ;
        bitmapDrawable=(BitmapDrawable)view.getDrawable();
        bitmap1=bitmapDrawable.getBitmap();
        GetScreenwidthHeight();
        setBitmapsize();
        wallpaperManager=WallpaperManager.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try
                {
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width,height);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


    }
    public void GetScreenwidthHeight()
    {
        displayMetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width=displayMetrics.widthPixels;
        height=displayMetrics.heightPixels;
    }
    public void setBitmapsize()
    {
        bitmap2=Bitmap.createScaledBitmap(bitmap1,width,height,false);
    }

}
