package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");

        Button test_button = findViewById(R.id.test_button);
//        test_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText my_editText= findViewById(R.id.my_editText);
//                TextView my_textView= findViewById(R.id.my_textView);
//                my_textView.setText(my_editText.getText());
//            }
//        });
    }
    public void submitOnclick(View view){
        EditText my_editText= findViewById(R.id.my_editText);
        TextView my_textView= findViewById(R.id.my_textView);
        my_textView.setText(my_editText.getText());

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");

    }
}