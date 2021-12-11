package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;
import io.grpc.Context;

public class MeasurementActivity extends AppCompatActivity {
    private TextView tvChildName;
    private CircleImageView circleImageView;
    private MeasurementActivity context = this;

    FirebaseAuth mAuth;
    DatabaseReference dbref;

    @StringRes
        private final int[] TAB_TITLES = new int[]{
                R.string.tab_text_1,
                R.string.tab_text_2,
                R.string.tab_text_3
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_measurement);

            context = this;

            mAuth = FirebaseAuth.getInstance();

            FirebaseUser userr = mAuth.getCurrentUser();
            String curr= userr.getEmail();
            curr = curr.replace("@", "").replace(".", "");

            dbref = FirebaseDatabase.getInstance().getReference().child(curr).child("children").child("Halim");


            Toolbar toolbar = findViewById(R.id.toolbar_mea);
            setSupportActionBar(toolbar);
            PagerAdapter pagerAdapter = new PagerAdapter(this);
            ViewPager2 viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(pagerAdapter);
            TabLayout tabs = findViewById(R.id.tab_layout);
            new TabLayoutMediator(tabs, viewPager, (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))).attach();
            if(getSupportActionBar() != null) {
                getSupportActionBar().setElevation(0);

            }

            circleImageView = findViewById(R.id.circleImageView);
            tvChildName = findViewById(R.id.tv_child_name);
            tvChildName.setOnClickListener(view1-> {
                Intent i = new Intent(this, SelectChildActivity.class);
                startActivity(i);
            });

            //nampilin nama anak tapi masih error

            dbref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String name = snapshot.child("childName").getValue().toString();
                    String image = snapshot.child("photoProfile").getValue(String.class);
                    tvChildName.setText(name);
                    Glide.with(context)
                            .load(image)
                            .apply(new RequestOptions().override(55,55))
                            .into(circleImageView);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

