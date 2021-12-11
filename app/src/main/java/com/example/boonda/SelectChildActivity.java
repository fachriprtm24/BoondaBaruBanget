package com.example.boonda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class SelectChildActivity extends AppCompatActivity {
    Button btnAddChild;
    ArrayList<SelectChildModel> list;
    RecyclerView recview;
    SelectChildAdapter adapter;

    FirebaseAuth mAuth;
    StorageReference mStorage;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_child);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser userr = mAuth.getCurrentUser();
        String curr= userr.getEmail();
        curr = curr.replace("@", "").replace(".", "");

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //button ke addchildren
        btnAddChild = findViewById(R.id.btn_add_child);
        btnAddChild.setOnClickListener(view1-> {
            Intent i = new Intent(this, AddChildDataActivity.class);
            startActivity(i);
        });

        //nampilin data di recycler view
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        recview = findViewById(R.id.rv_child);
        recview.setHasFixedSize(true);
        recview.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        dbref = FirebaseDatabase.getInstance().getReference().child(curr).child("children");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    SelectChildModel selectChildModel = postSnapshot.getValue(SelectChildModel.class);
                    list.add(selectChildModel);
                }
                adapter = new SelectChildAdapter(SelectChildActivity.this, list);
                recview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SelectChildActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}