package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMedAmbroxol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_ambroxol);

        Button btn_backSrch2 = findViewById(R.id.btn_backSrch2);
        btn_backSrch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMedAmbroxol.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}