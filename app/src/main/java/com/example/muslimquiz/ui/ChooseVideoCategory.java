package com.example.muslimquiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.adapter.VideoCategoryAdapter;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.model.VideoCategory;

import java.util.ArrayList;
import java.util.List;

public class ChooseVideoCategory extends BaseActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<VideoCategory> videoCategories;
    TextView point;
    PrefManager prefManager;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_video_category);
        init();
    }

    void init(){
        prefManager = new PrefManager(this);
        point = findViewById(R.id.tv_point_category);
        recyclerView = findViewById(R.id.rela_video_category);
        back = findViewById(R.id.iv_backcategory);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Key" , "Category");
                startActivity(intent);
            }
        });

        String totalkoin = prefManager.getTotalKoin();
        if (totalkoin == null){
            point.setText("0");
        }else {
            point.setText(totalkoin);
        }
        videoCategories = new ArrayList<>();
        videoCategories.add(new VideoCategory("Ngaji", "100"));
        videoCategories.add(new VideoCategory("Rezeki", "750"));
        videoCategories.add(new VideoCategory("Shalat", "2000"));
        videoCategories.add(new VideoCategory("Jodoh", "1000"));
        videoCategories.add(new VideoCategory("Kisah", "750"));
        videoCategories.add(new VideoCategory("Shalawat", "2500"));

        mAdapter = new VideoCategoryAdapter(getApplicationContext(), videoCategories);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("Key" , "Category");
        startActivity(intent);
    }
}
