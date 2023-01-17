package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import de.hdodenhof.circleimageview.CircleImageView;


public class user_profile extends AppCompatActivity {

    ImageButton logout;
    TextView user_nameInGoogle, EmailUserInGoogle;
    TextView NameUserInGoogle;
    CircleImageView userPhotoGoogle;
    TextView Fullname, Username, Email, Phone;
    GoogleSignInClient mGoogleSignInClient; //From Gradle Build Google Services Auth
    

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        logout= findViewById(R.id.btnLogoutProfile);
        Fullname = findViewById(R.id.txtNameProfile);
        Username = findViewById(R.id.txtUsernameProfile);
        Email = findViewById(R.id.txtEmailProfile);
        Phone = findViewById(R.id.txtPhoneNumberProfile);

        //GETTER-SETTER THE STRING DATA FROM DATABASE USER TO INPUT THE DATA USER
        String fullname = Global.fullname;
        String username = Global.username;
        String email = Global.email;
        String phone = Global.phone;

        Fullname.setText(fullname);
        Username.setText(username);
        Email.setText(email);
        Phone.setText(phone);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //GET-SETTER USER PROFILE FROM THEIR GOOGLE ACCOUNT
        user_nameInGoogle = findViewById(R.id.txtNameProfile);
        userPhotoGoogle = findViewById(R.id.photo_user);
        NameUserInGoogle = findViewById(R.id.txtName);
        EmailUserInGoogle = findViewById(R.id.txtEmailProfile);


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();
            Uri personPhoto = account.getPhotoUrl();

            NameUserInGoogle.setText(personName);
            EmailUserInGoogle.setText(personEmail);
            user_nameInGoogle.setText(personName);
            Glide.with(this).load(personPhoto).into(userPhotoGoogle);
        }


        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnLogoutProfile:
                        signOut();
                        break;
                }
            }
        });


    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(user_profile.this, "User Sign Out Successfully", Toast.LENGTH_SHORT).show();
                        Intent logout_acc = new Intent(user_profile.this, loginPage.class);
                        startActivity(logout_acc);
                    }
                });
    }
}