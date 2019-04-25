package com.example.muslimquiz.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.holder_activity.HadistSlide;
import com.example.muslimquiz.holder_activity.QuranSlide;
import com.example.muslimquiz.ui.tab.QuranEasyTab;

public class PlayAgain extends BaseActivity {

    MediaPlayer player;
    Button lagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);
        correct();
        init();
    }

    private void init(){
        lagi = findViewById(R.id.btn_main_lagi);
        lagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if (getIntent().getStringExtra("EASYQURAN") != null){
                    if (intent != null) {
                        Intent intent2 = new Intent(getApplicationContext(), QuranSlide.class);
                        intent2.putExtra("TabNo", 0);
                        startActivity(intent2);
                        finish();
                    }
                }else if(getIntent().getStringExtra("MEDIUMQURAN") != null){
                    if (intent != null) {
                        Intent intent2 = new Intent(getApplicationContext(), QuranSlide.class);
                        intent2.putExtra("TabNo", 1);
                        startActivity(intent2);
                        finish();
                    }
                }else if(getIntent().getStringExtra("EASYHADIST") != null){
                    if (intent != null) {
                        Intent intent2 = new Intent(getApplicationContext(), HadistSlide.class);
                        intent2.putExtra("TabNo", 0);
                        startActivity(intent2);
                        finish();
                    }
                }else if(getIntent().getStringExtra("MEDIUMHADIST") != null){
                    if (intent != null) {
                        Intent intent2 = new Intent(getApplicationContext(), HadistSlide.class);
                        intent2.putExtra("TabNo", 1);
                        startActivity(intent2);
                        finish();
                    }
                }
            }
        });
    }

    public void correct(){
        try{
            if(player.isPlaying()){
                player.release();
                player.stop();
            }
        }catch (Exception e){

        }
        player = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        player.setLooping(false);
        player.start();
    }

}
