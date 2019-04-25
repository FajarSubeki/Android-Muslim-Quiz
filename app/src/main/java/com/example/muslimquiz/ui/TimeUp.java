package com.example.muslimquiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.holder_activity.QuranSlide;
import com.example.muslimquiz.ui.tab.QuranEasyTab;

public class TimeUp extends BaseActivity {

    Button lagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_up);

        init();
    }

    private void init()
    {
        lagi = findViewById(R.id.btn_main_lagi_up);
        lagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if (intent != null) {
                    Intent intent2 = new Intent(getApplicationContext(), QuranSlide.class);
                    intent2.putExtra("TabNo", 0);
                    startActivity(intent2);
                    finish();
                }
            }
        });
    }

}
