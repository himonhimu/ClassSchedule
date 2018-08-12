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
    List<NotesModel> noteList;
    UserAdapter adapter = new UserAdapter(noteList);



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

        NotesModel note1 = new NotesModel("Hello", "This is Body Text. This is Body Text. This is Body Text. This is Body Text. This is Body Text. This is Body Text. ");
        NotesModel note2 = new NotesModel("Steggared", "Add top margin only for the first item to avoid double space between items if (parent. .... Also, set item offset value as padding for its RecyclerView , and specify .... getSpanCount(); } else if (mgr instanceof StaggeredGridLayoutManager) ");
        NotesModel note3 = new NotesModel("Equal Column", "Equal column spacing for Android RecyclerView GridLayoutManager by using ... should be half size of the actual value you want to add as space between items.");
        NotesModel note8 = new NotesModel("Set Space", " Advantages of using layout manager either List, Grid or Staggered. ... Gallery of images is set but there is no spacing in between grid items.");
        NotesModel note4 = new NotesModel("Create the Authorization Request", " AdCreate the AuthorizationServiceConfiguration object in the AuthorizeListener::onClick method which declares the authorization and token endpoints of the OAuth server you wish to authorize with. In our example, we will use Google, but this will work with any compliant OAuth server.");
        NotesModel note5 = new NotesModel("Open the starter app", " The project won't build right away, as we have some boilerplate for AppAuth just to preserve the state and connect some buttons. You'll need to add the AppAuth gradle dependency in the next step before it can build.s.");
        NotesModel note6 = new NotesModel(" Overview", "In this codelab, you'll learn how to use enable Single Sign-on (SSO) with Chrome Custom Tabs via the AppAuth library, and optionally push managed configuration to provide a user login hint.");
        NotesModel note7 = new NotesModel("Welcome to Codelabs!", " Google Developers CodeLabs provide a guided, tutorial, hands-on coding experience. Most codelabs will step you through the process of building a small application, or adding a new feature to an existing application. They cover a wide range of topics such as Android Wear, Google Compute Engine, Project Tango, and Google APIs on iOS");
        
       /* noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);
        noteList.add(note4);
        noteList.add(note5);
        noteList.add(note6);
        noteList.add(note7);
        noteList.add(note8);
        */
        // noteList.add("HImon : ");
        // noteList.add("Raju");
        AppsDatabase db = Room.databaseBuilder(getActivity(), AppsDatabase.class, "ClassOK")
                .allowMainThreadQueries()
                .build();
        noteList = db.classDao().getAllClass();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mrecyleView.setLayoutManager(staggeredGridLayoutManager);
        mrecyleView.setAdapter(adapter);


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
       final AppsDatabase db1 = Room.databaseBuilder(getActivity(), AppsDatabase.class, "ClassOK")
                .allowMainThreadQueries()
                .build();

        dialogue.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = dialogue.fname.getText().toString().trim();
                String body = dialogue.lname.getText().toString().trim();
                db1.classDao().insetAll(new NotesModel(Title, body));
                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                dialogue.dismiss();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        noteList.clear();
    }
}
