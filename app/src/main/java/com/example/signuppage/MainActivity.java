package com.example.signuppage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;

import android.view.View.OnClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        //SAVING THE USERNAME AND PASSWORD INPUT
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);

        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //CONVERTING TO STRING
                String userStore = user.getText().toString();
                String passStore = pass.getText().toString();

                //USING EMAIL
                firebaseAuth.signInWithEmailAndPassword(userStore, passStore).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this, LoginPage.class));

                        } else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }


    public void signUpdetails(View view) {

                Intent myIntent = new Intent(MainActivity.this,
                        SignUpDetails.class);
                startActivity(myIntent);
    }

}


