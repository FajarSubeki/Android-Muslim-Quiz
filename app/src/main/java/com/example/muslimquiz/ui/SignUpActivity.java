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
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.PrefManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {

    TextView title, description, username, password, forgot, register, name;
    EditText etusername, etpassword, etname;
    Button bt_register;
    Typeface nameface, titleface, descriptionface, usernameface, passwordface, forgotface, registerface, etusernameface, etpasswordface, loginface;

    FirebaseAuth auth;
    ProgressBar progressBar;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        prefManager = new PrefManager(this);
        init();
    }

    void init(){
        nameface = Typeface.createFromAsset(getAssets(), "fonts/GoogleSans-Medium.ttf");
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
        name = findViewById(R.id.tv_name);
        username = findViewById(R.id.tv_email);
        password = findViewById(R.id.tv_password);
        forgot = findViewById(R.id.tv_forgot_password);
        register = findViewById(R.id.tv_register);
        etname = findViewById(R.id.et_name);
        etusername = findViewById(R.id.et_email);
        etpassword = findViewById(R.id.et_password);
        bt_register = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);

        title.setTypeface(titleface);
        description.setTypeface(descriptionface);
        username.setTypeface(usernameface);
        password.setTypeface(passwordface);
        name.setTypeface(nameface);
        forgot.setTypeface(forgotface);
        register.setTypeface(registerface);
        etusername.setTypeface(etusernameface);
        etpassword.setTypeface(etpasswordface);
        bt_register.setTypeface(loginface);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPasswordActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });

        bt_register .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etname.getText().toString();
                final String email = etusername.getText().toString();
                final String password = etpassword.getText().toString();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SignUpActivity.this, "Masukan nama lengkap", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(SignUpActivity.this, "Masukan alamat email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(SignUpActivity.this, "Masukan Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6){
                    Toast.makeText(SignUpActivity.this, "Password terlalu pendek, masukan minimal 6 karakter", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(SignUpActivity.this, "Email anda telah terdaftar, silahkan login", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(), "Daftar akun gagal !" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Daftar akun berhasil", Toast.LENGTH_SHORT).show();
                                    prefManager.saveFullName(SignUpActivity.this, name);
                                    prefManager.saveEmail(SignUpActivity.this, email);
                                    prefManager.savePassword(SignUpActivity.this, password);
                                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
