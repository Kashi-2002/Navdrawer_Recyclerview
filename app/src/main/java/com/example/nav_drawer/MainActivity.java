package com.example.nav_drawer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
RecyclerView recyclerView;
DrawerLayout drawerLayout;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        drawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);
        recyclerView.setHasFixedSize(true);

        String[] items= getResources().getStringArray(R.array.topics);

        for (String Item: items){
            arrayList.add(Item);
        }
        adapter= new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        drawerToggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}