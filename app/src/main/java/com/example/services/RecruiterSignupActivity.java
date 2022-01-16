package com.example.services;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.services.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class RecruiterSignupActivity extends AppCompatActivity
{
//     Button sign_up_button;
//
//
//    EditText username,password,email,phonenumber,experience,certification,charges,address;
//    Switch availability;
//    FirebaseAuth mAuth;
//    FirebaseUser currentUser;
//
//    FirebaseDatabase rootNode;
//    DatabaseReference reference,rec_ref,subref,seeker_ref,dup_ref;
//    @Override    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recruiter_signup);
//
//
//        sign_up_button=(android.widget.Button)findViewById(R.id.button_next) ;
//       // availability=  (Switch) findViewById(R.id.switch1);
//        final Spinner spinner = (Spinner) findViewById(R.id.spinner_profession);
//
//        // Spinner click listener
//        spinner.setOnItemSelectedListener(this);
//
//        // Spinner Drop down elements
//        List<String> categories = new ArrayList<String>();
//        categories.add("Select A Category");
//        categories.add("Plumber");
//        categories.add("Carpenter");
//        categories.add("Electrician");
//        categories.add("cleaner");
//        categories.add("food services");
//        categories.add("Baby Sitter");
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password);
////        username=(EditText)findViewById(R.id.userName);
////        address=(EditText)findViewById(R.id.address);
////        phonenumber=(EditText)findViewById(R.id.phone);
////        charges=(EditText)findViewById(R.id.charges);
////
////        experience = (EditText) findViewById(R.id.experience);
////        certification = (EditText) findViewById(R.id.certifications);
//
//
//
//        sign_up_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                final String usernamestr= username.getText().toString();
//                final String passwordstr = password.getText().toString();
//
//
//                final String emailstr = email.getText().toString();
//                final String phonestr=phonenumber.getText().toString();
//
//                final String experiencestr=experience.getText().toString();
//                final String certificationstr=certification.getText().toString();
//                final String chargestr=charges.getText().toString();
//
//                final String addressstr=address.getText().toString();
//
//                final String category = spinner.getSelectedItem().toString();
//                final String status;
//
//                if (availability.isChecked())
//                    status = "yes";
//                else
//                    status ="no";
//
//
//
//                if(email.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
//                }
//                else if( password.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
//                }
//                else if( username.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
//                }
//                else if( charges.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter charges password", Toast.LENGTH_SHORT).show();
//                }
//                else if( phonenumber.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
//                }
//                else if( certification.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
//                }
//                else if( experience.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
//                }
//
//                else if( address.getText().length()<=0){
//                    Toast.makeText(RecruiterSignupActivity.this, "Enter address details", Toast.LENGTH_SHORT).show();
//                }
//
//                else{
//
//
//                    DatabaseReference refer = FirebaseDatabase.getInstance().getReference("Users");
//                    Query checkUser = refer.orderByChild("name").equalTo(usernamestr);
//                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            if (dataSnapshot.exists()) {
//                                Toast.makeText(RecruiterSignupActivity.this, "username already exists", Toast.LENGTH_LONG).show();
//
//
//                            } else {
//                                rootNode= FirebaseDatabase.getInstance();
//                               rec_ref =rootNode.getReference("Users");
//                                Workermodel worke= new Workermodel(usernamestr, passwordstr, emailstr,  phonestr,  experiencestr,  certificationstr,  chargestr,  addressstr,  category,  status, "worker") ;
//                                reference.child(usernamestr).setValue(worke);
//
//                                Intent ob = new Intent(RecruiterSignupActivity.this, MainActivity.class);
//                                startActivity(ob);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//
//
//                    });
//
//
//
//
//                }
//
//
//
//            }
//        });
//    }
//
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}
private EditText mEmail, mPassword;
    private Button mLogin, mRegistration;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_signup);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(RecruiterSignupActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        mLogin = (Button) findViewById(R.id.button_next);
        mRegistration = (Button) findViewById(R.id.registration);

        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RecruiterSignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(RecruiterSignupActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                        }else{
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(user_id).child("name");
                            current_user_db.setValue(email);
                        }
                    }
                });
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(RecruiterSignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(RecruiterSignupActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}

