package com.hotel.hbh.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

                    AuthenticationHelper.getInstance().loginWithUsernameAndPassword(this,options);
                }
        );
    }
}