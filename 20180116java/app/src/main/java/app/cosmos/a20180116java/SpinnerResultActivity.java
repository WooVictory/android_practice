package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerResultActivity extends AppCompatActivity {

    @BindView(R.id.result)
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_result);
        ButterKnife.bind(this);

        Intent getData = getIntent();
        String text1 = getData.getExtras().getString("sp1 key");
        String test2 = getData.getExtras().getString("sp2 key");
        String test3 = getData.getExtras().getString("sp3 key");
        String test4 = getData.getExtras().getString("sp4 key");
        result.setText(text1+ "\n" + test2 + test3 + test4);
    }
}
