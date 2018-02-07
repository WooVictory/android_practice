package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTxt = (TextView) findViewById(R.id.resultTxt);
        Intent intent = getIntent();
        String key = intent.getExtras().getString("result");
        resultTxt.setText(key);
    }
}
