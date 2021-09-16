package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DiscussionFragment extends Fragment {

    ImageView ivInfants, ivPregnancy, ivEducation, ivBehaviour, ivToddlers, ivPreschool, ivParenting, ivTopic;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    RecyclerView recview;
    DiscussionAdapter adapter;

    public DiscussionFragment(){

    }

    public static DiscussionFragment newInstance(String param1, String param2){
        DiscussionFragment fragment = new DiscussionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discussion, container, false);

        ivInfants = view.findViewById(R.id.iv_infants);
        ivPregnancy = view.findViewById(R.id.iv_pregnancy);
        ivEducation = view.findViewById(R.id.iv_education);
        ivBehaviour = view.findViewById(R.id.iv_behavior);
        ivToddlers = view.findViewById(R.id.iv_toddlers);
        ivPreschool = view.findViewById(R.id.iv_preschool);
        ivParenting = view.findViewById(R.id.iv_parenting);
        ivTopic = view.findViewById(R.id.iv_topics);

        ivInfants.setOnClickListener(view1-> {
            moveIntent();
        });

        ivPregnancy.setOnClickListener(view1-> {
            moveIntent();
        });

        ivEducation.setOnClickListener(view1-> {
            moveIntent();
        });

        ivBehaviour.setOnClickListener(view1-> {
            moveIntent();
        });

        ivToddlers.setOnClickListener(view1-> {
            moveIntent();
        });

        ivPreschool.setOnClickListener(view1-> {
            moveIntent();
        });

        ivParenting.setOnClickListener(view1-> {
            moveIntent();
        });

        ivTopic.setOnClickListener(view1-> {
            moveIntent();
        });

//        recview = view.findViewById(R.id.rv_recent_discuss);
//        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        //test database connect to app
//        Log.d("testdatabase",FirebaseDatabase.getInstance().getReference("User").toString());

//        FirebaseRecyclerOptions<Model> options =
//                new FirebaseRecyclerOptions.Builder<Model>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("User"), Model.class)
//                        .build();
//
//        adapter = new DiscussionAdapter(options);
//        recview.setAdapter(adapter);

        return view;
    }

    public void moveIntent(){
        Intent i = new Intent(getActivity(), MenuDiscussActivity.class);
        startActivity(i);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }

    //    buat back button tp blum bisa
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()) {
//            case android.R.id.home:
//                getActivity().onBackPressed();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
