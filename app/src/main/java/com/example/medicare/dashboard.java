package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class dashboard extends AppCompatActivity {

    TextView fullname;
    TextView user_nameInGoogle;
    CircleImageView userPhotoGoogle;
    GoogleSignInClient mGoogleSignInClient; //From Gradle Build Google Services Auth
    private View decorView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //GETTER-SETTER THE STRING DATA FROM DATABASE USER TO INPUT THE NAME USER
        fullname = findViewById(R.id.txtName);
        String user_name = getIntent().getStringExtra("name");
        fullname.setText(user_name);



        //BUTTON GOOGLE SIGNIN --> USE CREDENTIALS.JSON FROM FILE CONFIGURATION GOOGLE SIGNIN REPORT (GRADLEW)
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //GET-SETTER USER PROFILE FROM THEIR GOOGLE ACCOUNT
        user_nameInGoogle = findViewById(R.id.txtName);
        userPhotoGoogle = findViewById(R.id.photo_user);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String personName = account.getDisplayName();
            Uri personPhoto = account.getPhotoUrl();

            user_nameInGoogle.setText(personName);
            Glide.with(this).load(personPhoto).into(userPhotoGoogle);
        }

        //HIDE STATUS BAR AND ACTION BAR
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBar());
        });

    }

    private int hideSystemBar(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}