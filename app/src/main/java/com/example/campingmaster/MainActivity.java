package com.example.campingmaster;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.campingmaster.adapter.ViewPager2Adapter;
import com.example.campingmaster.databinding.ActivityMainBinding;
import com.example.campingmaster.fragment.ChatFragment;
import com.example.campingmaster.fragment.InfoFragment;
import com.example.campingmaster.fragment.MainFragment;
import com.example.campingmaster.fragment.SearchFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewPager2Adapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initFragment();
        setViewPager();
    }

    private void initFragment() {
        Log.i("INFO","MainActivity -> initFragment()");
        MainFragment mainFragment = new MainFragment();
        SearchFragment searchFragment = new SearchFragment();
        ChatFragment chatFragment = new ChatFragment();
        InfoFragment infoFragment = new InfoFragment();

        pagerAdapter = new ViewPager2Adapter(this);
        pagerAdapter.addFragment(mainFragment)
                .addFragment(searchFragment)
                .addFragment(chatFragment)
                .addFragment(infoFragment);
    }

    private void setViewPager() {
        Log.i("INFO","MainActivity -> setViewPager()");
        binding.pager.setAdapter(pagerAdapter);
        binding.pager.setUserInputEnabled(false);
        binding.pager.setOffscreenPageLimit(pagerAdapter.getItemCount());

        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.menuTab.selectTab(binding.menuTab.getTabAt(position));
            }
        });

        binding.menuTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
