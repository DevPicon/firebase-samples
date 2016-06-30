package com.devpicon.android.firebasesamples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.devpicon.android.firebasesamples.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            FirebaseUser firebaseUser = auth.getCurrentUser();
            Toast.makeText(
                    this,
                    "Usuario logeuado:" + firebaseUser.getDisplayName(),
                    Toast.LENGTH_SHORT)
                    .show();
            startActivity(new Intent(this, Main3WelcomeActivity.class));
        } else {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setLogo(R.drawable.logo_devpicon)
                            .setProviders(
                                    AuthUI.EMAIL_PROVIDER,
                                    AuthUI.GOOGLE_PROVIDER)
                            .build(),
                    RC_SIGN_IN);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, Main3WelcomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Hubo un problema con el logueo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
