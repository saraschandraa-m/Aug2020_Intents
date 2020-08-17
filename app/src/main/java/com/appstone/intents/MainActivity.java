package com.appstone.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onImplicitIntentClicked(View view) {
        Intent implicitIntent = new Intent(MainActivity.this, ImplicitIntentActivity.class);
        startActivity(implicitIntent);
    }

    public void onExplicitIntentClicked(View view) {
        startActivity(new Intent(MainActivity.this, ExplicitIntentActivity.class));
    }
}