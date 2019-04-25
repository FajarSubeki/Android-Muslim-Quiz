package com.example.muslimquiz.ui.tab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.muslimquiz.R;
import com.example.muslimquiz.ui.MainGameActivity;

public class QuranEasyTab extends Fragment {

    Button main;

    public QuranEasyTab() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_quran_easy_tab, container, false);

        main = v.findViewById(R.id.play_button);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainGameActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }


}
