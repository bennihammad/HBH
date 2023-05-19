package com.hotel.hbh.helpers.auth;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hotel.hbh.ui.customer.UserApp;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationHelper {
    private static AuthenticationHelper instance;

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    private AuthenticationHelper() {
    }

    public void loginWithEmailAndPassword(Context context, LoginOptions options) {

        firebaseAuth.signInWithEmailAndPassword(options.email, options.password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();

                        if (user != null) {
                            String userId = user.getUid();
                            firestore.collection("users").document(userId).get().addOnSuccessListener(r -> {
                                String role = (String) r.get("role");

                                assert role != null;

                                if (role.equals(UserRoles.customer.name())) {
                                    redirectToUserInterface(context);
                                } else {
                                    redirectToAdminInterface(context);
                                }
                            });

                            return;

                        }
                        Toast.makeText(context, "user doesn't exist", Toast.LENGTH_SHORT).show();

                    } else {
                        Exception exception = task.getException();
                        assert exception != null;
                        Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

    public void registerUser(RegisterUserOptions options) {
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

    public String getDisplayName() {
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        assert user != null;
        final boolean validDisplayName = (user.getDisplayName() != null) && (!user.getDisplayName().isEmpty());

        return validDisplayName ? user.getDisplayName() : user.getEmail();

    }

    public String getUserId() {
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        assert user != null;

        return user.getUid();
    }
}
