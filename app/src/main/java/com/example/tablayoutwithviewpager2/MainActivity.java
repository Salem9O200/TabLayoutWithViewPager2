package com.example.tablayoutwithviewpager2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tablayoutwithviewpager2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements SendMessageListener {

    ActivityMainBinding binding;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ViewPagerAdapter(this);
        binding.vPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabs, binding.vPager,
                (tab, position) -> {
                    if (position == 0) tab.setText("Send");
                    else tab.setText("Received");
                }).attach();
    }

    @Override
    public void sendData(String message) {
        ReceivedFragment fragment = (ReceivedFragment) adapter.getFragment(1);
        if (fragment != null) {
            fragment.displayReceivedData(message);
        }
        binding.vPager.setCurrentItem(1, true);
    }
}
