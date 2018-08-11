package bd.himu.himon.classschedule;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {

    FloatingActionButton floatButton;
    RecyclerView mrecyleView;
    RecyclerView.Adapter adapter;
    ArrayList<String> users;


    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container,false );

        floatButton = (FloatingActionButton)view.findViewById(R.id.fabButton);
        mrecyleView = (RecyclerView)view.findViewById(R.id.recyle_view);

        setMrecyleView();
       ClickListener();
        // Inflate the layout for this fragment
        return view;
    }

    private void setMrecyleView(){
        users = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            users.add("HImon : "+ i);
        }

        mrecyleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =new UserAdapter(users);
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

    public void Dialog(){
        final AddDialogue dialogue = new AddDialogue(getActivity());

        //dialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogue.setCancelable(true);
        dialogue.show();

        dialogue.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "ok",Toast.LENGTH_SHORT).show();
                dialogue.dismiss();
            }
        });
    }

}
