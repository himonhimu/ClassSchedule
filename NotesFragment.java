package bd.himu.himon.classschedule;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.arch.persistence.room.*;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {

    FloatingActionButton floatButton;
    RecyclerView mrecyleView;
   public static AppsDatabase appsDatabase;
    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        floatButton = (FloatingActionButton) view.findViewById(R.id.fabButton);
        mrecyleView = (RecyclerView) view.findViewById(R.id.recyle_view);


        setMrecyleView();

        ClickListener();
        // Inflate the layout for this fragment
        return view;
    }

    private void setMrecyleView() {

     appsDatabase = Room.databaseBuilder(getActivity(), AppsDatabase.class, "ClassOK")
                .allowMainThreadQueries()
                .build();

        List<NotesModel> noteList = appsDatabase.classDao().getAllClass();

        UserAdapter adapter = new UserAdapter(noteList);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mrecyleView.setLayoutManager(staggeredGridLayoutManager);

        mrecyleView.setAdapter(adapter);

        mrecyleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void ClickListener() {

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });
    }

    public void Dialog() {
        final AddDialogue dialogue = new AddDialogue(getActivity());
        //dialogue.fname.getText().toString();

        //dialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogue.setCancelable(true);
        dialogue.show();

        dialogue.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Title = dialogue.fname.getText().toString().trim();
                String body = dialogue.lname.getText().toString().trim();
           appsDatabase = Room.databaseBuilder(getActivity(), AppsDatabase.class, "ClassOK")
                        .allowMainThreadQueries()
                        .build();
               appsDatabase.classDao().insertAll(new NotesModel(Title, body));

                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                dialogue.dismiss();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();


    }
}
