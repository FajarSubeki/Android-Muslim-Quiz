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
import com.example.muslimquiz.helper.PrefManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    TextView title, description, username, password, forgot, register;
    EditText etusername, etpassword;
    Button login;
    Typeface titleface, descriptionface, usernameface, passwordface, forgotface, registerface, etusernameface, etpasswordface, loginface;
    FirebaseAuth auth;
    ProgressBar progressBar;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        prefManager = new PrefManager(this);
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_sign_in);
        init();
    }

    void init(){
        titleface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Bold.ttf");
        descriptionface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Regular.ttf");
        usernameface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        passwordface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        forgotface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        registerface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        etusernameface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        etpasswordface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
        loginface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");

        title = findViewById(R.id.title_login);
        description = findViewById(R.id.description_login);
        username = findViewById(R.id.tv_email);
        password = findViewById(R.id.tv_password);
        forgot = findViewById(R.id.tv_forgot_password);
        register = findViewById(R.id.tv_register);
        etusername = findViewById(R.id.et_email);
        etpassword = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);

        title.setTypeface(titleface);
        description.setTypeface(descriptionface);
        username.setTypeface(usernameface);
        password.setTypeface(passwordface);
        forgot.setTypeface(forgotface);
        register.setTypeface(registerface);
        etusername.setTypeface(etusernameface);
        etpassword.setTypeface(etpasswordface);
        login.setTypeface(loginface);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPasswordActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etusername.getText().toString();
                final String password = etpassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Masukan alamat email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Masukan password", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        etpassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(SignInActivity.this, "Username atau password salah", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                    Toast.makeText(SignInActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                    prefManager.saveEmail(getApplicationContext(), email);
                                    prefManager.savePassword(getApplicationContext(), password);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
