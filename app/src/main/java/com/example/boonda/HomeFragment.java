package com.example.boonda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {
    EditText etQuestion, etAnswer;
    Button btnTry;

    DatabaseReference dbRef;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        etQuestion = view.findViewById(R.id.et_title);
        etAnswer = view.findViewById(R.id.et_answer);
        btnTry = view.findViewById(R.id.btn_try);

        dbRef = FirebaseDatabase.getInstance().getReference().child("children");

        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
        return view;
    }

    private void insertData(){
        String questions = etQuestion.getText().toString();
        String answers = etAnswer.getText().toString();

//        Question question = new Question(questions, answers);
//
//        dbRef.push().setValue(question);
    }
}