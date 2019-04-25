package com.example.muslimquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.helper.PrefManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;

public class ProfileActivity extends BaseActivity {

    TextView name, email, password;
    ImageView name_user, email_user, password_user;
    String name_s, email_s, password_s;
    PrefManager prefManager;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        super.setUpActionBar("Profile Anda");

        auth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();


        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(ProfileActivity.this, SignInActivity.class));
                    finish();
                }
            }
        };

        prefManager = new PrefManager(this);
        init();
    }

    void init(){
        name = findViewById(R.id.tv_name_userr);
        email = findViewById(R.id.tv_email_user);
        password = findViewById(R.id.tv_password_user);
        name_user = findViewById(R.id.iv_edit_name);
        email_user = findViewById(R.id.iv_edit_email);
        password_user = findViewById(R.id.iv_edit_password);

        email_s = email.getText().toString();
        password_s = password.getText().toString();

        String getname = prefManager.getFullName();
        if (getname == null){
            name.setText("Nama Anda");
        }else{
            name.setText(getname);
        }
        String getemail = prefManager.getEmail();
        if (getemail == null){
            email.setText("Email belum disetting");
        }else{
            email.setText(getemail);
        }
        final String getpassword = prefManager.getPassword();
        if (getpassword == null){
            password.setText("Tidak ada password");
        }else{
            password.setText(getpassword);
        }

        name_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new BottomSheetDialog(ProfileActivity.this);
                d.setContentView(R.layout.dialog_edit);
                final TextView name_tv = d.findViewById(R.id.tv_name_edit);
                name_tv.setText("Nama Anda");
                final EditText name_edit = d.findViewById(R.id.et_name_edit);
                TextView batal = d.findViewById(R.id.tv_batal);
                TextView simpan = d.findViewById(R.id.tv_simpan);

                String name_  = prefManager.getFullName();
                name_s = name.getText().toString();
                if (name_ == null){
                    name_edit.setHint(name_s);
                }else{
                    name_edit.setText(name_s);
                }


                batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name_ = name_edit.getText().toString();
                        if (name_.equals("")){
                            Toast.makeText(ProfileActivity.this, "Lengkapi nama", Toast.LENGTH_SHORT).show();
                        }else{
                            prefManager.saveFullName(ProfileActivity.this, name_);
                            Toast.makeText(ProfileActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            name.setText(prefManager.getFullName());
                            d.dismiss();
                        }
                    }
                });

                d.setCancelable(true);
                d.show();
            }
        });

        email_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new BottomSheetDialog(ProfileActivity.this);
                d.setContentView(R.layout.dialog_edit);
                final TextView email_tv = d.findViewById(R.id.tv_name_edit);
                email_tv.setText("Email");
                final EditText email_edit = d.findViewById(R.id.et_name_edit);
                TextView batal = d.findViewById(R.id.tv_batal);
                TextView simpan = d.findViewById(R.id.tv_simpan);
                final ProgressBar progressBar = d.findViewById(R.id.progressBarDialog);

                String email_ = prefManager.getEmail();
                email_s = email.getText().toString();
                if (email_ == null){
                    email_edit.setHint(email_s);
                }else {
                    email_edit.setText(email_s);
                }

                batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressBar.setVisibility(View.VISIBLE);
                        String email_ = email_edit.getText().toString();
                        if (email_.equals("")){
                            Toast.makeText(ProfileActivity.this, "Lengkapi Email", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }else{
                            user.updateEmail(email_)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(ProfileActivity.this, "Email baru berhasil diupdate silahkan login kembali dengam email baru", Toast.LENGTH_LONG).show();
                                                signOut();
                                                progressBar.setVisibility(View.GONE);
                                            }else{
                                                Toast.makeText(ProfileActivity.this, "Gagal untuk update email", Toast.LENGTH_SHORT).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }
                    }
                });

                d.setCancelable(true);
                d.show();
            }
        });

        password_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new BottomSheetDialog(ProfileActivity.this);
                d.setContentView(R.layout.dialog_edit);
                final TextView password_tv = d.findViewById(R.id.tv_name_edit);
                password_tv.setText("Password");
                final EditText password_edit = d.findViewById(R.id.et_name_edit);
                TextView batal = d.findViewById(R.id.tv_batal);
                TextView simpan = d.findViewById(R.id.tv_simpan);
                final ProgressBar progressBar = d.findViewById(R.id.progressBarDialog);

                String password_ = prefManager.getPassword();
                password_s = password.getText().toString();
                if (password_ == null){
                    password_edit.setHint(password_s);
                }else {
                    password_edit.setText(password_s);
                    password_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressBar.setVisibility(View.VISIBLE);
                        String password_ = password_edit.getText().toString();
                        if (password_.equals("")){
                            Toast.makeText(ProfileActivity.this, "Lengkapi Password", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }else if (password_.toString().trim().length() < 6){
                            Toast.makeText(ProfileActivity.this, "Password terlalu pendek, minimal 6 karakter", Toast.LENGTH_SHORT).show();
                            signOut();
                            progressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(ProfileActivity.this, "Gagal update password", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

                d.setCancelable(true);
                d.show();
            }
        });
    }

    public void signOut(){
        auth.signOut();
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), OtherMenuActivity.class));
    }

}
