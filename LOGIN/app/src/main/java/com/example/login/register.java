package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

         final EditText userName=(EditText)findViewById(R.id.etNewName);
         final EditText email=(EditText)findViewById(R.id.etNewEmail);
        final EditText password=(EditText)findViewById(R.id.etNewPassword);
        Button btnRegister=(Button)findViewById(R.id.btnNewRegister);


       btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);

               String newUser = userName.getText().toString();
               String newEmail = email.getText().toString();
               String newPassword = password.getText().toString();

               SharedPreferences.Editor editor = preferences.edit();

               editor.putString(newEmail + newPassword + "data", newUser + "\n" + newEmail);
               editor.commit();

               Intent loginScreen = new Intent(register.this,MainActivity.class);
               startActivity(loginScreen);

           }
       });


    }
}
