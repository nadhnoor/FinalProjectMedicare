package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Description_Menu4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu4);

        ImageButton btBack4 = findViewById(R.id.back4);
        btBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back4 = new Intent(Description_Menu4.this, AMedicine_Menu.class);
                startActivity(back4);
            }
        });

    }
}