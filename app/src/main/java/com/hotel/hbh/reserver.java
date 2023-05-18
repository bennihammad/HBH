package com.hotel.hbh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reserver extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7;
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

        mDatabase = FirebaseDatabase.getInstance().getReference();
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

        mDatabase.child("users").child(user.getNom_et_prénom()).setValue(user);

    }
}