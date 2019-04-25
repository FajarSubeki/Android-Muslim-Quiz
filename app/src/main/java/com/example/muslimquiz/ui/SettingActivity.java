package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.Helper;
import com.example.muslimquiz.helper.PrefManager;
import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;

public class SettingActivity extends BaseActivity {

    Button reset, suara;
    Helper helper;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        helper = new Helper(this);
        super.setUpActionBar("Pengaturan");
        init();
    }

    void init(){

        prefManager = new PrefManager(this);
        reset = findViewById(R.id.btn_reset_koin);
        suara = findViewById(R.id.btn_suara);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warning();
            }
        });

        suara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void warning() {
        new iOSDialogBuilder(SettingActivity.this)
                .setTitle("Reset Koin ?")
                .setSubtitle("Dengan reset koin, semua koin anda akan terhapus")
                .setBoldPositiveLabel(true)
                .setCancelable(true)
                .setPositiveListener("Ya", new iOSDialogClickListener() {
                    @Override
                    public void onClick(iOSDialog dialog) {
                        PrefManager.clear(getBaseContext());
                        helper.deleteAllRecord();
                        prefManager.saveQuranEasy(getBaseContext(), null);
                        prefManager.saveQuranMedium(getBaseContext(), null);
                        prefManager.saveQuranHard(getBaseContext(), null);
                        prefManager.saveTotalKoin(getBaseContext(), null);
                        Toast.makeText(SettingActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), OtherMenuActivity.class));
                        startActivity(new Intent(getApplicationContext(), OtherMenuActivity.class));
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
}
