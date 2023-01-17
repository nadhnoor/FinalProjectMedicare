package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu2 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu2);

        //Button Back
        ImageButton btBack2 = findViewById(R.id.back2);
        btBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back2 = new Intent(Description_Menu2.this, AMedicine_Menu.class);
                startActivity(back2);
            }
        });

        //put
        imageView = findViewById(R.id.pict_pn);
        judul = findViewById(R.id.panadol);
        harga = findViewById(R.id.harga2);
        per = findViewById(R.id.opt_pn);

        //Button Buy
        Button btBuy2 = findViewById((R.id.buy2));
        btBuy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu2.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_panadol);
                startActivity(intent);
            }
        });

    }
}