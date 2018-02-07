package app.cosmos.a20180116java.DataOrTimeExam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PickerResultActivity extends AppCompatActivity {

    @BindView(R.id.PickerResultText)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Log.v("918","확인");
        int year = intent.getExtras().getInt("year",0);
        int month = intent.getExtras().getInt("month",0);
        int day = intent.getExtras().getInt("day",0);
        Log.v("911",String.valueOf(year));
        textView.setText(year+"년"+month+"월"+day+"일");
    }
}
