package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.helper.hadist.EasyHadistHelper;
import com.example.muslimquiz.model.EasyQuranModel;

import java.util.Collections;
import java.util.List;

public class MainGameHadistEasy extends AppCompatActivity {

    Button btna, btnb, btnc, btnd;
    TextView questionText, triviaQuizText, timeText, resultText, coinText;
    int qid = 0;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    EasyHadistHelper easyHadistHelper;
    EasyQuranModel easyQuranModel;
    List<EasyQuranModel> list;
    MediaPlayer player;
    int sum_coint, sum_waktu;
    int ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_hadist_easy);
        init();
    }

    private void init(){
        questionText = findViewById(R.id.tv_question_quran_easy);
        btna = findViewById(R.id.btn_a);
        btnb = findViewById(R.id.btn_b);
        btnc = findViewById(R.id.btn_c);
        btnd = findViewById(R.id.btn_d);
        triviaQuizText = findViewById(R.id.triviaQuizText);
        timeText = findViewById(R.id.timeText);
        resultText = findViewById(R.id.tv_result_text);
        coinText = findViewById(R.id.coinText);

        //Our database
        easyHadistHelper = new EasyHadistHelper(this);
        //make db writable
        easyHadistHelper.getWritableDatabase();
        //It will check if the ques,options are already added in table or not
        //If they are not added then the getAllOfTheQuestions() will return a list of size zero
        if (easyHadistHelper.getAllOfTheQuestions().size() == 0) {
            //If not added then add the ques,options in table
            easyHadistHelper.allQuestion();
        }

        //This will return us a list of data type TriviaQuestion
        list = easyHadistHelper.getAllOfTheQuestions();

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

    public void updateQueAndOptions() {

        //This method will setText for que and options
        questionText.setText(easyQuranModel.getQuestion());
        btna.setText(easyQuranModel.getOptA());
        btnb.setText(easyQuranModel.getOptB());
        btnc.setText(easyQuranModel.getOptC());
        btnd.setText(easyQuranModel.getOptD());


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

    //Onclick listener for first button
    public void buttonA(View view) {
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

    //Onclick listener for sec button
    public void buttonB(View view) {
        if (easyQuranModel.getOptB().equals(easyQuranModel.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correct();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void gameLostPlayAgain() {
        Intent intent = new Intent(getApplicationContext().getApplicationContext(), PlayAgain.class);
        intent.putExtra("EASYHADIST", "Easy");
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
        intent.putExtra("EASYHADIST", "Easy");
        startActivity(intent);
        finish();
    }

    //Onclick listener for third button
    public void buttonC(View view) {
        if (easyQuranModel.getOptC().equals(easyQuranModel.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correct();
                correctDialog();
            } else {
                gameWon();
            }
        } else {

            gameLostPlayAgain();
        }
    }

    //Onclick listener for fourth button
    public void buttonD(View view) {
        if (easyQuranModel.getOptD().equals(easyQuranModel.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correct();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void timeUp() {
        startActivity(new Intent(getApplicationContext(), TimeUp.class));
        finish();
    }

    public void disableButton(){
        btna.setEnabled(false);
        btnb.setEnabled(false);
        btnc.setEnabled(false);
        btnd.setEnabled(false);
    }

    public void enableButton(){
        btna.setEnabled(true);
        btnb.setEnabled(true);
        btnc.setEnabled(true);
        btnd.setEnabled(true);
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

    //This dialog is show to the user after he ans correct
    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(MainGameHadistEasy.this);
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
}
