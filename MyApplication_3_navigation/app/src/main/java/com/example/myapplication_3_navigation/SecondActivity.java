package com.example.myapplication_3_navigation;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{
    private TextView textView;
    private EditText editTextSecond;
    private Button buttonBackSecond;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Récupérer le message de MainActivity
        textView = findViewById(R.id.textSecond);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);

        //Send message to back
        editTextSecond = findViewById(R.id.editTextSecond);
        buttonBackSecond = findViewById(R.id.buttonBackSecond);
        buttonBackSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextSecond.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("messageFromB", message);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
        /*
        // Récupérer le nom de l'Intent
        String nom = getIntent().getStringExtra("NomUtilisateur");

        // Trouver le TextView par son ID
        TextView welcome_user = findViewById(R.id.welcome_user);

        // Remplir le TextView avec le nom
        welcome_user.setText("Bonjour, " + nom);

        Toast.makeText(this, "well done !",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Ajoutez le code de navigation vers la première activité ici si on veux pas que ça soit gérer par android
    }*/

