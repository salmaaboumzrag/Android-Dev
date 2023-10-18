package fr.lbuathier.tp_contacts;

import static fr.lbuathier.tp_contacts.HomeActivity.CONTACT_KEY;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {

    private EditText edName, edFirstName, editText;
    private Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.edName);
        edFirstName = (EditText) findViewById(R.id.edFirstName);
        editText = (EditText) findViewById(R.id.edBirthday);
        edName.setHintTextColor(Color.LTGRAY);
        edFirstName.setHintTextColor(Color.LTGRAY);

        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editText.setText(sdf.format(myCalendar.getTime()));
            }
        };
    }

    public void onDateClick(View view) {
        new DatePickerDialog(FormActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }




    public void validateClick (View view){
        boolean validate = true;
        if ( validateName(edName.getText().toString())== false) {
            Toast.makeText(FormActivity.this, "nom incorrect", Toast.LENGTH_SHORT).show();
            validate = false;
            edName.setText("");
            edName.setHintTextColor(Color.RED);
        }
        if ( validateName(edFirstName.getText().toString())== false) {
            Toast.makeText(FormActivity.this, "prénom incorrect", Toast.LENGTH_SHORT).show();
            validate = false;
            edFirstName.setText("");
            edFirstName.setHintTextColor(Color.RED);
        }
        if(validate) {

            Intent backIntent = new Intent();
            Contact contact =new Contact(edName.getText().toString(),edName.getText().toString(),"0123456789");
            backIntent.putExtra(CONTACT_KEY, contact);
            setResult(RESULT_OK,backIntent);


                String form = "\n" + edName.getText().toString() + "  " + edFirstName.getText().toString() + "\n" +
                    "va être ajouté aux contacts";

            Toast.makeText(FormActivity.this, form, Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
            builder.setTitle("Contact");
            builder.setMessage(form);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                    finish();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();


        }

    }


    public boolean validateName(String txt) {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

}
