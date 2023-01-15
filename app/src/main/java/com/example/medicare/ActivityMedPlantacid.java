package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMedPlantacid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_plantacid);

        Button btn_backSrch9 = findViewById(R.id.btn_backSrch9);
        btn_backSrch9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMedPlantacid.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}