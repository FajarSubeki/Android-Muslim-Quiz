package com.example.muslimquiz.ui.tab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.muslimquiz.R;
import com.example.muslimquiz.ui.MainGameMediumActivity;

public class QuranMediumTab extends Fragment {

    Button play;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_quran_medium_tab, container, false);

        play = v.findViewById(R.id.play_button_medium_quran);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainGameMediumActivity.class));
            }
        });

        return v;
    }
}
