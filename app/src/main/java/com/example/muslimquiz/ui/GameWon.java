package com.example.muslimquiz.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.holder_activity.HadistSlide;
import com.example.muslimquiz.holder_activity.QuranSlide;
import com.example.muslimquiz.ui.tab.QuranEasyTab;

public class GameWon extends AppCompatActivity {

    TextView jumlah_soal, jumlah_koin, waktu, klasifikasi;
    String koin, waktu_;
    MediaPlayer player;
    ImageView img1, img2, img3;
    Button kembali;
    int sumkoin;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);

        won();
        init();
    }

    private void init(){
        prefManager = new PrefManager(this);
        jumlah_soal = findViewById(R.id.tv_jumlah_soal);
        jumlah_koin = findViewById(R.id.tv_jumlah_point);
        waktu = findViewById(R.id.tv_waktu);
        klasifikasi = findViewById(R.id.tv_klasifikasi);
        img1 = findViewById(R.id.iv_1);
        img2 = findViewById(R.id.iv_2);
        img3 = findViewById(R.id.iv_3);
        kembali = findViewById(R.id.btn_kembali_dashboard);

        koin = getIntent().getStringExtra("SUMPOINT");
        waktu_ = getIntent().getStringExtra("WAKTU");

        //Save to pref manager
        String checkPoint = String.valueOf(prefManager.getQuranEasy());
        String checkPointMedium = String.valueOf(prefManager.getQuranMedium());
        String checkPointEasyHadist = String.valueOf(prefManager.getHadistEasy());
        String checkPointMediumHadist = String.valueOf(prefManager.getHadistMedium());

        if (getIntent().getStringExtra("EASYQURAN") != null){
            int waktu_int = Integer.parseInt(waktu_);
            if (waktu_int < 30){
                klasifikasi.setText("Quizzer Briliant");
                sumkoin = Integer.parseInt(koin) + 20;
                jumlah_koin.setText(String.valueOf(sumkoin));
                allImage();
            }else if(waktu_int < 60){
                klasifikasi.setText("Quizzer diatas rata-rata");
                sumkoin = Integer.parseInt(koin) + 10;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 95){
                klasifikasi.setText("Medium Quizzer");
                sumkoin = Integer.parseInt(koin) + 5;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 125){
                klasifikasi.setText("Perlu Peningkatan");
                jumlah_koin.setText(koin);
                oneImage();
            }
            jumlah_soal.setText(koin);
            waktu.setText(waktu_ + " / 125 detik");
            Log.e("Poin saat ini", checkPoint);
            String koin_ = (String.valueOf(sumkoin));
            if (checkPoint == "null"){
                prefManager.saveQuranEasy(getBaseContext(), String.valueOf(sumkoin));
            }else if(checkPoint != null){
                int point_uddate = Integer.parseInt(checkPoint) + Integer.parseInt(koin_);
                Log.e("Jumlah", String.valueOf(point_uddate));
                prefManager.saveQuranEasy(getBaseContext(), String.valueOf(point_uddate));
            }
        }

        if(getIntent().getStringExtra("MEDIUMQURAN") != null){
            int waktu_int = Integer.parseInt(waktu_);
            if (waktu_int < 30){
                klasifikasi.setText("Quizzer Briliant");
                sumkoin = Integer.parseInt(koin) + 30;
                jumlah_koin.setText(String.valueOf(sumkoin));
                allImage();
            }else if(waktu_int < 60){
                klasifikasi.setText("Quizzer diatas rata-rata");
                sumkoin = Integer.parseInt(koin) + 20;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 95){
                klasifikasi.setText("Medium Quizzer");
                sumkoin = Integer.parseInt(koin) + 10;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 125){
                klasifikasi.setText("Perlu Peningkatan");
                jumlah_koin.setText(koin);
                oneImage();
            }
            jumlah_soal.setText(koin);
            waktu.setText(waktu_ + " / 125 detik");
            Log.e("Poin saat ini", checkPointMedium);
            String koin_ = (String.valueOf(sumkoin));
            if (checkPointMedium == "null"){
                prefManager.saveQuranMedium(getBaseContext(), String.valueOf(sumkoin));
            }else if(checkPointMedium != null){
                int point_uddate = Integer.parseInt(checkPointMedium) + Integer.parseInt(koin_);
                Log.e("Jumlah", String.valueOf(point_uddate));
                prefManager.saveQuranMedium(getBaseContext(), String.valueOf(point_uddate));
            }
        }

        //HADIST
        if (getIntent().getStringExtra("EASYHADIST") != null){
            int waktu_int = Integer.parseInt(waktu_);
            if (waktu_int < 30){
                klasifikasi.setText("Quizzer Briliant");
                sumkoin = Integer.parseInt(koin) + 20;
                jumlah_koin.setText(String.valueOf(sumkoin));
                allImage();
            }else if(waktu_int < 60){
                klasifikasi.setText("Quizzer diatas rata-rata");
                sumkoin = Integer.parseInt(koin) + 10;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 95){
                klasifikasi.setText("Medium Quizzer");
                sumkoin = Integer.parseInt(koin) + 5;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 125){
                klasifikasi.setText("Perlu Peningkatan");
                jumlah_koin.setText(koin);
                oneImage();
            }
            jumlah_soal.setText(koin);
            waktu.setText(waktu_ + " / 125 detik");
            Log.e("Poin saat ini", checkPoint);
            String koin_ = (String.valueOf(sumkoin));
            if (checkPointEasyHadist == "null"){
                prefManager.saveHadistEasy(getBaseContext(), String.valueOf(sumkoin));
            }else if(checkPointEasyHadist != null){
                int point_uddate = Integer.parseInt(checkPointEasyHadist) + Integer.parseInt(koin_);
                Log.e("Jumlah", String.valueOf(point_uddate));
                prefManager.saveHadistEasy(getBaseContext(), String.valueOf(point_uddate));
            }
        }
        if(getIntent().getStringExtra("MEDIUMHADIST") != null){
            int waktu_int = Integer.parseInt(waktu_);
            if (waktu_int < 30){
                klasifikasi.setText("Quizzer Briliant");
                sumkoin = Integer.parseInt(koin) + 30;
                jumlah_koin.setText(String.valueOf(sumkoin));
                allImage();
            }else if(waktu_int < 60){
                klasifikasi.setText("Quizzer diatas rata-rata");
                sumkoin = Integer.parseInt(koin) + 20;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 95){
                klasifikasi.setText("Medium Quizzer");
                sumkoin = Integer.parseInt(koin) + 10;
                jumlah_koin.setText(String.valueOf(sumkoin));
                twoImage();
            }else if(waktu_int < 125){
                klasifikasi.setText("Perlu Peningkatan");
                jumlah_koin.setText(koin);
                oneImage();
            }
            jumlah_soal.setText(koin);
            waktu.setText(waktu_ + " / 125 detik");
            Log.e("Poin saat ini", checkPointMediumHadist);
            String koin_ = (String.valueOf(sumkoin));
            if (checkPointMediumHadist == "null"){
                prefManager.saveHadistMedium(getBaseContext(), String.valueOf(sumkoin));
            }else if(checkPointMediumHadist != null){
                int point_uddate = Integer.parseInt(checkPointMediumHadist) + Integer.parseInt(koin_);
                Log.e("Jumlah", String.valueOf(point_uddate));
                prefManager.saveHadistMedium(getBaseContext(), String.valueOf(point_uddate));
            }
        }

        kembali.setOnClickListener(new View.OnClickListener() {
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
                }else if (getIntent().getStringExtra("EASYHADIST") != null){
                    if (intent != null) {
                        Intent intent2 = new Intent(getApplicationContext(), HadistSlide.class);
                        intent2.putExtra("TabNo", 0);
                        startActivity(intent2);
                        finish();
                    }
                }else if (getIntent().getStringExtra("MEDIUMHADIST") != null){
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

    private void allImage(){
        img1.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
    }

    private void twoImage(){
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.GONE);
    }

    private void oneImage(){
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
    }

    public void won(){
        try{
            if(player.isPlaying()){
                player.release();
                player.stop();
            }
        }catch (Exception e){

        }
        player = MediaPlayer.create(getApplicationContext(), R.raw.finish);
        player.setLooping(false);
        player.start();
    }

}
