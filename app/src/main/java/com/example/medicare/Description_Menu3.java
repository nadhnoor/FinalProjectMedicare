package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu3 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu3);

        ImageButton btBack3 = findViewById(R.id.back3);
        btBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back3 = new Intent(Description_Menu3.this, AMedicine_Menu.class);
                startActivity(back3);
            }
        });

        //put
        imageView = findViewById(R.id.pict_obh);
        judul = findViewById(R.id.obh);
        harga = findViewById(R.id.harga3);
        per = findViewById(R.id.opt_obh);

        //Button Buy
        Button btBuy3 = findViewById((R.id.buy3));
        btBuy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu3.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_obh);
                startActivity(intent);

            }
        });
    }
}