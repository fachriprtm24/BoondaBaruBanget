package com.example.boonda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ParentingActivity extends AppCompatActivity {
    Button btnAddQuestion;
    EditText etTitle, etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parenting_discussion);

        btnAddQuestion = findViewById(R.id.btn_add_question);
        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    private void openDialog(){
        ParentingQuestionDialog questionDialog = new ParentingQuestionDialog();
        questionDialog.show(getSupportFragmentManager(),"question dialog");
    }
}
