package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu6 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per, hasil;

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

        //put
        imageView = findViewById(R.id.pict_amx);
        judul = findViewById(R.id.amoxicilin);
        harga = findViewById(R.id.harga6);
        per = findViewById(R.id.opt_amx);

        //Button Buy
        Button btBuy5 = findViewById((R.id.buy6));
        btBuy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu6.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_amoxicilin);
                startActivity(intent);
            }
        });
    }
}