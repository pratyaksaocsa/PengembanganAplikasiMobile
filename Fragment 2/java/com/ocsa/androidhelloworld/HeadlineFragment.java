package com.ocsa.androidhelloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HeadlineFragment extends Fragment {

    public interface OnHeadlineButtonClickListener {
        void onBeritaClicked();
    }

    public interface OnHeadlineButton2ClickListener {
        void onBerita2Clicked();
    }

    private OnHeadlineButtonClickListener listener;
    private OnHeadlineButton2ClickListener listener2;

    public void setOnHeadlineButtonClickListener(OnHeadlineButtonClickListener listener) {
        this.listener = listener;
    }

    public void setOnHeadlineButton2ClickListener(OnHeadlineButton2ClickListener listener) {
        this.listener2 = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.headline_view, container, false);
        btnBerita = view.findViewById(R.id.btnBerita);
        btnBerita2 = view.findViewById(R.id.btnBerita2);
        btnBerita.setOnClickListener(v -> {
            if (listener != null) listener.onBeritaClicked();
        });
        btnBerita2.setOnClickListener(v -> {
            if (listener2 != null) listener2.onBerita2Clicked();
        });
        return view;
    }

    private Button btnBerita, btnBerita2;

    public Button getButtonBerita() {
        return btnBerita;
    }

    public Button getButtonBerita2() {
        return btnBerita2;
    }
}
