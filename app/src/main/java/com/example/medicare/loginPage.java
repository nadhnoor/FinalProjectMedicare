package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class loginPage extends AppCompatActivity {

    EditText username, password;
    Button login;
    Button signup;
    SignInButton loginGoogle;
    GoogleSignInClient mGoogleSignInClient; //From Gradle Build Google Services Auth
    static final int RC_SIGN_IN = 0;
    private View decorView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        login = findViewById(R.id.btn_login);
        loginGoogle = findViewById(R.id.btn_login_google);
        signup = findViewById(R.id.notHaveAcc_text);


        //HIDE STATUS BAR AND ACTION BAR
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBar());
        });

        //BUTTON GOOGLE SIGNIN --> USE CREDENTIALS.JSON FROM FILE CONFIGURATION GOOGLE SIGNIN REPORT (GRADLEW)
            // Configure sign-in to request the user's ID, email address, and basic
            // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //BUTTON GOOGLE LOGIN SET.ONCLICKLISTENER
        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_login_google:
                        signInWithGoogle();
                        break;
                }
            }
        });




        //BUTTON LOGIN --> EXECUTE VALIDATION DATA FROM INPUT CREDENTIALS DATA --> FROM REGISTER PAGE
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String passwordUser = password.getText().toString();
                //Validation Data
                if(Username.isEmpty() || passwordUser.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all Fields", Toast.LENGTH_SHORT).show();
                }else{
                    //Perform Query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDAO userDAO = userDatabase.userDAO();
                    new Thread((new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDAO.login(Username, passwordUser);
                            if(userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String user_name = userEntity.fullname;
                                startActivity(new Intent(loginPage.this, dashboard.class).putExtra("name", user_name));
                            }

                        }
                    })).start();
                }

            }
        });

        //NOT HAVE ALREADY ACCOUNT
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginPage.this, registrasiPage.class));
            }
        });

    }


    //SIGN IN WITH GOOGLE ACCOUNT METHOD (GoogleSignInAccount)
    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //After the user signs in, you can get a GoogleSignInAccount object for the user in the activity's onActivityResult method.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    //The GoogleSignInAccount object contains information about the signed-in user, such as the user's name.
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show();
            Intent loginWithGoogle = new Intent(this, dashboard.class);
            startActivity(loginWithGoogle);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
        }
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