package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.hadist.MediumHadistHelper;
import com.example.muslimquiz.model.EasyQuranModel;

import java.util.Collections;
import java.util.List;

public class MainGameHadistMedium extends BaseActivity {

    CardView card_a, card_b, card_c, card_d;
    TextView questionText, triviaQuizText, timeText, resultText, coinText, tv_a, tv_b, tv_c, tv_d;
    int qid = 0;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    MediumHadistHelper mediumHadistHelper;
    EasyQuranModel easyQuranModel;
    List<EasyQuranModel> list;
    MediaPlayer player;
    int sum_coint, sum_waktu;
    int ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_hadist_medium);
        init();
    }

    private void init(){
        questionText = findViewById(R.id.tv_question_quran_easy);
        card_a = findViewById(R.id.card_a);
        card_b = findViewById(R.id.card_b);
        card_c = findViewById(R.id.card_c);
        card_d = findViewById(R.id.card_d);
        tv_a = findViewById(R.id.tv_a);
        tv_b = findViewById(R.id.tv_b);
        tv_c = findViewById(R.id.tv_c);
        tv_d = findViewById(R.id.tv_D);
        triviaQuizText = findViewById(R.id.triviaQuizTextMedium);
        timeText = findViewById(R.id.timeTextMediumQuran);
        resultText = findViewById(R.id.tv_result_text_medium_quran);
        coinText = findViewById(R.id.coinTextMediumQuran);

        //Our database
        mediumHadistHelper = new MediumHadistHelper(this);
        //make db writable
        mediumHadistHelper.getWritableDatabase();
        //It will check if the ques,options are already added in table or not
        //If they are not added then the getAllOfTheQuestions() will return a list of size zero
        if (mediumHadistHelper.getAllOfTheQuestions().size() == 0) {
            //If not added then add the ques,options in table
            mediumHadistHelper.allQuestion();
        }

        //This will return us a list of data type TriviaQuestion
        list = mediumHadistHelper.getAllOfTheQuestions();

        //Now we gonna shuffle the elements of the list so that we will get questions randomly
        Collections.shuffle(list);

        //currentQuestion will hold the que, 4 option and ans for particular id
        easyQuranModel = list.get(qid);

        //countDownTimer
        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                //here you can have your logic to set text to timeText
                ab =  20 - timeValue;
                String a = String.valueOf(ab);
                timeText.setText(a);

                //With each iteration decrement the time by 1 sec
                timeValue -= 1;

                //This means the user is out of time so onFinished will called after this iteration
                if (timeValue == -1) {

                    //Since user is out of time setText as time up
                    resultText.setText(getString(R.string.timeup));

                    //Since user is out of time he won't be able to click any buttons
                    //therefore we will disable all four options buttons using this method
                    disableButton();
                }
            }

            //Now user is out of time
            public void onFinish() {
                //We will navigate him to the time up activity using below method
                timeUp();
            }
        }.start();

        //This method will set the que and four options
        updateQueAndOptions();
    }

    public void timeUp(){
        startActivity(new Intent(getApplicationContext(), TimeUp.class));
        finish();
    }

    public void disableButton(){
        card_a.setEnabled(false);
        card_b.setEnabled(false);
        card_c.setEnabled(false);
        card_d.setEnabled(false);
    }

    public void enableButton(){
        card_a.setEnabled(true);
        card_b.setEnabled(true);
        card_c.setEnabled(true);
        card_d.setEnabled(true);
    }

    public void updateQueAndOptions() {

        //This method will setText for que and options
        questionText.setText(easyQuranModel.getQuestion());
        tv_a.setText(easyQuranModel.getOptA());
        tv_b.setText(easyQuranModel.getOptB());
        tv_c.setText(easyQuranModel.getOptC());
        tv_d.setText(easyQuranModel.getOptD());


        timeValue = 20;

        //Now since the user has ans correct just reset timer back for another que- by cancel and start
        countDownTimer.cancel();
        countDownTimer.start();

        //set the value of coin text
        coinText.setText(String.valueOf(coinValue));
        //Now since user has ans correct increment the coinvalue
        sum_coint = Integer.parseInt(String.valueOf(coinValue)) + 1;
        sum_waktu = Integer.parseInt(String.valueOf(ab)) + sum_waktu;
        Log.e("Total Point", String.valueOf(sum_coint));
        Log.e("Waktu", String.valueOf(sum_waktu));
        coinValue++;

    }

    public void cardA(View view){
        //compare the option with the ans if yes then make button color green
        if (easyQuranModel.getOptA().equals(easyQuranModel.getAnswer())) {
            //Check if user has not exceeds the que limit
            if (qid < list.size() - 1) {

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button

                disableButton();

                //Show the dialog that ans is correct
                correct();
                correctDialog();
            }
            //If user has exceeds the que limit just navigate him to GameWon activity
            else {

                gameWon();

            }
        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            gameLostPlayAgain();

        }
    }

    public void cardB(View view){
        //compare the option with the ans if yes then make button color green
        if (easyQuranModel.getOptB().equals(easyQuranModel.getAnswer())) {
            //Check if user has not exceeds the que limit
            if (qid < list.size() - 1) {

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button

                disableButton();

                //Show the dialog that ans is correct
                correct();
                correctDialog();
            }
            //If user has exceeds the que limit just navigate him to GameWon activity
            else {

                gameWon();

            }
        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            gameLostPlayAgain();

        }
    }

    public void cardC(View view){
        //compare the option with the ans if yes then make button color green
        if (easyQuranModel.getOptC().equals(easyQuranModel.getAnswer())) {
            //Check if user has not exceeds the que limit
            if (qid < list.size() - 1) {

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button

                disableButton();

                //Show the dialog that ans is correct
                correct();
                correctDialog();
            }
            //If user has exceeds the que limit just navigate him to GameWon activity
            else {

                gameWon();

            }
        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            gameLostPlayAgain();

        }
    }

    public void cardD(View view){
        //compare the option with the ans if yes then make button color green
        if (easyQuranModel.getOptD().equals(easyQuranModel.getAnswer())) {
            //Check if user has not exceeds the que limit
            if (qid < list.size() - 1) {

                //Now disable all the option button since user ans is correct so
                //user won't be able to press another option button after pressing one button

                disableButton();

                //Show the dialog that ans is correct
                correct();
                correctDialog();
            }
            //If user has exceeds the que limit just navigate him to GameWon activity
            else {

                gameWon();

            }
        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            gameLostPlayAgain();

        }
    }

    public void gameLostPlayAgain() {
        Intent intent = new Intent(getApplicationContext().getApplicationContext(), PlayAgain.class);
        intent.putExtra("MEDIUMHADIST", "Medium");
        startActivity(intent);
        finish();
    }

    public void gameWon() {
        int last_time = ab;
        int sum_time = sum_waktu + last_time;
        Intent intent = new Intent(getApplicationContext(), GameWon.class);
        String coint = String.valueOf(sum_coint);
        String waktu = String.valueOf(sum_time);
        intent.putExtra("SUMPOINT", coint);
        intent.putExtra("WAKTU", waktu);
        intent.putExtra("MEDIUMHADIST", "Medium");
        startActivity(intent);
        finish();
    }

    //This dialog is show to the user after he ans correct
    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(MainGameHadistMedium.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        //Since the dialog is show to user just pause the timer in background
        onPause();

        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);

        //OnCLick listener to go next que
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This will dismiss the dialog
                dialogCorrect.dismiss();
                //it will increment the question number
                qid++;
                //get the que and 4 option and store in the currentQuestion
                easyQuranModel = list.get(qid);
                //Now this method will set the new que and 4 options
                updateQueAndOptions();
                //Enable button - remember we had disable them when user ans was correct in there particular button methods
                enableButton();
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
        player = MediaPlayer.create(getApplicationContext(), R.raw.win);
        player.setLooping(false);
        player.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
