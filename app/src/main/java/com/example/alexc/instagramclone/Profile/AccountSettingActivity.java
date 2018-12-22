package com.example.alexc.instagramclone.Profile;

import android.os.Bundle;
import android.util.Log;

import com.example.alexc.instagramclone.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountSettingActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        Log.d(TAG, "onCreate: onCreate: started");
    }
}
