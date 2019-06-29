package com.example.w;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    int [] logos={R.drawable.logo1,R.drawable.logo2,R.drawable.logo3,R.drawable.logo4,R.drawable.logo5,R.drawable.logo10,R.drawable.logo11,R.drawable.logo12,R.drawable.logo13};
    int[] dark={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5};
    int[] nature={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    int[] s={R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4};
    int[] p={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5};
    int[] c={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5};
    int[] array={};
    GridView gridView;
    String[] name = { "NATURE" , "SPACE","PETS","DARK","ALIEN","CARS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gridView=(GridView)findViewById(R.id.gridview);
        Intent intent=getIntent();

        String name=intent.getStringExtra("NAME");
        switch (name)
        {
            case "NATURE":
                array=nature;

                break;
            case "SPACE":
                array=s;
                    break;
            case "PETS":
                array=p;
                break;
            case "DARK":
                array=dark;
                break;
            case "CARS":
                array=c;
                break;
            case "ALIEN":
                array=logos;
                break;
        }
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),array);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("SOURCE ", array[position]);
                startActivity(intent);
            }
        });

    }
}
