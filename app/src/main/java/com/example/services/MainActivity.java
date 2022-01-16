package com.example.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    private Button mRecruiter, mSeeker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecruiter = (Button) findViewById(R.id.recruiter);
        mSeeker = (Button) findViewById(R.id.seeker);

        //startService(new Intent(MainActivity.this, onAppKilled.class));
        mRecruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecruiterSignupActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mSeeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeekerLoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
