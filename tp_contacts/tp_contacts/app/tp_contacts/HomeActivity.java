package fr.lbuathier.tp_contacts;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private final int RQC=100;
    public static final String CONTACT_KEY ="contact key";
    private ArrayList<Contact> listContacts = new ArrayList<>();
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ListView lv = findViewById(R.id.listView);
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, listeEquipes);
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, arraylisteEquipes);
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.equipe_layout, arraylisteEquipes);
        adapter = new ContactAdapter(HomeActivity.this, listContacts);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Toast.makeText(MainActivity.this, listeEquipes[position], Toast.LENGTH_SHORT).show();
         //       Toast.makeText((Context) HomeActivity.this, listContacts.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addContact(View view) {
        Intent intent = new Intent(HomeActivity.this, FormActivity.class);
        startActivityForResult(intent,  RQC);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK && requestCode==RQC){
            Contact contact = (Contact) data.getSerializableExtra(CONTACT_KEY);
            listContacts.add(contact);
            adapter.notifyDataSetChanged();

        }
    }
}