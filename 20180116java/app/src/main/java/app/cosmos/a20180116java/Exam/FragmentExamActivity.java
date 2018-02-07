package app.cosmos.a20180116java.Exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.cosmos.a20180116java.R;

public class FragmentExamActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index)
    {
        if(index == 0)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        } else if( index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        }
    }

}
