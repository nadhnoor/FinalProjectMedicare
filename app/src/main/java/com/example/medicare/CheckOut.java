package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {

    TextView fullname,phone, harga, jumlah, total, jumlahharga, delivery, delivery1, notes;
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

        jumlahharga = findViewById(R.id.jumlahharga);
        //total harga produk
        //jumlahharga.setText(Integer.toString(jumlah*Integer.parseInt(harga.setText(value))));

        delivery = findViewById(R.id.deliverypr);

        total = findViewById(R.id.totpay);
        String total_harga = bundle.getString("total");
        total.setText(total_harga);

        delivery1 = findViewById(R.id.delivery1);
        String total_semua = bundle.getString("total");
        delivery1.setText((total_semua));

    }
}