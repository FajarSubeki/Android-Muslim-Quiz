package com.example.muslimquiz.ui.tab.Hadist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.example.muslimquiz.R;
import com.example.muslimquiz.adapter.HadistAdapter;
import com.example.muslimquiz.helper.HelperHadist;
import com.example.muslimquiz.ui.MainGameHardHadist;

import java.util.ArrayList;
import java.util.List;

public class HadistHardTab extends Fragment {

    GridView gridView;
    HelperHadist helper;
    BootstrapProgressBar progressBar;
    TextView progressText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_hadist_hard_tab, container, false);

        gridView = v.findViewById(R.id.gridview);
        progressBar = v.findViewById(R.id.progress_soal);
        progressText = v.findViewById(R.id.progressText);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper = new HelperHadist(getActivity().getApplicationContext());
        Integer imageView[] = new Integer[60];
        String s[] = new String[60];

        //Adding the images to Int array
        for (int i = 0; i < imageView.length; i++) {
            imageView[i] = R.drawable.transparent;
        }

        //Adding the text to String array
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(i + 1);
        }

        //setting the image correct for correct answer and adding value  into list
        List<Integer> list = new ArrayList<>();
        List xyz = helper.GetQid();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                int x = (Integer) xyz.get(i);
                if (x < 60) {
                    imageView[x] = R.drawable.correctcartoon;
                    list.add(1);
                }
            }
        }

        //setting the progress bar as per the size of list
        progressBar.setProgress(list.size());
        progressText.setText(list.size() + "/" + 60);
        list.clear();

        //setting adapter
        HadistAdapter adapter = new HadistAdapter(getActivity(), imageView, s);
        gridView.setAdapter(adapter);

        //OnClick Listner
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent intent = new Intent(getActivity().getApplicationContext(), MainGameHardHadist.class);
                intent.putExtra("Key", Integer.toString(position));
                startActivity(intent);
                getActivity().finish();
//                Toast.makeText(getActivity(), "" + position,
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
