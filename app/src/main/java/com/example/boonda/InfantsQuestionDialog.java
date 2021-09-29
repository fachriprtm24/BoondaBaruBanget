package com.example.boonda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class InfantsQuestionDialog extends AppCompatDialogFragment {
    private EditText etQuestionTitle, etTitle;
    private TextView Topic, Name;
    private int like, Comment;
    DatabaseReference dbRef;
    Question question;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.card_question, null);
        View a = inflater.inflate(R.layout.activity_infants_discussion,null);
        question = new Question();
        Date date = Calendar.getInstance().getTime();
        String FormatedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        etTitle = v.findViewById(R.id.et_title);
        etQuestionTitle = v.findViewById(R.id.et_question_content);
        Topic = a.findViewById(R.id.InfantsTitle);


        builder.setView(v)
                .setTitle("Question")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("Discussion").child("Infants");
                        String title = etTitle.getText().toString();
                        String Quest = etQuestionTitle.getText().toString();
                        String topic = Topic.getText().toString();
                        HashMap<String,String> Question = new HashMap<>();
                        Question.put("Topic",topic);
                        Question.put("Question",Quest);
                        Question.put("Date",FormatedDate);
                        Question.put("Title",title);
                        dbRef.push().setValue(Question);

                        Toast.makeText(getActivity(), "Successfully Posted!", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
