package com.hotel.hbh.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hotel.hbh.R;
import com.hotel.hbh.helpers.auth.AuthenticationHelper;
import com.hotel.hbh.helpers.auth.LoginOptions;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText usernameField;
    EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.usernameTextField);
        passwordField = findViewById(R.id.passwordTextField);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(
                v -> {
                    String username = usernameField.getText().toString();
                    String password = passwordField.getText().toString();

                    LoginOptions options = new LoginOptions(
                        username,
                        password
                    ) ;

                    AuthenticationHelper.getInstance().loginWithEmailAndPassword(this,options);
                }
        );

        FirebaseApp.initializeApp(this);

        // code for using local emulator suite
        boolean isTestMode = false;

        if(isTestMode){
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            String emulatorHost = "192.168.1.2";
            db.useEmulator(emulatorHost,9000);

            FirebaseFirestore fr = FirebaseFirestore.getInstance();
            fr.useEmulator(emulatorHost,8080);

            FirebaseAuth auth  = FirebaseAuth.getInstance();
            auth.useEmulator(emulatorHost,9099);
        }
    }
}