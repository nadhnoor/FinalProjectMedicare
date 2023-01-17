package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    ImageView imageView;
    TextView mjudul, mharga, mper, mtotal, jumlahbrg, hasil;
    String xjudul = "judul";
    String xharga = "harga";
    String xper = "per";
    String gambar = "gambar";
    Button kurang, tambah;
    private int mCounter = 1;
    int ongkir = 10000;

    String judul,harga,per;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //  Button Back
        ImageButton btBack1 = findViewById(R.id.back1);
        btBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back1 = new Intent(Cart.this, Description_Menu1.class);
                startActivity(back1);
            }
        });

        //Button CheckOut
        Button checkout = findViewById(R.id.btCheckout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent check = new Intent(Cart.this, CheckOut.class);
                startActivity(check);
            }
        });

        imageView = findViewById(R.id.gambarmasuk);
        mjudul = findViewById(R.id.judul);
        mharga = findViewById(R.id.harga);
        mper = findViewById(R.id.per);
        mtotal = findViewById(R.id.delivery);

        Bundle bundle = getIntent().getExtras();
        judul = bundle.getString(xjudul);
        harga = bundle.getString(xharga);
        per = bundle.getString(xper);

        int tampilgambar = bundle.getInt(gambar);
        mjudul.setText(judul);
        mharga.setText(harga);
        mper.setText(per);
        imageView.setImageResource(tampilgambar);

        //total harga
        mtotal.setText(Integer.toString(mCounter*Integer.parseInt(harga) + ongkir));


        //tambah kurang
        tambah = findViewById(R.id.btn_tambah);
        kurang = findViewById(R.id.btn_kurang);
        jumlahbrg = findViewById(R.id.jumlah1);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter ++;
                jumlahbrg.setText(Integer.toString(mCounter));
                mtotal.setText(Integer.toString(mCounter*Integer.parseInt(harga) + ongkir));
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter --;
                if (mCounter < 1) {
                    mCounter=1;                 //nilai minimal
                }
                jumlahbrg.setText(Integer.toString(mCounter));
                mtotal.setText(Integer.toString(mCounter*Integer.parseInt(harga) + ongkir));

            }
        });
    }

}
