package com.example.aboutme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.aboutme.databinding.ActivitySettingBinding;

import java.util.ArrayList;
import java.util.List;

public class Setting extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySettingBinding binding;
     EditText name,Email,url_image;
     Button btn;
     String name_s,Email_st,url_img_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   SharedPreferences preferences=getSharedPreferences("sharedFile",MODE_PRIVATE);
       // SharedPreferences.Editor editor= preferences.edit();
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name=findViewById(R.id.name_setting);
        Email=findViewById(R.id.email_setting);
        url_image=findViewById(R.id.URL_image);
        btn=findViewById(R.id.save_btn);
        SharedPreferences preferences=getSharedPreferences("sharedFile",MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_s=name.getText().toString();
                Email_st=Email.getText().toString();
                url_img_s=url_image.getText().toString();
                if(!name_s.matches("")){
                    editor.putString("Name",name.getText().toString());
                    editor.apply();
                    Log.i("msg","occur");
                }
                if(!Email_st.matches("")){
                    editor.putString("E-mail",Email.getText().toString());
                    editor.apply();
                }
                if(!url_img_s.matches("")){
                    editor.putString("url",url_img_s);
                    editor.apply();
                    Log.i("msg","apply");}

                Intent intent=new Intent(Setting.this,MainActivity.class);
                Toast.makeText(Setting.this, "Successfull Done", Toast.LENGTH_SHORT).show();
                startActivity(intent);}


        });
        //shared preference


        //creating Editor

        setSupportActionBar(binding.toolbar);

       /* NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_setting);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

  /*  @Override
    public boolean onSupportNavigateUp() {
     //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_setting);
    //    return NavigationUI.navigateUp(navController, appBarConfiguration)
      //          || super.onSupportNavigateUp();
    }*/
}