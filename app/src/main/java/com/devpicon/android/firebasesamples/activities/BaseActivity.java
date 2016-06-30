package com.devpicon.android.firebasesamples.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by armando on 6/28/16.
 */
public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Cargando...");
            progressDialog.setIndeterminate(true);
        }
    }

}
