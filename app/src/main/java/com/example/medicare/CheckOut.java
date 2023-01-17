package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {


    TextView fullname;
    TextView phone;
    TextView harga;
    TextView jumlah;
    TextView total;

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

/*        jumlah = findViewById(R.id.jumlah);
        String mcount = bundle.getString("jumlah");
        jumlah.setText(mcount);

        harga = findViewById(R.id.harga);
        String value = bundle.getString("harga");
        harga.setText(value);

        total = findViewById(R.id.total);
        String total_harga = bundle.getString("total");
        total.setText(total);*/
    }
}