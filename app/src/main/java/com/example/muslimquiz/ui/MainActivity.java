package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.adapter.CategoryAdapter;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Category> categoryList;
    Toolbar toolbar;
    TextView sum_koin, nameuser;
    PrefManager prefManager;
    TextView watch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefManager = new PrefManager(this);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting){
            startActivity(new Intent(getApplicationContext(), OtherMenuActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(id);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;

                FrameLayout bottomSheet = d.findViewById(android.support.design.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // Do something with your dialog like setContentView() or whatever
        return dialog;
    }

    private void init()
    {
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        sum_koin = findViewById(R.id.tv_sum_koin_main);
        watch = findViewById(R.id.tv_tonton_video);
        nameuser = findViewById(R.id.tv_name_user);

        String get_name = prefManager.getFullName();
        if (get_name == null){
            nameuser.setText("Nama anda belum disetting");
            nameuser.setTextSize(15);
        }else{
            nameuser.setText(get_name);
        }

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseVideoCategory.class);
                startActivity(intent);
            }
        });

        //For get sum coint
        String quran_easy = prefManager.getQuranEasy();
        String quran_medium = prefManager.getQuranMedium();
        String quran_hard = prefManager.getQuranHard();
        String hadist_easy = prefManager.getHadistEasy();
        String hadist_medium = prefManager.getHadistMedium();
        String hadist_hard = prefManager.getHadistHard();

        int quran_easy_get = 0;
        int quran_medium_get = 0;
        int quran_hard_get = 0;
        int hadist_easy_get = 0;
        int hadist_medium_get = 0;
        int hadist_hard_get = 0;

        if (quran_easy != null){
            quran_easy_get = Integer.parseInt(quran_easy);
        }else{
            quran_easy_get = 0;
        }

        if (quran_medium != null){
            quran_medium_get = Integer.parseInt(quran_medium);
        }else{
            quran_medium_get = 0;
        }

        if (quran_hard != null){
            quran_hard_get = Integer.parseInt(quran_hard);
        }else{
            quran_hard_get = 0;
        }

        //Hadist
        if (hadist_easy != null){
            hadist_easy_get = Integer.parseInt(hadist_easy);
        }else{
            hadist_easy_get = 0;
        }

        if (hadist_medium != null){
            hadist_medium_get = Integer.parseInt(hadist_medium);
        }else{
            hadist_medium_get = 0;
        }

        if (hadist_hard != null){
            hadist_hard_get = Integer.parseInt(hadist_hard);
        }else{
            hadist_hard_get = 0;
        }

        if (getIntent().getStringExtra("Key") != null){
            Log.e("Dari", getIntent().getStringExtra("Key"));
            String totalkoin = prefManager.getTotalKoin();
            sum_koin.setText(String.valueOf(totalkoin) + " Koin");
        }

        if (getIntent().getStringExtra("KeyMain") != null){
            Log.e("Dari", getIntent().getStringExtra("KeyMain"));
            int sum_koin_ =
                    quran_easy_get + quran_medium_get + quran_hard_get +
                            hadist_easy_get + hadist_medium_get + hadist_hard_get;
            prefManager.saveTotalKoin(getApplicationContext(), String.valueOf(sum_koin_));
        }

        if(prefManager.getTotalKoin() == null){
            sum_koin.setText("0 Koin");
        }else if(getIntent().getStringExtra("") == null){
            String totalkoin = prefManager.getTotalKoin();
            sum_koin.setText(String.valueOf(totalkoin) + " Koin");
        }

        recyclerView = findViewById(R.id.recycle_main);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        categoryList = new ArrayList<>();

        categoryList.add(new Category(R.drawable.quran2, "Tafsir Quran"));
        categoryList.add(new Category(R.drawable.quran, "Tafsir Hadist"));
        categoryList.add(new Category(R.drawable.sejarah, "Sejarah"));
        categoryList.add(new Category(R.drawable.sunah, "Sunah"));
        categoryList.add(new Category(R.drawable.tauhidd, "Tauhid"));
        categoryList.add(new Category(R.drawable.mosque, "Fiqih"));

        mAdapter = new CategoryAdapter(getApplicationContext(), categoryList);
        recyclerView.setAdapter(mAdapter);
    }

}
