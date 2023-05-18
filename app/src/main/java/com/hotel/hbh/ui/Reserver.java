package com.hotel.hbh.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hotel.hbh.R;
import com.hotel.hbh.data.User;
import com.hotel.hbh.helpers.auth.AuthenticationHelper;
import com.hotel.hbh.helpers.auth.RegisterUserOptions;

import java.util.HashMap;
import java.util.Map;


public class Reserver extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);

        editText1 = findViewById(R.id.Nom);
        editText2 = findViewById(R.id.email);
        editText3 = findViewById(R.id.phone);
        editText4 = findViewById(R.id.date_a);
        editText5 = findViewById(R.id.Date_d);
        editText6 = findViewById(R.id.chambre);
        editText7 = findViewById(R.id.n_chambre);

    }


    public void sendData(View view) {
        writeNewUser();
    }

    public void writeNewUser() {
        User user = new User(editText1.getText().toString(),
                editText2.getText().toString(),
                editText3.getText().toString(),
                editText4.getText().toString(),
                editText5.getText().toString(),
                editText6.getText().toString(),
                editText7.getText().toString()
        );


        RegisterUserOptions options = new RegisterUserOptions(
                user.getNom_et_prénom(), user.getEmail(),
                user.getNuméro_de_téléphone(), user.getChambre(),
                user.getNombre_de_chambre(),
                user.getDate_darrivéé(), user.getDate_de_départ());

        AuthenticationHelper.getInstance().registerUser(options);


    }
}