package com.example.boonda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectChildActivity extends AppCompatActivity {
    Button btnAddChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_child);

        btnAddChild = findViewById(R.id.btn_add_child);
        btnAddChild.setOnClickListener(view1-> {
            Intent i = new Intent(this, AddChildDataActivity.class);
            startActivity(i);
        });

    }
}