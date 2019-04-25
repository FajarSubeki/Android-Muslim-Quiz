package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.animate.MyBounceInterPolator;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.FreeHint;
import com.example.muslimquiz.helper.HelperHadist;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.holder_activity.HadistSlide;
import com.example.muslimquiz.model.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGameHardHadist extends BaseActivity {

    PrefManager prefManager;
    List<Questions> queList;
    boolean clicked = false;
    ImageView backButtonImage, leftImage, rightImage, FreeHint, correctImage, incorrect;
    HelperHadist demoHelperClass;
    Questions currentQ;
    int qid;
    TextView tvQ, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20;
    TextView tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b;

    Button tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29;
    Button tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b;
    StringBuffer stringBuffer = new StringBuffer(10);
    StringBuffer stringBuffer2 = new StringBuffer(10);
    TextView textView, textView2, tvt,
            queNum, diffLevel, solvedText, triviaKnowldegText;
    TextView gemsText;
    LinearLayout l1, l2;
    ArrayList list = new ArrayList();

    Toolbar toolbar;
    TextView textViewArrayAbove[] = new TextView[20];
    TextView textfirst[] = new TextView[10];
    TextView textsecound[] = new TextView[10];
    Button textViewArrayBelow[] = new Button[18];
    Button textViewBelowFirst[] = new Button[10];
    Button textViewBelowsecond[] = new Button[10];
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_hard_hadist);
        init();
    }

    void init(){

        prefManager = new PrefManager(this);
        incorrect = findViewById(R.id.incorrect);
        incorrect.setVisibility(View.INVISIBLE);
        tvQ = findViewById(R.id.textQuestion);
        tvt = findViewById(R.id.textviewpersonality);
        backButtonImage = findViewById(R.id.back_game);
        leftImage = findViewById(R.id.left_image);
        rightImage = findViewById(R.id.right_image);
        correctImage = findViewById(R.id.correctImage);
        correctImage.setVisibility(View.INVISIBLE);
        queNum = findViewById(R.id.questionNumber);
        toolbar = findViewById(R.id.toolbar_game_hard_quran);
        diffLevel = findViewById(R.id.difflevel);
        solvedText = findViewById(R.id.solvedText);
        FreeHint = findViewById(R.id.hint);
        FreeHint.setVisibility(View.VISIBLE);

        l1 = (LinearLayout) findViewById(R.id.layout1);
        l1.setVisibility(View.VISIBLE);
        l2 = (LinearLayout) findViewById(R.id.layout2);
        l2.setVisibility(View.VISIBLE);

        demoHelperClass = new HelperHadist(getApplicationContext());

        tv11 = findViewById(R.id.text11);
        tv12 = findViewById(R.id.text12);
        tv13 = findViewById(R.id.text13);
        tv14 = findViewById(R.id.text14);
        tv15 = findViewById(R.id.text15);
        tv16 = findViewById(R.id.text16);
        tv17 = findViewById(R.id.text17);
        tv18 = findViewById(R.id.text18);
        tv19 = findViewById(R.id.text19);
        tv20 = findViewById(R.id.text20);

        tv11b = findViewById(R.id.text11b);
        tv12b = findViewById(R.id.text12b);
        tv13b = findViewById(R.id.text13b);
        tv14b = findViewById(R.id.text14b);
        tv15b = findViewById(R.id.text15b);
        tv16b = findViewById(R.id.text16b);
        tv17b = findViewById(R.id.text17b);
        tv18b = findViewById(R.id.text18b);
        tv19b = findViewById(R.id.text19b);
        tv20b = findViewById(R.id.text20b);

        tv21 =  findViewById(R.id.text21);
        tv22 =  findViewById(R.id.text22);
        tv23 =  findViewById(R.id.text23);
        tv24 =  findViewById(R.id.text24);
        tv25 =  findViewById(R.id.text25);
        tv26 =  findViewById(R.id.text26);
        tv27 =  findViewById(R.id.text27);
        tv28 =  findViewById(R.id.text28);
        tv29 =  findViewById(R.id.text29);

        tv21b =  findViewById(R.id.text21b);
        tv22b =  findViewById(R.id.text22b);
        tv23b =  findViewById(R.id.text23b);
        tv24b =  findViewById(R.id.text24b);
        tv25b =  findViewById(R.id.text25b);
        tv26b =  findViewById(R.id.text26b);
        tv27b =  findViewById(R.id.text27b);
        tv28b =  findViewById(R.id.text28b);
        tv29b =  findViewById(R.id.text29b);

        //array is created here so that it will pass the value of this array to the global varable array so it can be used in other methods

        TextView textViewArrayAbove2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        TextView textfirst2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20};
        TextView textsecound2[] = {tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        Button textViewArrayBelow2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};
        Button textViewBelowFirst2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29};
        Button textViewBelowsecond2[] = {tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i] = textViewArrayAbove2[i];
        }

        for (int i = 0; i < 10; i++) {
            textfirst[i] = textfirst2[i];
            textsecound[i] = textsecound2[i];
        }

        for (int i = 0; i < 18; i++) {
            textViewArrayBelow[i] = textViewArrayBelow2[i];
        }
        for (int i = 0; i < 9; i++) {
            textViewBelowFirst[i] = textViewBelowFirst2[i];
            textViewBelowsecond[i] = textViewBelowsecond2[i];
        }

        textViewArrayAbove2 = null;
        textViewArrayBelow2 = null;
        textfirst2 = null;
        textsecound2 = null;
        textViewBelowFirst2 = null;
        textViewBelowsecond2 = null;

        demoHelperClass.getWritableDatabase();

        //Add the questions in the table if not added
        List checkQuestionAdded = demoHelperClass.getCheckQadded();
        if(checkQuestionAdded.size() == 0){
            Toast.makeText(getApplicationContext(),"called",Toast.LENGTH_LONG);
            demoHelperClass.addquestions();
            demoHelperClass.insertCheckQadded(1);
        }

        //It will give the question no as per users click from previous activity
        queList = demoHelperClass.getAllOfTheQuestions();
        Intent intent = getIntent();
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            //@@ 11
            for (int i = 0; i <= 1119; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    currentQ = queList.get(qid = i);
                    if (i == 1119) {
                        rightImage.setVisibility(View.INVISIBLE);
                    }
                    break;
                }
            }
        }

        //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
        //and also hide above and below boxes
        questionSolved();

        //This will set The Text of question and also setText for below boxes as per que no
        //and also manage spacing between boxes as per the size of the device
        viewData();

        //If id is 0 then left image is invisible
        if (qid == 0) {
            leftImage.setVisibility(View.INVISIBLE);
        }

        if(qid == 59){
            rightImage.setVisibility(View.INVISIBLE);
        }

        //If question is not solved and FreeHint(Hint1) is used then set the
        // random letters in ans boxes and remove from below
        if (returnQid() != qid) {
            if (returnFreeHintUsed() == qid) {

                //If FreeHint(Hint1) is used then make it invisible
                FreeHint.setVisibility(View.INVISIBLE);

                //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
                //fillingBoxes has method checkIfHintIsUsed
                fillingBoxes();
            }
        }


        //If question has solved setting the answer text
        if (returnQid() == qid) {
            for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
            }
            correctImage.setVisibility(View.VISIBLE);
        }
        if (returnQid() == qid) {
            for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());

            }
        }

        //It gives animation for each question
        allAnimation();

        //It will make left right visible or unvisible as per required
        visiblityOfrightleft();

        //It will set The text that the que is easy or hard or medium.
        //It will also set The color of the below boxes,bootstrap bar and left and right arrow
        diffLevel();

        //It will set The text of number of que solved
        setNoOfSolvedQueText();

        backButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if (intent != null) {
                    String clicked = intent.getStringExtra("Key");
                    for (int i = 0; i < 180; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), HadistSlide.class);
                            if (i < 60) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                }
            }
        });

        FreeHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainGameHardHadist.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                if (dialog.getWindow() != null) {
                    ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                    dialog.getWindow().setBackgroundDrawable(colorDrawable);
                }
                dialog.setContentView(R.layout.dialog_freehint);
                dialog.setCancelable(true);

                TextView freehintdialog = (TextView) dialog.findViewById(R.id.freehinttext);
                TextView reavel1 = (TextView) dialog.findViewById(R.id.reavel1);
                TextView reavel11 = (TextView) dialog.findViewById(R.id.reavel11);
                dialog.show();

                //dialog cancel button
                Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                //Dialog okButton
                Button okButton = (Button) dialog.findViewById(R.id.ok);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String ansOneAnsTwo = currentQ.getANSWER() + currentQ.getANSWER2();
                        Integer ansLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();

                        //If dialog_bomb has been used for the qid then don't do reqular hint1
                        //If current question is not solved and answer boxes is greater than 3 then only hint1 is visible and can use.

                        //FreeHint without boom
                        if (returnBoomIdUsed() != qid) {
                            if (returnQid() != qid && returnFreeHintUsed() != qid && currentQ.getANSWER().length() + currentQ.getANSWER2().length() > 3) {

                                //id of the question for which hint is used is stored in table
                                demoHelperClass.insertHint(qid);

                                //numberList is a ArrayList which will store random generated numbers
                                ArrayList<Integer> numbersList = new ArrayList<>();
                                Random randomGenerator = new Random();

                                //If answer length is greater than 5 then 5 random number will be stored in arraylist-numbersList
                                if (ansLength > 5) {
                                    while (numbersList.size() < 5) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater than 4 but less then 5 ie. 5 then 2 random number will be stored in arraylist-numbersList
                                else if (ansLength > 4) {
                                    while (numbersList.size() < 2) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater than 3 but less then 4 ie 3 then 1 random number will be stored in arraylist-numbersList
                                else if (ansLength > 3) {
                                    while (numbersList.size() < 1) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater then five then we gonna store 5 random no. generated in table
                                if (ansLength > 5) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), numbersList.get(1), numbersList.get(2), numbersList.get(3), numbersList.get(4));
                                }
                                //If answer length exactly 5 then we gonna store 2 random no. generated in table and rest of them will be zero
                                else if (ansLength > 4) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), numbersList.get(1), 0, 0, 0);
                                }
                                //If answer length exactly 4 then we gonna store 1 random no. generated in table and rest of them will be zero
                                else if (ansLength > 3) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), 0, 0, 0, 0);
                                }


                                //the alphabet of the random number are store int the string
                                String randomCharOne = "", randomeCharTwo = "", randomeCharThree = "", randomeCharFour = "", randomeCharFive = "";

                                //Now we gonna store the characters at that random no in the string
                                if (ansLength > 3) {
                                    randomCharOne = Character.toString(ansOneAnsTwo.charAt(numbersList.get(0))).toUpperCase();
                                }
                                if (ansLength > 4) {
                                    randomeCharTwo = Character.toString(ansOneAnsTwo.charAt(numbersList.get(1))).toUpperCase();
                                }
                                if (ansLength > 5) {
                                    randomeCharThree = Character.toString(ansOneAnsTwo.charAt(numbersList.get(2))).toUpperCase();
                                }
                                if (ansLength > 8) {
                                    randomeCharFour = Character.toString(ansOneAnsTwo.charAt(numbersList.get(3))).toUpperCase();
                                }
                                if (ansLength > 12) {
                                    randomeCharFive = Character.toString(ansOneAnsTwo.charAt(numbersList.get(4))).toUpperCase();
                                }


                                //This list store the postion of visisble boxes of above
                                int ansOneLnegth = currentQ.getANSWER().length();
                                int ansTwoLength = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();


                                for (int i = 0; i < ansOneLnegth; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < ansTwoLength; j++) {
                                    arrayList.add(j + 10);
                                }

                                //before setting the above boxes text remove text if user has enter the text i.e refresh
                                refreshBoxesboth();


                                //setting the random char for the above boxes
                                if (ansLength > 3) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(0))].setText(randomCharOne);
                                }
                                if (ansLength > 4) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(1))].setText(randomeCharTwo);
                                }
                                if (ansLength > 5) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(2))].setText(randomeCharThree);
                                }
                                if (ansLength > 6) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(3))].setText(randomeCharFour);
                                }
                                if (ansLength > 7) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(4))].setText(randomeCharFive);
                                }
                                arrayList.clear();
                                numbersList.clear();


                                //now removing below boxes which has same character(alphabets) that are random generated
                                //1st
                                if (ansLength > 3) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomCharOne)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //2nd
                                if (ansLength > 4) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharTwo)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //3rd
                                if (ansLength > 5) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharThree)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }

                                //4th
                                if (ansLength > 8) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharFour)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }


                                //5th
                                if (ansLength > 12) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharFive)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (ansLength > 3) {
                                    FreeHint.setVisibility(View.INVISIBLE);
                                }
                                if (ansLength <= 3) {
                                    //  Toast.makeText(MainGameActivity.this, "Free hint not available for less than 4 ", Toast.LENGTH_LONG).show();
                                    Toast toast = Toast.makeText(getApplicationContext(), "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
                                    v.setTextSize(12);
                                    toast.show();
                                }
                            }

                        }

                        //FreeHint with boom (i.e boom is already used before freehint)
                        if (returnQid() != qid && returnFreeHintUsed() != qid) {
                            if (returnBoomIdUsed() == qid) {

                                //if users types in some thin this will clear it off
                                refreshBoxesboth();

                                //store the qid for which freehint is used
                                demoHelperClass.insertHint(qid);

                                //Now in this case there will be no random no but instead manual number
                                //If ans length is greater then five we will store first five numbers in table
                                if (ansLength > 5) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 1, 2, 3, 4);
                                }
                                //If ans length is exactly five we will store first two numbers in table and rest of them as zero
                                else if (ansLength > 4) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 1, 0, 0, 0);
                                }
                                //If ans length is exactly four we will store first one numbers in table and rest of them as zero
                                // in this case 0 is the first manual no and rest of them zero so total five zero
                                else if (ansLength > 3) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 0, 0, 0, 0);
                                }


                                //this list store the position of visible boxes of above
                                int ansOneLength = currentQ.getANSWER().length();
                                int ansTwoLength = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();

                                for (int i = 0; i < ansOneLength; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < ansTwoLength; j++) {
                                    arrayList.add(j + 10);
                                }


                                //setting the text of above boxes
                                if (ansLength > 3) {

                                    textViewArrayAbove[arrayList.get(0)].setText(ansOneAnsTwo.substring(0, 1).toUpperCase());
                                }
                                if (ansLength > 4) {

                                    textViewArrayAbove[arrayList.get(1)].setText(ansOneAnsTwo.substring(1, 2).toUpperCase());
                                }
                                if (ansLength > 5) {

                                    textViewArrayAbove[arrayList.get(2)].setText(ansOneAnsTwo.substring(2, 3).toUpperCase());
                                }
                                if (ansLength > 8) {

                                    textViewArrayAbove[arrayList.get(3)].setText(ansOneAnsTwo.substring(3, 4).toUpperCase());
                                }
                                if (ansLength > 12) {

                                    textViewArrayAbove[arrayList.get(4)].setText(ansOneAnsTwo.substring(4, 5).toUpperCase());

                                }
                                arrayList.clear();


                                //now removing the below boxes
                                if (ansLength >= 4) {
                                    String char1 = ansOneAnsTwo.substring(0, 1);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //2nd
                                if (ansLength >= 5) {
                                    String char1 = ansOneAnsTwo.substring(1, 2);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //3rd
                                if (ansLength >= 6) {
                                    String char1 = ansOneAnsTwo.substring(2, 3);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //4th
                                if (ansLength >= 9) {
                                    String char1 = ansOneAnsTwo.substring(3, 4);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //5th
                                if (ansLength >= 13) {
                                    String char1 = ansOneAnsTwo.substring(4, 5);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }

                                }
                                removeKachra();
                            }

                            if (ansLength > 3) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }
                            if (ansLength <= 3) {
                                // Toast.makeText(MainGameActivity.this, "Free hint not available for less than 4 boxes", Toast.LENGTH_LONG).show();

                                Toast toast = Toast.makeText(getApplicationContext(), "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
                                v.setTextSize(12);
                                toast.show();
                            }
                        }


                        //If dialog_sound is on then play it first and then dismiss dialog else directly dismiss it
                        //to avoid memory loss
                        if (checkSound()) {
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                            if (mediaPlayer != null) {
                                mediaPlayer.start();
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayer.reset();
                                        mediaPlayer.release();
                                        dialog.dismiss();
                                    }
                                });
                            }

                        } else {
                            dialog.dismiss();
                        }
                    }
                });
            }
        });

    }

    //return true if dialog_sound is on or else false
    public Boolean checkSound() {
        List list = demoHelperClass.getSound();
        if (list != null) {
            if (list.size() % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    //Previous question left arrow click
    public void left(View view) {
        // myNum = Integer.parseInt(myString.getText().toString());
        if (qid >= 1 && qid != 180 && qid != 360 && qid != 600 && qid != 780 && qid != 900) {
            qid--;


            //@@ 12
            if (qid < 1119) {
                rightImage.setVisibility(View.VISIBLE);
            }

            //IF question is not solved then it will show hints(FreeHint,boom,dialog_reveal)
            //and also show above and below boxes
            questionNotSolved();

            //This will set The Text of question and also setText for below boxes as per que no
            //and also manage spacing between boxes as per the size of the device
            viewData();

            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
            //and also hide above and below boxes or else visa versa
            questionSolved();

            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
            //fillingBoxes has method checkIfHintIsUsed
            fillingBoxes();

            //It gives animation for each que
            allAnimation();

            //If we reach the end of the questions of particular category then it will
            //handle the left & right visibility of arrow
            visiblityOfrightleft();

            diffLevel();

            //It will set The text of number of que solved
            setNoOfSolvedQueText();

            //If FreeHint is used then FreeHint invisible
            if (returnFreeHintUsed() == qid) {
                FreeHint.setVisibility(View.INVISIBLE);
            }

            //after question has solved setting the answer text
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                }
            }
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                }
            }

            // if boxes less than or eual to 3 then FreeHint invisible
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                FreeHint.setImageResource(R.drawable.noidea1cartoon);
            } else {
                FreeHint.setImageResource(R.drawable.idea1cartoon);
            }

        }

    }


    //Next question right arrow clicked
    public void right(View view) {
        if (qid >= 0 && qid != 179 && qid != 359 && qid != 599 && qid != 779 && qid != 899 && qid != 1119) {
            qid++;

            //this is for left and right images visibility and invisibility
            if (qid > 0) {
                leftImage.setVisibility(View.VISIBLE);
            }
            if (qid == 59){
                rightImage.setVisibility(View.INVISIBLE);
            }

            //IF question is not solved then it will show hints(FreeHint,boom,dialog_reveal)
            //and also show above and below boxes
            questionNotSolved();

            //This will set The Text of question and also setText for below boxes as per que no
            //and also manage spacing between boxes as per the size of the device
            viewData();

            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
            //and also hide above and below boxes
            questionSolved();

            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
            //fillingBoxes has method checkIfHintIsUsed
            fillingBoxes();

            //It gives animation for each que
            allAnimation();

            //If we reach the end of the questions of particular category then it will
            //handle the left & right visibility of arrow
            visiblityOfrightleft();

            //it will set the the text easy,medium or hard as per req
            diffLevel();

            //It will set The text of number of que solved
            setNoOfSolvedQueText();

            //If FreeHint is used then FreeHint invisible
            if (returnFreeHintUsed() == qid) {
                FreeHint.setVisibility(View.INVISIBLE);
            }

            //after question has solved setting the answer text
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                }
            }
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                }
            }

            //if boxes less than or equal to 3 then FreeHint invisible
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                FreeHint.setImageResource(R.drawable.noidea1cartoon);
            } else {
                FreeHint.setImageResource(R.drawable.idea1cartoon);
            }

        }
    }

    //It will remove the letters from below boxes which are not the part of the answer
    //i.e extra letters
    private void removeKachra() {
        // Now we have to remove kachra so we have to check which all textview are visible
        //and check for there text if it matches with the getUselessstring then setText="" and also invisible
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 0) {
                String first = currentQ.getUSELESSSTRING().substring(0, 1).toUpperCase();

                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 1) {
                String first = currentQ.getUSELESSSTRING().substring(1, 2).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 2) {
                String first = currentQ.getUSELESSSTRING().substring(2, 3).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 3) {
                String first = currentQ.getUSELESSSTRING().substring(3, 4).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 4) {
                String first = currentQ.getUSELESSSTRING().substring(4, 5).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 5) {
                String first = currentQ.getUSELESSSTRING().substring(5, 6).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 6) {
                String first = currentQ.getUSELESSSTRING().substring(6, 7).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 7) {
                String first = currentQ.getUSELESSSTRING().substring(7, 8).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 8) {
                String first = currentQ.getUSELESSSTRING().substring(8, 9).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 9) {
                String first = currentQ.getUSELESSSTRING().substring(9, 10).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 10) {
                String first = currentQ.getUSELESSSTRING().substring(10, 11).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 11) {
                String first = currentQ.getUSELESSSTRING().substring(11, 12).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 12) {
                String first = currentQ.getUSELESSSTRING().substring(12, 13).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 13) {
                String first = currentQ.getUSELESSSTRING().substring(13, 14).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 14) {
                String first = currentQ.getUSELESSSTRING().substring(14, 15).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 15) {
                String first = currentQ.getUSELESSSTRING().substring(15, 16).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 16) {
                String first = currentQ.getUSELESSSTRING().substring(16, 17).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 17) {
                String first = currentQ.getUSELESSSTRING().substring(17, 18).toUpperCase();
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
    }//end of removeKachra

    //It will set The text that the que is easy or hard or medium.
    //It will also set The color of the below boxes,bootstrap bar and left and right arrow
    public void diffLevel() {
        //a_maingame
        if (qid < 60) {
            queNum.setText(String.valueOf(qid + 1));
            diffLevel.setText(getResources().getString(R.string.easy));

        }
    }

    //It will set The text of number of que solved
    public void setNoOfSolvedQueText(){

        String checkPoint = String.valueOf(prefManager.getHadistHard());
        List noOfSolvedQueList = demoHelperClass.GetQid();
        int a = noOfSolvedQueList.size() * 10;
        solvedText.setText(String.valueOf(a));

        noOfSolvedQueList.clear();
    }

    //If we reach the end of the questions of particular category then it will
    //handle the left & right visibility of arrow
    public void visiblityOfrightleft() {
        for (int i = 0; i <= qid; i++) {
            //for rightImage
            if (qid == 179) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 359) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 599) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 779) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 899) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 1119) {
                rightImage.setVisibility(View.INVISIBLE);
            }

            //for leftImage
            if (qid == 0) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 180) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 360) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 600) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 780) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 900) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 1120) {
                leftImage.setVisibility(View.INVISIBLE);
            }
        }
    }

    //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
    //and also hide above and below boxes or else visa versa
    public void questionSolved() {
        if (returnQid() == qid) {
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            FreeHint.setVisibility(View.INVISIBLE);
            correctImage.setVisibility(View.VISIBLE);
        }
    }



    //Animations method called in Oncreate and right and left;
    private void allAnimation() {

        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterPolator interpolator = new MyBounceInterPolator(0.11, 10);
        myAnim.setInterpolator(interpolator);
        tvQ.startAnimation(myAnim);


        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            public void run() {

            }
        };
        handler.postDelayed(runnable, 150); //for initial delay..*//*

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].startAnimation(myAnim);
        }
    }

    public void questionNotSolved(){
        currentQ = queList.get(qid);
        FreeHint.setVisibility(View.VISIBLE);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
        correctImage.setVisibility(View.INVISIBLE);
    }

    // This method returns qid of solved questions
    public int returnQid() {
        int a = 100001;
        List<Integer> solvedQueID = demoHelperClass.GetQid();
        if (solvedQueID != null) {
            for (int i = 0; i < solvedQueID.size(); i++) {
                a = solvedQueID.get(i);
                if (a == qid) {
                    solvedQueID.clear();
                    break;
                }
            }
        }
        return a;
    }

    //This will set The Text of question and also setText for below boxes as per que no
    //and also manage spacing between boxes as per the size of the device
    public void viewData() {

        //Set the question
        tvQ.setText(currentQ.getQUESTION());
        //tvQ.setTypeface(openSansBold);

        List idOfSlovedQuestions = demoHelperClass.GetQid();
        if (idOfSlovedQuestions != null) {
            for (int i = 0; i < idOfSlovedQuestions.size(); i++) {
                int id = (Integer) idOfSlovedQuestions.get(i);

                //This will check that question  is solved or not
                if (id == qid) {
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());

                    try {
                        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                            height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                            weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                        }

                        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                            height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                            weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                        }
                    } catch (Exception e) {
                        // Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
                    }

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(1, 1, 1, 1);

                    for (int z = 0; z < 10; z++) {
                        if (currentQ.getANSWER().length() >= z + 1) {
                            textfirst[z].setText(currentQ.getANSWER().substring(z, z + 1).toUpperCase());
                            textfirst[z].setLayoutParams(params);
                        }
                    }
                    for (int k = 0; k < 10; k++) {
                        if (currentQ.getANSWER2().length() >= k + 1) {

                            textsecound[k].setText(currentQ.getANSWER2().substring(k, k + 1).toUpperCase());
                            textsecound[k].setLayoutParams(params);
                        }
                    }

                    break;

                }

                comman3();

            }
        }
        if (idOfSlovedQuestions != null) {
            if (idOfSlovedQuestions.size() == 0) {
                comman3();
            }
        }

        //1st and 2nd
        for (int i = 0; i < 10; i++) {
            if (currentQ.getANSWER().length() >= i + 1) {
                textfirst[i].setVisibility(View.VISIBLE);
            } else {
                textfirst[i].setVisibility(View.INVISIBLE);
                textfirst[i].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }
        for (int j = 0; j < 10; j++) {
            if (currentQ.getANSWER2().length() >= j + 1) {
                textsecound[j].setVisibility(View.VISIBLE);
            } else {
                textsecound[j].setVisibility(View.INVISIBLE);
                textsecound[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int checkWidth = size.x;
        int checkHeight = size.y;

        //Toast.makeText(MainGameActivity.this, "width=" + Integer.toString(width1), Toast.LENGTH_LONG).show();
        // Toast.makeText(MainGameActivity.this, "height=" + Integer.toString(height1), Toast.LENGTH_LONG).show();

        //setting the text of the below boxes 18 boxes.
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
        int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);
        params.setMargins(1, 1, 1, 1);

        //NORMAL
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                if (checkWidth < 700 && checkHeight < 1000) {
                    height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
                    weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(1, 1, 1, 1);
                    //  Toast.makeText(MainGameActivity.this, "Normal -less", Toast.LENGTH_LONG).show();
                } else {
                    height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(3, 3, 3, 3);
                    //   Toast.makeText(MainGameActivity.this, "NORMAL", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            //   Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        //LARGE
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                params = new LinearLayout.LayoutParams(
                        weidth, height);
                params.setMargins(4, 4, 4, 4);
                //    Toast.makeText(MainGameActivity.this, "large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(27);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        //X-LARGE
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, getResources().getDisplayMetrics());
                params = new LinearLayout.LayoutParams(
                        weidth, height);
                params.setMargins(7, 7, 7, 7);
                //  Toast.makeText(MainGameActivity.this, "x-large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(30);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        for (int j = 0; j < 9; j++) {
            if (currentQ.getRANDOMANS1().length() >= j + 1) {

                textViewBelowFirst[j].setVisibility(View.VISIBLE);
                textViewBelowFirst[j].setText(currentQ.getRANDOMANS1().substring(j, j + 1));
                textViewBelowFirst[j].setLayoutParams(params);

            } else {
                textViewBelowFirst[j].setVisibility(View.INVISIBLE);
                textViewBelowFirst[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

        for (int j = 0; j < 9; j++) {
            if (currentQ.getRANDOMANS2().length() >= j + 1) {
                textViewBelowsecond[j].setVisibility(View.VISIBLE);
                textViewBelowsecond[j].setText(currentQ.getRANDOMANS2().substring(j, j + 1));
                textViewBelowsecond[j].setLayoutParams(params);

            } else {
                textViewBelowsecond[j].setVisibility(View.INVISIBLE);
                textViewBelowsecond[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

    }//end of viewData


    private void comman3() {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                //   Toast.makeText(MainGameActivity.this,"called yo yo",Toast.LENGTH_LONG).show();
            }

            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                //   Toast.makeText(MainGameActivity.this,"called yo yo",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);
        params.setMargins(1, 1, 1, 1);

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].setText("");
            textViewArrayAbove[i].setLayoutParams(params);
        }
    }
    //onclick listener for aboveboxes if clicked below boxes visible
    public void onClickForAboveBoxes() {

        for (int i = 0; i < 18; i++) {
            if (textView.getText() != "") {
                if (textView.getText() == textViewArrayBelow[i].getText()) {
                    textViewArrayBelow[i].setVisibility(View.VISIBLE);
                    textView.setText("");
                    break;
                }
            }
        }

    }

    //This will check the answer is correct or not after filling all the boxes
    //If yes then it will bring a dialog of correct and after pressing next button it will move to next que
    public void check() {
        int y = tv11.length() + tv12.length() + tv13.length() + tv14.length() + tv15.length() + tv16.length() + tv17.length() + tv18.length() + tv19.length() + tv20.length();
        int y2 = tv11b.length() + tv12b.length() + tv13b.length() + tv14b.length() + tv15b.length() + tv16b.length() + tv17b.length() + tv18b.length() + tv19b.length() + tv20b.length();
        if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() == y + y2) {
            String x = (stringBuffer.append(tv11.getText()).append(tv12.getText()).append(tv13.getText()).append(tv14.getText()).append(tv15.getText()).append(tv16.getText()).append(tv17.getText()).append(tv18.getText()).append(tv19.getText()).append(tv20.getText())).toString();
            String x2 = (stringBuffer2.append(tv11b.getText()).append(tv12b.getText()).append(tv13b.getText()).append(tv14b.getText()).append(tv15b.getText()).append(tv16b.getText()).append(tv17b.getText()).append(tv18b.getText()).append(tv19b.getText()).append(tv20b.getText())).toString();
            if (x.equalsIgnoreCase(currentQ.getANSWER()) && x2.equalsIgnoreCase(currentQ.getANSWER2())) {
                //@@ 3
                if (qid < 1119 && qid != 179 && qid != 359 && qid != 599 && qid != 779 && qid != 899) {
                    demoHelperClass.InsertQid(qid);

                    //setting the text for number of correct question solved
                    setNoOfSolvedQueText();

                    String checkPoint = String.valueOf(prefManager.getHadistHard());
                    Log.e("Point", checkPoint);

                    int sum = 10;
                    if (checkPoint == "null"){
                        prefManager.saveHadistHard(getBaseContext(), String.valueOf(sum));
                    }else if(checkPoint != null){
                        int point_uddate = Integer.parseInt(checkPoint) + Integer.parseInt(String.valueOf(sum));
                        prefManager.saveHadistHard(getBaseContext(), String.valueOf(point_uddate));
                    }

                    //left
                    //@@ 4
                    if (qid <= 1119) {
                        leftImage.setVisibility(View.VISIBLE);
                    }

                    //right
                    //@@ 5
                    if (qid == 1119) {
                        rightImage.setVisibility(View.INVISIBLE);
                    }

                    //set up dialog
                    final Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.dialog_correctans);
                    dialog.setCancelable(false);


                    //there are a lot of settings, for dialog, check them all out!
                    //set up text
                    TextView correct = (TextView) dialog.findViewById(R.id.correct);


                    //Animation
                    String stringanswer = currentQ.getANSWER() + " " + currentQ.getANSWER2();
                    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                    //Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterPolator interpolator = new MyBounceInterPolator(0.1, 70);
                    myAnim.setInterpolator(interpolator);
                    correct.startAnimation(myAnim);
                    TextView answerorrect = (TextView) dialog.findViewById(R.id.answercorrect);
                    answerorrect.setText(stringanswer.toUpperCase());

                    //Incrementing the question no
                    qid = qid + 1;
                    currentQ = queList.get(qid);

                    //set up button (Next Button)
                    Button nextbutton = (Button) dialog.findViewById(R.id.Button01);
                    nextbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            allAnimation();

                            //This will set The Text of question and also setText for below boxes as per que no
                            //and also manage spacing between boxes as per the size of the device
                            viewData();

                            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
                            //and also hide above and below boxes
                            questionSolved();

                            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
                            //fillingBoxes has method checkIfHintIsUsed
                            fillingBoxes();

                            queNum.setText(String.valueOf(qid + 1));

                            //If we reach the end of the questions of particular category then it will
                            //handle the left & right visibility of arrow
                            visiblityOfrightleft();

                            //It will set The text that the que is easy or hard or medium.
                            //It will also set The color of the below boxes,bootstrap bar and left and right arrow
                            diffLevel();


                            //if the answer boxes are greater than three then also hint1 invisible
                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }

                            clicked = false;

                            //if question hint is already used then hint invisible
                            if (returnFreeHintUsed() == qid) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }
                            //else is very imp
                            else {
                                FreeHint.setVisibility(View.VISIBLE);
                            }

                            //if question is solved then hint1 invisible
                            if (returnQid() == qid) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }

                            //after question has solved setting the answer text
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                                }
                                correctImage.setVisibility(View.VISIBLE);
                            }
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                                }
                            }

                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                //  hint1.setVisibility(View.INVISIBLE);
                                FreeHint.setImageResource(R.drawable.noidea1cartoon);
                            } else {
                                FreeHint.setImageResource(R.drawable.idea1cartoon);
                            }

                            dialog.cancel();

                        }
                    });

                    dialog.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);


                    //If dialog_sound is on then play it
                    if (checkSound()) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.win);
                        if (mediaPlayer != null) {
                            mediaPlayer.start();
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mediaPlayer.reset();
                                    mediaPlayer.release();
                                }
                            });
                        }
                    }
                }

                //@@ 7 - This are all edge cases where the que no is last in it's category
                else if (qid == 1119 || qid == 179 || qid == 359 || qid == 599 || qid == 779 || qid == 899) {

                    //Toast msg that ans is correct
                    Toast toast = Toast.makeText(getApplicationContext(), "\tcorrect \t", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.transparent2));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                    v.setTextSize(20);
                    toast.show();

                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);

                    //Inserting the id of solved que in table
                    demoHelperClass.InsertQid(qid);


                    //No increment of que since it is last question in it's category
                    currentQ = queList.get(qid);

                    //This will set The Text of question and also setText for below boxes as per que no
                    //and also manage spacing between boxes as per the size of the device
                    viewData();

                    //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
                    //and also hide above and below boxes or else visa versa
                    questionSolved();

                    FreeHint.setVisibility(View.INVISIBLE);

                    //setting text of number of correct question solved
                    setNoOfSolvedQueText();

                    clicked = false;
                }
            } else {
                //Animation of incorrect if wrong answer
                incorrectAnimation();
                stringBuffer.setLength(0);
                stringBuffer2.setLength(0);
            }
        }
    }//end of check

    //Animation of incorrect if wrong answer
    public void incorrectAnimation() {
        incorrect.setVisibility(View.VISIBLE);
        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterPolator interpolator = new MyBounceInterPolator(0.1, 60);
        myAnim.setInterpolator(interpolator);
        incorrect.startAnimation(myAnim);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                incorrect.setVisibility(View.INVISIBLE);  //for interval...
            }
        };
        handler.postDelayed(runnable, 100); //for initial delay..*/
    }
    //onclick listener for belowboxes if clicked above boxes visible
    public void onClickForBelowBoxes() {

        for (int i = 0; i < 20; i++) {
            if (textViewArrayAbove[i].length() == 0 && textViewArrayAbove[i].getVisibility() == View.VISIBLE) {
                textViewArrayAbove[i].setText(textView2.getText());
                textView2.setVisibility(View.INVISIBLE);
                check();
                break;
            }
        }
    }

    //onclick listener for all above and below boxes
    //onclick listener for above boxes text11-text20
    public void text11(View view) {
        textView = tv11;
        onClickForAboveBoxes();
    }

    public void text12(View view) {
        textView = tv12;
        onClickForAboveBoxes();
    }

    public void text13(View view) {
        textView = tv13;
        onClickForAboveBoxes();
    }

    public void text14(View view) {
        textView = tv14;
        onClickForAboveBoxes();
    }

    public void text15(View view) {
        textView = tv15;
        onClickForAboveBoxes();
    }

    public void text16(View view) {
        textView = tv16;
        onClickForAboveBoxes();
    }

    public void text17(View view) {
        textView = tv17;
        onClickForAboveBoxes();
    }

    public void text18(View view) {
        textView = tv18;
        onClickForAboveBoxes();
    }

    public void text19(View view) {
        textView = tv19;
        onClickForAboveBoxes();
    }

    public void text20(View view) {
        textView = tv20;
        onClickForAboveBoxes();
    }

    //This are onclick listener for below boxes 11b - 29b
    public void text11b(View view) {
        textView = tv11b;
        onClickForAboveBoxes();

    }

    public void text12b(View view) {
        textView = tv12b;
        onClickForAboveBoxes();

    }

    public void text13b(View view) {
        textView = tv13b;
        onClickForAboveBoxes();

    }

    public void text14b(View view) {
        textView = tv14b;
        onClickForAboveBoxes();

    }

    public void text15b(View view) {
        textView = tv15b;
        onClickForAboveBoxes();

    }

    public void text16b(View view) {
        textView = tv16b;
        onClickForAboveBoxes();

    }

    public void text17b(View view) {
        textView = tv17b;
        onClickForAboveBoxes();

    }

    public void text18b(View view) {
        textView = tv18b;
        onClickForAboveBoxes();

    }

    public void text19b(View view) {
        textView = tv19b;
        onClickForAboveBoxes();

    }

    public void text20b(View view) {
        textView = tv20b;
        onClickForAboveBoxes();

    }

    public void text21(View view) {
        textView2 = tv21;
        onClickForBelowBoxes();
        sound();
    }

    public void text22(View view) {
        textView2 = tv22;
        onClickForBelowBoxes();
        sound();
    }

    public void text23(View view) {
        textView2 = tv23;
        onClickForBelowBoxes();
        sound();
    }

    public void text24(View view) {
        textView2 = tv24;
        onClickForBelowBoxes();
        sound();
    }

    public void text25(View view) {
        textView2 = tv25;
        onClickForBelowBoxes();
        sound();
    }

    public void text26(View view) {
        textView2 = tv26;
        onClickForBelowBoxes();
        sound();
    }

    public void text27(View view) {
        textView2 = tv27;
        onClickForBelowBoxes();
        sound();
    }

    public void text28(View view) {
        textView2 = tv28;
        onClickForBelowBoxes();
        sound();
    }

    public void text29(View view) {
        textView2 = tv29;
        onClickForBelowBoxes();
        sound();
    }

    public void text21b(View view) {
        textView2 = tv21b;
        onClickForBelowBoxes();
        sound();

    }

    public void text22b(View view) {
        textView2 = tv22b;
        onClickForBelowBoxes();
        sound();
    }

    public void text23b(View view) {
        textView2 = tv23b;
        onClickForBelowBoxes();
        sound();

    }

    public void text24b(View view) {
        textView2 = tv24b;
        onClickForBelowBoxes();
        sound();
    }

    public void text25b(View view) {
        textView2 = tv25b;
        onClickForBelowBoxes();
        sound();
    }

    public void text26b(View view) {
        textView2 = tv26b;
        onClickForBelowBoxes();
        sound();
    }

    public void text27b(View view) {
        textView2 = tv27b;
        onClickForBelowBoxes();
        sound();
    }

    public void text28b(View view) {
        textView2 = tv28b;
        onClickForBelowBoxes();
        sound();

    }

    public void text29b(View view) {
        textView2 = tv29b;
        onClickForBelowBoxes();
        sound();
    }

    //Function for dialog_sound
    public void sound() {
        if (checkSound()) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
            if (mediaPlayer != null) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                    }
                });
            }
        }
    }

    //This method returns qid of questions where Freehint(hint1) is used
    public int returnFreeHintUsed() {
        int x = 100001;
        List xyz = demoHelperClass.getHint();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                x = (Integer) xyz.get(i);
                if (x == qid) {
                    xyz.clear();
                    break;
                }
            }
        }
        return x;
    }

    //It will return id of the question for which boom is used
    public int returnBoomIdUsed() {
        int y = 1111110;
        List pqr = demoHelperClass.getBoomId();
        if (pqr != null) {
            for (int i = 0; i < pqr.size(); i++) {
                y = (Integer) pqr.get(i);
                if (y == qid) {
                    //break here
                    pqr.clear();
                    break;
                }
            }
        }
        return y;
    }

    //If users types the char in above boxes then both above boxes and below boxes will be reset
    public void refreshBoxesboth() {

        for (TextView i : textViewArrayAbove) {
            i.setText("");
        }
        for (int i = 0; i < currentQ.getRANDOMANS1().length(); i++) {
            textViewBelowFirst[i].setVisibility(View.VISIBLE);
            textViewBelowFirst[i].setText(currentQ.getRANDOMANS1().substring(i, i + 1).toUpperCase());
        }

        for (int i = 0; i < currentQ.getRANDOMANS2().length(); i++) {
            textViewBelowsecond[i].setVisibility(View.VISIBLE);
            textViewBelowsecond[i].setText(currentQ.getRANDOMANS2().substring(i, i + 1).toUpperCase());
        }
    }//end of refreshBoxesBoth

    //This method checks if the FreeHint is used if yes then it will set the text of some of the boxes
    //if boxes=4 hint=1, boxes=5 hint=2, boxes=6-8 hint=3, boxes=9-12 hint=4, boxes=12-18 hint=5
    public void checkIfFreeHintIsUsed() {

        String storebothanswer = currentQ.getANSWER() + currentQ.getANSWER2();
        Integer hintLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();

        List<com.example.muslimquiz.helper.FreeHint> freeHintsRandomNo = demoHelperClass.getRandomNumbers();

        if (freeHintsRandomNo != null) {
            for (int i = 0; i < freeHintsRandomNo.size(); i++) {

                if (freeHintsRandomNo.get(i).getFreeHintUsedId() == qid) {

                    com.example.muslimquiz.helper.FreeHint freeHint = freeHintsRandomNo.get(i);

                    StringBuilder stringBuffer = new StringBuilder();
                    if (hintLength > 3) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoOne()));
                    }
                    if (hintLength > 4) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoTwo()));
                    }
                    if (hintLength > 5) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoThree()));
                    }
                    if (hintLength > 8) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoFour()));
                    }
                    if (hintLength > 12) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoFive()));
                    }


                    //this list store the postion of visisble boxes of above
                    int ansOneLength = currentQ.getANSWER().length();
                    int ansTwoLength = currentQ.getANSWER2().length();
                    ArrayList<Integer> arrayList = new ArrayList<>();


                    for (int k = 0; k < ansOneLength; k++) {
                        arrayList.add(k);
                    }
                    for (int j = 0; j < ansTwoLength; j++) {
                        arrayList.add(j + 10);
                    }

                    //before setting text of above boxes clear all above and below boxes that is refresh
                    refreshBoxesboth();

                    //setting the text for the above boxes
                    if (hintLength > 3) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoOne())].setText(stringBuffer.substring(0, 1).toUpperCase());
                    }
                    if (hintLength > 4) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoTwo())].setText(stringBuffer.substring(1, 2).toUpperCase());
                    }
                    if (hintLength > 5) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoThree())].setText(stringBuffer.substring(2, 3).toUpperCase());
                    }
                    if (hintLength > 8) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoFour())].setText(stringBuffer.substring(3, 4).toUpperCase());
                    }
                    if (hintLength > 12) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoFive())].setText(stringBuffer.substring(4, 5).toUpperCase());
                    }
                    arrayList.clear();


                    //now removing the three option boxes which has same alphabets that are random generate
                    //1st
                    if (hintLength > 3) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(0, 1))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }
                    //2nd
                    if (hintLength > 4) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(1, 2))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }
                    //3rd
                    if (hintLength > 5) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(2, 3))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }

                    //4th
                    if (hintLength > 8) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(3, 4))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }


                    //5th
                    if (hintLength > 12) {
                        for (TextView j : textViewArrayBelow)
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(4, 5))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                    }
                    break;
                }
                stringBuffer.setLength(0);

            }
        }
        //freeHintsRandomNo.clear();
    }

    //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
    //fillingBoxes has method checkIfHintIsUsed
    public void fillingBoxes() {
        checkIfFreeHintIsUsed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        queList.clear();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        incorrect = null;
        tvQ = null;
        tvt = null;
        gemsText = null;
        queNum = null;
        triviaKnowldegText = null;
        backButtonImage.setImageDrawable(null);
        leftImage.setImageDrawable(null);
        rightImage.setImageDrawable(null);
        FreeHint.setImageDrawable(null);
        correctImage.setImageDrawable(null);
        solvedText = null;
        toolbar = null;
        l1.removeAllViews();
        l2.removeAllViews();

        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        backButtonImage.setOnClickListener(null);
        FreeHint.setOnClickListener(null);

        for (int i = 0; i < textViewArrayAbove.length; i++) {
            textViewArrayAbove[i] = null;
        }
        for (int i = 0; i < textViewArrayBelow.length; i++) {
            textViewArrayBelow[i] = null;
        }

        textViewArrayAbove = null;
        textfirst = null;
        textsecound = null;
        textViewArrayBelow = null;
        textViewBelowFirst = null;
        textViewBelowsecond = null;
        demoHelperClass = null;
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getIntent();
        /* Obtain String from Intent  */
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            for (int i = 0; i < 180; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), HadistSlide.class);
                    if (i < 60) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
        }
    }
}
