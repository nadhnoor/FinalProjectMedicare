package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityHistory extends AppCompatActivity {

    ImageView imageView;
    TextView mjudul, mharga, mper;
    String xjudul = "judul";
    String xharga = "harga";
    String xper = "per";
    String gambar = "gambar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }
}