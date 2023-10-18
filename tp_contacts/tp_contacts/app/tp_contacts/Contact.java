package fr.lbuathier.tp_contacts;

import android.os.Parcelable;
import android.widget.EditText;

import java.io.Serializable;

public class Contact implements Serializable {

    private String edName;
    private String edFirstName;
    private String phoneNumber;
    private String birthDateumber;


    public Contact(String edName, String edFirstName, String phoneNumber) {
        this.edName = edName;
        this.edFirstName = edFirstName;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return edName;
    }

    public String getFirstName() {
        return edFirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
