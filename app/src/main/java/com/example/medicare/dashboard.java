package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageButton userprofile=findViewById(R.id.btn_profile);
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userprofile= new Intent(dashboard.this,profile.class);
                startActivity(userprofile);
            }
        });
        ImageButton artikel=findViewById(R.id.btn_artikel);
        artikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artikel= new Intent(dashboard.this, com.example.medicare.artikel.class);
                startActivity(artikel);
            }
        });
        ImageButton userprofile2=findViewById(R.id.btn_profile2);
        userprofile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userprofile2= new Intent(dashboard.this,profile.class);
                startActivity(userprofile2);

            }
        });
    }
}