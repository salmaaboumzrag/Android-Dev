package com.example.myapplication_3_navigation;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button1, button2;
    //private static final int REQUEST_CODE_SECOND = 1;
    //private static final int REQUEST_CODE_THIRD = 2;
    private ActivityResultLauncher<Intent> secondActivityLauncher;
    private ActivityResultLauncher<Intent> thirdActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextViewA);
        editText = findViewById(R.id.user_name);
        button1 = findViewById(R.id.buttonToSecond);
        button2 = findViewById(R.id.buttonToThird);

        // Initialisez le launcher pour SecondActivity
        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String messageFromB = data.getStringExtra("messageFromB");
                            textView.setText("Message from B: " + messageFromB);
                        }
                    }
                }
        );

        // Initialisez le launcher pour ThirdActivity
        thirdActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String messageFromC = data.getStringExtra("messageFromC");
                            textView.setText("Message from C: " + messageFromC);
                        }
                    }
                }
        );
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "Message from A to B: \n" + message);
                secondActivityLauncher.launch(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("message", "Message from A to C: \n " + message);
                thirdActivityLauncher.launch(intent);
            }
        });


        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "Message from A to B: \n" + message);
              //  startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_SECOND);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("message", "Message from A to C: \n " + message);
             //   startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_THIRD);
            }
        });*/
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_SECOND) {
                String messageFromB = data.getStringExtra("messageFromB");
                textView.setText("Message from B: " + messageFromB);
            } else if (requestCode == REQUEST_CODE_THIRD) {
                String messageFromC = data.getStringExtra("messageFromC");
                // Afficher le message dans votre TextView
                textView.setText("Message from C: " + messageFromC);
            }
        }
    }*/

}

    /*public void goToSecondActivity(View view) {
        // Récupérer le texte de l'EditText
        EditText editText = findViewById(R.id.user_name);
        String nom = editText.getText().toString();

        // Créer un Intent pour passer à SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);

        // Ajouter le nom en tant que données supplémentaires à l'Intent
        intent.putExtra("NomUtilisateur", nom);

        // Démarrer SecondActivity avec l'Intent
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        EditText editText = findViewById(R.id.user_name);
        // Effacer le contenu de l'EditText lorsque l'activité redevient active
        editText.setText("");
    } */

