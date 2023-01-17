package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu5 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per;

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

        //put
        imageView = findViewById(R.id.pict_ant);
        judul = findViewById(R.id.antangin);
        harga = findViewById(R.id.harga5);
        per = findViewById(R.id.opt_ant);

        //Button Buy
        Button btBuy5 = findViewById((R.id.buy5));
        btBuy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu5.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_antangin);
                startActivity(intent);
            }
        });
    }
}