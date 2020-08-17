package com.appstone.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExplicitIntentActivity extends AppCompatActivity {

    private EditText mEtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        mEtUsername = findViewById(R.id.et_user_name);
        final EditText mEtPassword = findViewById(R.id.et_password);

        Button mBtnLogin = findViewById(R.id.btn_login);
        Button mBtnIntentWithResult = findViewById(R.id.btn_intent_with_result);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();

                Intent dataIntent = new Intent(ExplicitIntentActivity.this, DataActivity.class);
                dataIntent.putExtra("USERNAME", username);
                dataIntent.putExtra("PASSWORD", password);
                dataIntent.putExtra("ISLOGGEDIN", true);
                startActivity(dataIntent);
            }
        });

        mBtnIntentWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();

                Intent dataIntent = new Intent(ExplicitIntentActivity.this, DataActivity.class);
                dataIntent.putExtra("USERNAME", username);
                dataIntent.putExtra("PASSWORD", password);
                dataIntent.putExtra("ISLOGGEDIN", true);
                startActivityForResult(dataIntent, 1000);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                String editedUsername = data.getExtras().getString("EDITED_USERNAME");
                mEtUsername.setText(editedUsername);
            } else {
                Toast.makeText(ExplicitIntentActivity.this, "User Cancelled operation", Toast.LENGTH_LONG).show();
            }
        }
    }
}