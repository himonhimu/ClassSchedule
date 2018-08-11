package bd.himu.himon.classschedule;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
        private BottomNavigationView mNavView;
        private FrameLayout mFramelayoyt;
        private  AssainmentFragment assainmentFragment;
        private  ClassFragment classFragment;
        private NotesFragment notesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        mFramelayoyt = (FrameLayout)findViewById(R.id.mFramelayout);
        assainmentFragment = new AssainmentFragment();
        classFragment = new ClassFragment();
        notesFragment = new NotesFragment();

        setFragment(classFragment);

        mNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_routin:
                        //mNavView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(classFragment);
                        return true;
                    case R.id.nav_assain:
                       // mNavView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(assainmentFragment);
                        return true;
                    case R.id.nav_note:
                       // mNavView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notesFragment);
                        return true;
                    default:
                        return false;

                }

            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mFramelayout,fragment);
        fragmentTransaction.commit();


    }
}
