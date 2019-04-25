package com.example.muslimquiz.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class ResetPasswordActivity extends AppCompatActivity {

    Typeface titleface, descriptionface, emailface, editetexteimailface, reseetbuttonface, backface;
    TextView titile, description, tvemail, back;
    EditText email;
    Button reset;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        auth = FirebaseAuth.getInstance();
        init();
    }

    void init(){
        titile = findViewById(R.id.title_reset);
        description = findViewById(R.id.description_reset);
        tvemail = findViewById(R.id.tv_email);
        back = findViewById(R.id.tv_back);
        email = findViewById(R.id.et_email_reset);
        reset = findViewById(R.id.btn_reset_password);
        progressBar = findViewById(R.id.progressBar);

        titleface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Bold.ttf");
        descriptionface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Regular.ttf");
        emailface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        editetexteimailface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        reseetbuttonface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        backface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");

        titile.setTypeface(titleface);
        description.setTypeface(descriptionface);
        tvemail.setTypeface(emailface);
        back.setTypeface(backface);
        email.setTypeface(emailface);
        reset.setTypeface(reseetbuttonface);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2 = email.getText().toString();

                if (TextUtils.isEmpty(email2)){
                    Toast.makeText(ResetPasswordActivity.this, "Masukan email", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email2)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPasswordActivity.this, "Kami telah mengirimi Anda instruksi untuk mereset kata sandi Anda!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(ResetPasswordActivity.this, "Email anda tidak terdaftar, silahkan register", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
    }

}
