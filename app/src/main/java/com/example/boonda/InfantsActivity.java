package com.example.boonda;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InfantsActivity extends AppCompatActivity {
    Button btnAddQuestion;
    EditText etTitle, etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infants_discussion);

        btnAddQuestion = findViewById(R.id.btn_add_question);
        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    private void openDialog(){
        InfantsQuestionDialog questionDialog = new InfantsQuestionDialog();
        questionDialog.show(getSupportFragmentManager(),"question dialog");
    }



}
