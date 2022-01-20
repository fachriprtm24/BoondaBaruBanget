package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set Home Fragment default
//        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }
//    private boolean loadFragment(Fragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fl_fragment, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(getApplicationContext(), HomeFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;

            case R.id.discussion:
                startActivity(new Intent(getApplicationContext(), DiscussionFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;

            case R.id.growth:
                startActivity(new Intent(getApplicationContext(), GrowthFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
        }

        return false;
    }

    //    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment fragment = null;
//        switch (item.getItemId()){
//            case R.id.home:
//                fragment = new HomeFragment();
//                break;
////            case R.id.discussion:
////                fragment = new DiscussionFragment();
////                break;
//            case R.id.growth:
//                fragment = new GrowthFragment();
//                break;
//
//        }
//        return loadFragment(fragment);
//    }
    // exit from app in HomeFragment when press back button
    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId()==R.id.home){
            super.onBackPressed();
            finish();
        }
        else{
            bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }


}