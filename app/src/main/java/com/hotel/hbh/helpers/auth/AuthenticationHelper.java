package com.hotel.hbh.helpers.auth;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hotel.hbh.ui.customer.UserApp;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationHelper {
    private static AuthenticationHelper instance;

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    private AuthenticationHelper(){}

    public void loginWithUsernameAndPassword(Context context, LoginOptions options) {
        if (options.username.equals("customer") && options.password.equals("customer")) {
            redirectToUserInterface(context);

            return;

        } else if (options.username.equals("admin") && options.password.equals("admin")) {
            redirectToAdminInterface(context);
            return;
        }

        Toast.makeText(context, "wrong password or username", Toast.LENGTH_SHORT).show();

    }

    public void registerUser(RegisterUserOptions options){
        CollectionReference collection = firestore.collection("users");

        Map<String, Object> data = new HashMap<>();
        data.put("nom", options.nom);
        data.put("email", options.email);
        data.put("phone", options.phone);
        data.put("date_a", options.dateArrive);
        data.put("date_d", options.dateDepart);
        data.put("chambre", options.chambre);
        data.put("n_chmbre", options.nChambre);

        collection.add(data)
                .addOnSuccessListener(documentReference -> {
                    System.out.println("Document added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    System.err.println("Error adding document: " + e.getMessage());
                });

    }

    private void redirectToUserInterface(Context context) {
        Intent i = new Intent(context, UserApp.class);

        context.startActivity(i);
    }

    private void redirectToAdminInterface(Context context) {
        Toast.makeText(context, "start admin activity", Toast.LENGTH_SHORT).show();
    }


    public static AuthenticationHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new AuthenticationHelper();

        return instance;
    }

}
