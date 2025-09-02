package com.example.tablayoutwithviewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ReceivedFragment extends Fragment {

    private TextView tvView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_received, container, false);
        tvView = view.findViewById(R.id.tv_view);
        return view;
    }

    public void displayReceivedData(String message) {
        if (tvView != null) {
            tvView.setText(message);
        }
    }
}
