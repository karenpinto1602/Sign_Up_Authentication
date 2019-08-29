package com.example.signuppage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class LoginPage extends Activity {
    FirebaseAuth firebaseAuth;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_notes);

        button = findViewById(R.id.signoutbutton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SIGN OUT
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(LoginPage.this,MainActivity.class));
            }
        });
    }
}
