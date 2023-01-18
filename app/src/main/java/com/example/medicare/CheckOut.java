package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {

    TextView fullname,phone, harga, jumlah, total, jumlahharga, delivery, delivery1, notes;
    Button pay ;
    int ongkir = 10000;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        //GETTER-SETTER THE STRING DATA FROM DATABASE USER TO INPUT THE NAME USER
        Bundle bundle = getIntent().getExtras();
        fullname = findViewById(R.id.namareceiver);
        String user_name = Global.username;
        fullname.setText(user_name);

        phone = findViewById(R.id.no_receiver);
        String phone_number = Global.phone;
        phone.setText(phone_number);

        //jumlah barang
        jumlah = findViewById(R.id.jumlahbarang);
        String mcount = bundle.getString("jumlah");
        jumlah.setText(mcount);

        //jumlah harga per produk
        harga = findViewById(R.id.subproduk);
        String value = bundle.getString("harga");
        harga.setText(value);

        //total harga produk
        jumlahharga = findViewById(R.id.jumlahharga);
        String total_harga = bundle.getString("total");
        total.setText(total_harga);

        //ongkir
        delivery = findViewById(R.id.deliverypr);


        //totalsemua
        total = findViewById(R.id.totpay);
        total.setText(Integer.toString(Integer.parseInt(total_harga)+ ongkir));

        delivery1 = findViewById(R.id.delivery1);
        String total_semua = bundle.getString("total");
        delivery1.setText((total_semua));

        //Button Pay
        pay = findViewById(R.id.btPay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(CheckOut.this,PaymentSuccessful.class);
                startActivity(pay);
            }
        });

        //Notes
        notes = findViewById(R.id.notes1);
        String catatan = bundle.getString("notes");

    }
}