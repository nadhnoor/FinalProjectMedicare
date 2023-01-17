package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AMedicine_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amedicine_menu);

        //button
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AMedicine_Menu.this, dashboard.class);
                startActivity(back);
            }
        });

        Button btPct =findViewById(R.id.btParacetamol);
        btPct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paracetamol = new Intent(AMedicine_Menu.this, Description_Menu1.class);
                startActivity(paracetamol);
            }
        });


        Button btPnd =findViewById(R.id.btPanadol);
        btPnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent panadol = new Intent(AMedicine_Menu.this, Description_Menu2.class);
                startActivity(panadol);
            }
        });

        Button btObh =findViewById(R.id.btOBH);
        btObh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obh = new Intent(AMedicine_Menu.this, Description_Menu3.class);
                startActivity(obh);
            }
        });

        Button btKnd =findViewById(R.id.btKonidin);
        btKnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent konidin = new Intent(AMedicine_Menu.this, Description_Menu4.class);
                startActivity(konidin);
            }
        });

        Button btAntg =findViewById(R.id.btAntangin);
        btAntg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent antangin = new Intent(AMedicine_Menu.this, Description_Menu5.class);
                startActivity(antangin);
            }
        });

        Button btAmx =findViewById(R.id.btAmoxicilin);
        btAmx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent amoxicilin = new Intent(AMedicine_Menu.this, Description_Menu6.class);
                startActivity(amoxicilin);
            }
        });

    }
}