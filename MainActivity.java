package com.example.w;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] name = { "NATURE" , "SPACE","PETS","DARK","ALIEN","CARS"};
    int[] types = {R.drawable.d, R.drawable.s1, R.drawable.p1, R.drawable.d1, R.drawable.logo1,R.drawable.c1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.listview);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", name[i] );
            hashMap.put("image", types[i]+"");
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.text, R.id.image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_view, from, to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("NAME",name[position]);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), name[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
