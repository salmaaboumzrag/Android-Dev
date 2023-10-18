package com.example.myapplication_3_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editTextThird;
    private Button buttonBackThird;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // Récupérer le message de MainActivity
        textView = findViewById(R.id.textThird);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);
        //Send message to main
        editTextThird = findViewById(R.id.editTextThird);
        buttonBackThird = findViewById(R.id.buttonBackThird);
        buttonBackThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextThird.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("messageFromC", message);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}