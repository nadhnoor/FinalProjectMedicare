package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Description_Menu6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu6);

        ImageButton btBack6 = findViewById(R.id.back6);
        btBack6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back6 = new Intent(Description_Menu6.this,AMedicine_Menu.class);
                startActivity(back6);
            }
        });
    }
}