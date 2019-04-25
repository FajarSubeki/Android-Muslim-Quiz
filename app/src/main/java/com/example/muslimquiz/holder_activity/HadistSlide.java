package com.example.muslimquiz.holder_activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.helper.Helper;
import com.example.muslimquiz.ui.MainActivity;
import com.example.muslimquiz.viewpager.PagerHadist;
import com.example.muslimquiz.viewpager.PagerQuran;

public class HadistSlide extends AppCompatActivity {

    int numboftabs = 3;
    public int icon[] = {R.drawable.star1, R.drawable.star2, R.drawable.star3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficultyent;
    TextView textViewDifficultyent, easyent, mediument, hardent;
    Helper demoHelperClass;
    ViewPager mPager;
    SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadist_slide);
        init();
    }

    private void init(){
        textViewDifficultyent = findViewById(R.id.textviewdifficultyent);
        easyent = findViewById(R.id.easyent);
        mediument = findViewById(R.id.mediument);
        hardent = findViewById(R.id.hardent);
        leftdifficultyent = findViewById(R.id.leftdifficultyent);

        demoHelperClass = new Helper(this);
        leftdifficultyent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new PagerHadist(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }

        mTabs = findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.custom_tablayout, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorCyan));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
        mTabs.setViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("KeyMain", "MainActivity");
        startActivity(intent);
        finish();
    }
}
