package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu4 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per, hasil;

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

        //put
        imageView = findViewById(R.id.pict_knd);
        judul = findViewById(R.id.konidin);
        harga = findViewById(R.id.harga4);
        per = findViewById(R.id.opt_knd);

        //Button Buy
        Button btBuy4 = findViewById((R.id.buy4));
        btBuy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu4.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_konidin);
                startActivity(intent);

            }
        });

    }
}