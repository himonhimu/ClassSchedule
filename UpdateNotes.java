package bd.himu.himon.classschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;


public class UpdateNotes extends AppCompatActivity {

    EditText updateTitle, updateBody, updateID;
    Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);
        updateTitle = (EditText)findViewById(R.id.udateTitle);
        updateBody = (EditText)findViewById(R.id.udateBody);
        updateButton = (Button)findViewById(R.id.udateText);
        updateID = (EditText) findViewById(R.id.udateid);

        Intent mIntent = getIntent();

        final String getTextTitle = mIntent.getStringExtra("getTitle");
        final String getTextBody = mIntent.getStringExtra("getBody");
        final  int a = mIntent.getIntExtra("getInt",0);

        updateTitle.setText(getTextTitle);
        updateBody.setText(getTextBody);
        updateID.setText(""+(a+1));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = updateTitle.getText().toString();
                String Body = updateBody.getText().toString();
                int uID = Integer.parseInt(updateID.getText().toString());





                Toast.makeText(UpdateNotes.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void onClickUpdet(int a) {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NotesFragment.appsDatabase.classDao().update(UserAdapter.users.get(a));
            }
        });
    }
}
