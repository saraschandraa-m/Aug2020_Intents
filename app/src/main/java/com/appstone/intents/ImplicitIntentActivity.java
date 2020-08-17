package com.appstone.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtPhoneNumber;
    private EditText mEtURL;
    private EditText mEtEmailAddress;
    private EditText mEtSubject;
    private EditText mEtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        mEtPhoneNumber = findViewById(R.id.et_phone_number);
        mEtURL = findViewById(R.id.et_url);
        mEtEmailAddress = findViewById(R.id.et_email_address);
        mEtSubject = findViewById(R.id.et_subject);
        mEtMessage = findViewById(R.id.et_message);

        Button mBtnCall = findViewById(R.id.btn_call);
        Button mBtnOpenBrowser = findViewById(R.id.btn_open_browser);
        Button mBtnSendEmail = findViewById(R.id.btn_send_email);

        mBtnCall.setOnClickListener(this);
        mBtnOpenBrowser.setOnClickListener(this);
        mBtnSendEmail.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                doCallNumber();
                break;

            case R.id.btn_open_browser:
                openBrowser();
                break;

            case R.id.btn_send_email:
                sendEmail();
                break;
        }
    }

    private void doCallNumber() {
        String phoneNumber = mEtPhoneNumber.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:".concat(phoneNumber)));
        startActivity(callIntent);
    }

    private void openBrowser() {
        String url = mEtURL.getText().toString();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse("https://".concat(url)));
        startActivity(browserIntent);
    }

    private void sendEmail() {
        String emailAddress = mEtEmailAddress.getText().toString();
        String subject = mEtSubject.getText().toString();
        String message = mEtMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        emailIntent.setType("message/rfc822");
        startActivity(emailIntent);
    }
}