package com.example.aboutme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView name_header, E_mail_header;
    NavigationView mNavigationView;
    String url;
    ImageView iv;
      //String font="15sp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ArrayList<Object> obj = new ArrayList<>();
           addElement(obj);

    //-------------------------------------------Adapter--------------------------------------------------//
        Adapter Recycler = new Adapter(this, obj);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager manger = new LinearLayoutManager(this);
        rv.setLayoutManager(manger);
        rv.setAdapter(Recycler);

     //--------------------------------------------Shared Perefernce--------------------------------------//
        SharedPreferences preferences = getSharedPreferences("sharedFile", MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        mNavigationView = findViewById(R.id.navigation_drawer);
        View header = mNavigationView.getHeaderView(0);
        name_header = header.findViewById(R.id.name_header);
        E_mail_header = header.findViewById(R.id.email_header);
        iv=header.findViewById(R.id.root);
        String name = preferences.getString("Name", "None");
        String E_mail = preferences.getString("E-mail", "None");
        String URL=preferences.getString("url","None");
        Log.i("msg",URL);
        name_header.setText(name);
        E_mail_header.setText(E_mail);
        Picasso.with(this).load(URL).into(iv);
        //-----------------------------------------------------Navigation _drawer -----------------------------------------------------------//
        NavigationView nv=(NavigationView)  findViewById(R.id.navigation_drawer);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.Home:
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.settings:
                        Intent intent1 = new Intent(MainActivity.this, Setting.class);
                        startActivity(intent1);
                        return true;
                    case R.id.Aboutme:
                        Intent intent2 = new Intent(MainActivity.this, About.class);
                        startActivity(intent2);
                    case R.id.shareapp:
                        Toast.makeText(MainActivity.this, "Share it please", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });
        nv.bringToFront();
    }
 public void  addElement( ArrayList<Object>obj){
     obj.add(new Object("c++",R.drawable.cpro));
     obj.add(new Object("java", R.drawable.java));
     obj.add(new Object("Kotlin", R.drawable.kotlin));
     obj.add(new Object("Python", R.drawable.python));
     obj.add(new Object("R", R.drawable.r));
     obj.add(new Object("sql", R.drawable.sql));
     obj.add(new Object("java_script", R.drawable.javascript));
     obj.add(new Object("Html",R.drawable.html));
     obj.add(new Object("css",R.drawable.css));
 }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_drawer, menu);
        return true;
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.settings:
                Intent intent1 = new Intent(this, Setting.class);
                startActivity(intent1);
                return true;
            case R.id.Aboutme:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
            case R.id.shareapp:
                Toast.makeText(this, "Share it please", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

}