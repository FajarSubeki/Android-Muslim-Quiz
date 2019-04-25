package com.example.muslimquiz.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import com.example.muslimquiz.R;
import com.example.muslimquiz.adapter.ExpandListViewScoreAdapter;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.model.Continent;
import com.example.muslimquiz.model.Score;

import java.util.ArrayList;
public class HighScoreActivity extends BaseActivity {

    ExpandListViewScoreAdapter listAdapter;
    private ArrayList<Continent> continentList = new ArrayList<Continent>();
    ExpandableListView expListView;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        super.setUpActionBar("Papan Koin");
        //display the list
        displayList();
        //expand all Groups
        expandAll();
    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            expListView.expandGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        expListView = findViewById(R.id.extlist);
        //create the adapter by passing your ArrayList data
        listAdapter = new ExpandListViewScoreAdapter(HighScoreActivity.this, continentList);
        //attach the adapter to the list
        expListView.setAdapter(listAdapter);

    }

    private void loadSomeData() {

        //Quran
        ArrayList<Score> scoreList;
        Score score;
        scoreList = new ArrayList<Score>();

        //Hadist
        ArrayList<Score> scoreListHadist;
        Score scoreHadist;
        scoreListHadist = new ArrayList<Score>();

        //Sejarah
        ArrayList<Score> scoreListSejarah;
        Score scoreSejarah;
        scoreListSejarah = new ArrayList<Score>();

        //Sunah
        ArrayList<Score> scoreListSunah;
        Score scoreSunah;
        scoreListSunah = new ArrayList<Score>();

        //Tauhid
        ArrayList<Score> scoreListTauhid;
        Score scoreTauhid;
        scoreListTauhid = new ArrayList<Score>();

        //Fiqih
        ArrayList<Score> scoreListFiqih;
        Score scoreFiqh;
        scoreListFiqih = new ArrayList<Score>();

        prefManager = new PrefManager(this);

        //Quran
        String easy_quran = prefManager.getQuranEasy();
        String medium_quran = prefManager.getQuranMedium();
        String hard_quran = prefManager.getQuranHard();
        //Hadist
        String easy_hadist = prefManager.getHadistEasy();
        String medium_hadist = prefManager.getHadistMedium();
        String hard_hadist = prefManager.getHadistHard();
        //Sejarah
        String easy_sejarah = prefManager.getSejarahEasy();
        String medium_sejarah = prefManager.getSejarahMedium();
        String hard_sejarah = prefManager.getSejarahHard();
        //Sunah
        String easy_sunah = prefManager.getSunahEasy();
        String medium_sunah = prefManager.getSunahMedium();
        String hard_sunah = prefManager.getSunahHard();
        //Tauhid
        String easy_tauhid = prefManager.getTauhidEasy();
        String medium_tauhid = prefManager.getTauhidMedium();
        String hard_tauhid = prefManager.getTauhidHard();
        //Fiqih
        String easy_fiqih = prefManager.getFiqihEasy();
        String medium_fiqih = prefManager.getFiqihMedium();
        String hard_fiqih = prefManager.getFiqihHard();

        //QURAN
        if (easy_quran != null){
            score = new Score("Easy",easy_quran);
            scoreList.add(score);
        }else{
            score = new Score("Easy","0");
            scoreList.add(score);
        }

        if(medium_quran != null){
            score = new Score("Medium",medium_quran);
            scoreList.add(score);
        }else{
            score = new Score("Medium","0");
            scoreList.add(score);
        }

        if (hard_quran != null){
            score = new Score("Hard",hard_quran);
            scoreList.add(score);
        }else{
            score = new Score("Hard","0");
            scoreList.add(score);
        }
        Continent continent = new Continent("Tafsir Quran",scoreList);
        continentList.add(continent);

        //TAFSIR HADIST
        if (easy_hadist != null){
            scoreHadist = new Score("Easy",easy_hadist);
            scoreListHadist.add(scoreHadist);
        }else{
            scoreHadist = new Score("Easy","0");
            scoreListHadist.add(scoreHadist);
        }

        if(medium_hadist != null){
            scoreHadist = new Score("Medium",medium_hadist);
            scoreListHadist.add(scoreHadist);
        }else{
            scoreHadist = new Score("Medium","0");
            scoreListHadist.add(scoreHadist);
        }

        if (hard_hadist != null){
            scoreHadist = new Score("Hard",hard_hadist);
            scoreListHadist.add(scoreHadist);
        }else{
            scoreHadist = new Score("Hard","0");
            scoreListHadist.add(scoreHadist);
        }
        Continent continent_hadist = new Continent("Tafsir Hadist",scoreListHadist);
        continentList.add(continent_hadist);

        //SEJARAH
        if (easy_sejarah != null){
            scoreSejarah = new Score("Easy",easy_sejarah);
            scoreListSejarah.add(scoreSejarah);
        }else{
            scoreSejarah = new Score("Easy","0");
            scoreListSejarah.add(scoreSejarah);
        }

        if(medium_sejarah != null){
            scoreSejarah = new Score("Medium",medium_sejarah);
            scoreListSejarah.add(scoreSejarah);
        }else{
            scoreSejarah = new Score("Medium","0");
            scoreListSejarah.add(scoreSejarah);
        }

        if (hard_sejarah != null){
            scoreSejarah = new Score("Hard",hard_sejarah);
            scoreListSejarah.add(scoreSejarah);
        }else{
            scoreSejarah = new Score("Hard","0");
            scoreListSejarah.add(scoreSejarah);
        }
        Continent continent_sejarah = new Continent("Sejarah",scoreListSejarah);
        continentList.add(continent_sejarah);

        //SUNAH
        if (easy_sunah != null){
            scoreSunah = new Score("Easy",easy_sunah);
            scoreListSunah.add(scoreSunah);
        }else{
            scoreSunah = new Score("Easy","0");
            scoreListSunah.add(scoreSunah);
        }

        if(medium_sunah != null){
            scoreSunah = new Score("Medium",medium_sunah);
            scoreListSunah.add(scoreSunah);
        }else{
            scoreSunah = new Score("Medium","0");
            scoreListSunah.add(scoreSunah);
        }

        if (hard_sunah != null){
            scoreSunah = new Score("Hard",hard_sunah);
            scoreListSunah.add(scoreSunah);
        }else{
            scoreSunah = new Score("Hard","0");
            scoreListSunah.add(scoreSunah);
        }
        Continent continent_sunah = new Continent("Sunah",scoreListSunah);
        continentList.add(continent_sunah);

        //Tauhid
        if (easy_tauhid != null){
            scoreTauhid = new Score("Easy",easy_tauhid);
            scoreListTauhid.add(scoreTauhid);
        }else{
            scoreTauhid = new Score("Easy","0");
            scoreListTauhid.add(scoreTauhid);
        }

        if(medium_tauhid != null){
            scoreTauhid = new Score("Medium",medium_tauhid);
            scoreListTauhid.add(scoreTauhid);
        }else{
            scoreTauhid = new Score("Medium","0");
            scoreListTauhid.add(scoreTauhid);
        }

        if (hard_tauhid != null){
            scoreTauhid = new Score("Hard",hard_tauhid);
            scoreListTauhid.add(scoreTauhid);
        }else{
            scoreTauhid = new Score("Hard","0");
            scoreListTauhid.add(scoreTauhid);
        }
        Continent continent_tauhid = new Continent("Tauhid",scoreListTauhid);
        continentList.add(continent_tauhid);

        //Fiqih
        if (easy_fiqih != null){
            scoreFiqh = new Score("Easy",easy_fiqih);
            scoreListFiqih.add(scoreFiqh);
        }else{
            scoreFiqh = new Score("Easy","0");
            scoreListFiqih.add(scoreFiqh);
        }

        if(medium_fiqih != null){
            scoreFiqh = new Score("Medium",medium_fiqih);
            scoreListFiqih.add(scoreFiqh);
        }else{
            scoreFiqh = new Score("Medium","0");
            scoreListFiqih.add(scoreFiqh);
        }

        if (hard_fiqih != null){
            scoreFiqh = new Score("Hard",hard_fiqih);
            scoreListFiqih.add(scoreFiqh);
        }else{
            scoreFiqh = new Score("Hard","0");
            scoreListFiqih.add(scoreFiqh);
        }
        Continent continent_fiqih = new Continent("Fiqih",scoreListFiqih);
        continentList.add(continent_fiqih);

//        scoreList = new ArrayList<Score>();
//        score = new Score("Easy","50");
//        scoreList.add(score);
//        score = new Score("Medium","25");
//        scoreList.add(score);
//        score = new Score("Hard","15");
//        scoreList.add(score);
//        continent = new Continent("Sunah",scoreList);
//        continentList.add(continent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
