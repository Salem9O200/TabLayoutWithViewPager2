package com.example.tablayoutwithviewpager2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SendFragment extends Fragment {

    private SendMessageListener listener;
    private EditText edtSend;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (SendMessageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement SendMessageListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send, container, false);

        edtSend = view.findViewById(R.id.edt_send);
        Button btnPass = view.findViewById(R.id.btn_pass);

        btnPass.setOnClickListener(v -> {
            String message = edtSend.getText().toString();
            if (!message.isEmpty()) {
                listener.sendData(message);
            } else {
                Toast.makeText(getContext(), "Type a message", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
