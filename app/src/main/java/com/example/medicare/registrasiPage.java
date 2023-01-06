package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrasiPage extends AppCompatActivity {

    Button signup;
    EditText full_name, phone, email, username, password;
    Button register;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_page);
        full_name = findViewById(R.id.input_fullname);
        phone = findViewById(R.id.input_phone);
        email = findViewById(R.id.input_email);
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        signup = findViewById(R.id.btn_signup);

        //HIDE STATUS BAR AND ACTION BAR
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBar());
        });

        //BUTTON SIGN UP --> EXECUTE VALIDATE INSERT DATA
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating User Entity
                UserEntity userEntity = new UserEntity();
                userEntity.setFullname(full_name.getText().toString());
                userEntity.setPhone(phone.getText().toString());
                userEntity.setEmail(email.getText().toString());
                userEntity.setUsername(username.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (validateInput(userEntity)){
                    //Do insert operation
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDAO userDAO = userDatabase.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            userDAO.RegisterUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"User Registered!", Toast.LENGTH_SHORT).show();
                                    Intent registerUser = new Intent(getApplicationContext(), loginPage.class);
                                    startActivity(registerUser);
                                }
                            });

                        }
                    }).start();

                }else{
                    Toast.makeText(getApplicationContext(),"Fill all fields!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //CREATE INPUT VALIDATION
    private Boolean validateInput(UserEntity userEntity){
        if(userEntity.getFullname().isEmpty() |
                userEntity.getPhone().isEmpty() |
                userEntity.getEmail().isEmpty() |
                userEntity.getUsername().isEmpty() |
                userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }

    //HIDE STATUS BAR AND ACTION BAR
    public void onWindowFocusChanged (boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBar());
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