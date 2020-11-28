package com.example.telophony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageButton btnsms1;
    ImageButton btnsms2;
    ImageButton btnsms3;
    ImageButton btnsms4;
    ImageButton btnsms5;
    ImageButton btnCall1;
    ImageButton btnCall2;
    ImageButton btnCall3;
    ImageButton btnCall4;
    ImageButton btnCall5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsms1 = findViewById(R.id.btnmessage1);
        btnsms2 = findViewById(R.id.btnmessage2);
        btnsms3 = findViewById(R.id.btnmessage3);
        btnsms4 = findViewById(R.id.btnmessage4);
        btnsms5 = findViewById(R.id.btnmessage5);

        btnCall1 = findViewById(R.id.btncall1);
        btnCall2 = findViewById(R.id.btncall2);
        btnCall3 = findViewById(R.id.btncall3);
        btnCall4 = findViewById(R.id.btncall4);
        btnCall5 = findViewById(R.id.btncall5);


        btnsms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09972659164";
                Intent intent = new Intent(getApplicationContext(), sms.class);
                intent.putExtra("sms",Contact);
                startActivity(intent);
            }
        });
        btnsms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09667923201";
                Intent intent = new Intent(getApplicationContext(), sms.class);
                intent.putExtra("sms",Contact);
                startActivity(intent);
            }
        });
        btnsms3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09478636268";
                Intent intent = new Intent(getApplicationContext(), sms.class);
                intent.putExtra("sms",Contact);
                startActivity(intent);
            }
        });
        btnsms4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09367704413";
                Intent intent = new Intent(getApplicationContext(), sms.class);
                intent.putExtra("sms",Contact);
                startActivity(intent);
            }
        });
        btnsms5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09554684745";
                Intent intent = new Intent(getApplicationContext(), sms.class);
                intent.putExtra("sms",Contact);
                startActivity(intent);
            }
        });


        btnCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09972659164";
                Intent intent = new Intent(getApplicationContext(), call.class);
                intent.putExtra("call",Contact);
                startActivity(intent);
            }
        });
        btnCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09667923201";
                Intent intent = new Intent(getApplicationContext(), call.class);
                intent.putExtra("call",Contact);
                startActivity(intent);
            }
        });
        btnCall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09478636268";
                Intent intent = new Intent(getApplicationContext(), call.class);
                intent.putExtra("call",Contact);
                startActivity(intent);
            }
        });
        btnCall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09367704413";
                Intent intent = new Intent(getApplicationContext(), call.class);
                intent.putExtra("call",Contact);
                startActivity(intent);
            }
        });
        btnCall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Contact = "09554684745";
                Intent intent = new Intent(getApplicationContext(), call.class);
                intent.putExtra("call",Contact);
                startActivity(intent);
            }
        });

    }

}