package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class artikel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        ImageButton backartikel=findViewById(R.id.btnBackArtikel);
        backartikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backartikel=new Intent(artikel.this,dashboard.class);
                startActivity(backartikel);
            }
        });
    }
}