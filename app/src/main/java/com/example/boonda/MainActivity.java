package com.example.boonda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set Home Fragment default
        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.discussion:
                fragment = new DiscussionFragment();
                break;
            case R.id.growth:
                fragment = new GrowthFragment();
                break;
//            case R.id.account_menu:
//                fragment = new AccountFragment();
//                break;
        }
        return loadFragment(fragment);
    }
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

//    public void setTab(){
////        Toolbar toolbar = findViewById(R.id.toolbar_mea);
////        setSupportActionBar(toolbar);
//        final TabLayout tabLayout = findViewById(R.id.tab_layout);
//        final ViewPager viewPager = findViewById(R.id.pager);
//
//        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//        viewPager.setAdapter(pagerAdapter);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //Dipanggil ketika tab memasuki state/keadaan yang dipilih.
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                //Dipanggil saat tab keluar dari keadaan yang dipilih.
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                //Dipanggil ketika tab yang sudah dipilih, dipilih lagi oleh user.
//            }
//        });    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }

//    public void setActionBar(String title) {
//        //set title
//        getSupportActionBar().setTitle(title);
//        //using custom toolbar
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
//        //draw toolbar background
//        ColorDrawable color = new ColorDrawable(WHITE);
//        getSupportActionBar().setBackgroundDrawable(color);
//        //back button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//    }

// /    public void questionDialog() {
// /       QuestionDialog questionDialog = new QuestionDialog();
// /       questionDialog.show(getSupportFragmentManager(), "question dialog");
// /   }

    //buat tab layout, tp masih error
//    public void setToolbar(){
//        final TabLayout tabLayout = findViewById(R.id.tab_layout);
//        final ViewPager viewPager = findViewById(R.id.pager);
//
//        //Memanggil dan Memasukan Value pada Class PagerAdapter(FragmentManager dan JumlahTab)
//        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()) {
//            @Override
//            public int getCount() {
//                return 0;
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
//                return false;
//            }
//        };
//
//        //Memasang Adapter pada ViewPager
//        viewPager.setAdapter(pagerAdapter);
//
//        /*
//         Menambahkan Listener yang akan dipanggil kapan pun halaman berubah atau
//         bergulir secara bertahap, sehingga posisi tab tetap singkron
//         */
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        //Callback Interface dipanggil saat status pilihan tab berubah.
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //Dipanggil ketika tab memasuki state/keadaan yang dipilih.
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                //Dipanggil saat tab keluar dari keadaan yang dipilih.
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                //Dipanggil ketika tab yang sudah dipilih, dipilih lagi oleh user.
//            }
//        });
//    }
}