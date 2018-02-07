package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.cosmos.a20180116java.Level1.Level1RecyclerActivity;
import app.cosmos.a20180116java.Level2.Level2RecyclerActivity;
import app.cosmos.a20180116java.Level3.Level3RecyclerActivity;
import app.cosmos.a20180116java.Three.BasicListViewActivity;
import app.cosmos.a20180116java.Three.Custom.CustomListViewActivity;
import app.cosmos.a20180116java.Three.Recycler.RecyclerViewActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.basic_btn,R.id.custom_btn,R.id.recycler_btn,R.id.level1_btn,R.id.level2_btn,R.id.level3_btn})
    void click(View v)
    {
        switch (v.getId())
        {
            case R.id.basic_btn :
                startActivity(new Intent(this, BasicListViewActivity.class));
                break;
            case R.id.custom_btn:
                startActivity(new Intent(this, CustomListViewActivity.class));
                break;
            case R.id.recycler_btn:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.level1_btn:
                startActivity(new Intent(this, Level1RecyclerActivity.class));
                break;
            case R.id.level2_btn:
                startActivity(new Intent(this, Level2RecyclerActivity.class));
                break;
            case R.id.level3_btn:
                startActivity(new Intent(this, Level3RecyclerActivity.class));
                break;
        }
    }
}
