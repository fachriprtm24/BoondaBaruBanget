package com.example.boonda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class EducationQuestionDialog extends AppCompatDialogFragment {
    private EditText etTitle, etQuestionTitle;

    DatabaseReference dbRef;
    Question question;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.card_question, null);
        question = new Question();

//        etTitle = v.findViewById(R.id.et_title);
        etQuestionTitle = v.findViewById(R.id.et_question_content);


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
                        dbRef = FirebaseDatabase.getInstance().getReference().child("User").child("Discussion").child("Education");
//                        dbRef =  FirebaseDatabase.getInstance().getReference("Infants");

                        dbRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    int i = 0;
                                    i = (int)snapshot.getChildrenCount();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }
                        });
//                        question.setQuestion(etTitle.getText().toString());
                        question.setQuestionContent(etQuestionTitle.getText().toString());

                        dbRef.child(String.valueOf("q" + (i+1))).setValue(question);
                        Toast.makeText(getActivity(), "Successfully Posted!", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
