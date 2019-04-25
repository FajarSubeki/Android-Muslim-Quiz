package com.example.muslimquiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.model.Score;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;
import com.google.firebase.auth.FirebaseAuth;

public class OtherMenuActivity extends BaseActivity {

    TextView high_score, setting, sumkoin, keluar, name, profile;
    ImageView goback;
    PrefManager prefManager;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_menu);
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down);

        auth = FirebaseAuth.getInstance();
        prefManager = new PrefManager(this);
        init();
    }

    void init(){

        name = findViewById(R.id.tv_fullnameuser);
        keluar = findViewById(R.id.tv_keluar);
        setting = findViewById(R.id.tv_setting);
        high_score = findViewById(R.id.tv_high_score);
        goback = findViewById(R.id.iv_go_back);
        sumkoin = findViewById(R.id.tv_sum_koin);
        profile = findViewById(R.id.tv_profile);

        String get_name = prefManager.getFullName();
        if (get_name == null){
            name.setText("Nama anda belum disetting");
            name.setTextSize(18);
        }else{
            name.setText(prefManager.getFullName());
        }


        String totalkoin = prefManager.getTotalKoin();
        if (totalkoin == null){
            sumkoin.setText("0 Koin");
        }else{
            sumkoin.setText(totalkoin + " Koin");
        }

        high_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HighScoreActivity.class));
            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warning();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });
    }

    private void warning() {
        new iOSDialogBuilder(OtherMenuActivity.this)
                .setTitle("Keluar")
                .setSubtitle("Keluar dari akun anda")
                .setBoldPositiveLabel(true)
                .setCancelable(true)
                .setPositiveListener("Ya", new iOSDialogClickListener() {
                    @Override
                    public void onClick(iOSDialog dialog) {
                        auth.signOut();
                        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                    }
                })
                .setNegativeListener("Tidak", new iOSDialogClickListener() {
                    @Override
                    public void onClick(iOSDialog dialog) {
                        dialog.dismiss();
                    }
                }).build().show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
