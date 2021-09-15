package com.example.boonda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MeasurementActivity extends AppCompatActivity {
    private CardView cvMeasurementMenu;
    private Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);

        btnAddData = findViewById(R.id.btn_add_data);

        cvMeasurementMenu = findViewById(R.id.cv_measurement_menu);
        cvMeasurementMenu.setOnClickListener(view1-> {
            Intent i = new Intent(this, SelectChildActivity.class);
            startActivity(i);
        });

    }
}