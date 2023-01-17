package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Menu1 extends AppCompatActivity {
    ImageView imageView;
    TextView judul, harga, per,hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_menu1);

        //Button Back
        ImageButton btBack1 = findViewById(R.id.back1);
        btBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back1 = new Intent(Description_Menu1.this, AMedicine_Menu.class);
                startActivity(back1);
            }
        });

        //put
        imageView = findViewById(R.id.pict_pc);
        judul = findViewById(R.id.paracetamol);
        harga = findViewById(R.id.harga1);
        per = findViewById(R.id.opt_pc);

        //Button Buy
        Button btBuy1 = findViewById((R.id.buy1));
        btBuy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cjudul = judul.getText().toString();
                String charga = harga.getText().toString();
                String cper = per.getText().toString();
                Intent intent = new Intent(Description_Menu1.this,Cart.class);
                intent.putExtra("judul",cjudul);
                intent.putExtra("harga",charga);
                intent.putExtra("per",cper);
                intent.putExtra("gambar",R.drawable.ic_paracetamol);
                startActivity(intent);

            }
        });

    }
}