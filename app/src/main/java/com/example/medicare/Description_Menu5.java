package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Description_Menu5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu5);

        ImageButton btBack5 = findViewById(R.id.back5);
        btBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back5 = new Intent(Description_Menu5.this, AMedicine_Menu.class);
                startActivity(back5);
            }
        });

    }
}