package bd.himu.himon.classschedule;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDialogue extends Dialog implements View.OnClickListener{

    Activity a;
    public Dialog d;
    EditText fname, lname, email;
    Button save;

    public AddDialogue(Activity a) {
        super(a);
        this.a=a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_dialogue);

        fname = findViewById(R.id.first_name);
        lname = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save_button);


    }


    @Override
    public void onClick(View view) {

    }
}
