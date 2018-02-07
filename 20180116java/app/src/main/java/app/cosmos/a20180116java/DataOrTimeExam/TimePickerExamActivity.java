package app.cosmos.a20180116java.DataOrTimeExam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimePickerExamActivity extends AppCompatActivity {

    @BindView(R.id.TimePickerBtn)
    Button TimePickerBtn;
    public static TextView TimePickerText;
    public static int Datehour;
    public static int Dateminute;

    /*FIXME
    타임피커를 다이얼로그로 띄우는 방법
    20180207 이승우
    * */
    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK,this,hour,minute, android.text.format.DateFormat.is24HourFormat(getContext()));
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            Datehour = hour;
            Dateminute = minute;
            TimePickerText.setText("시간:"+hour+"시"+minute+"분");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_exam2);
        ButterKnife.bind(this);

        TimePickerText = (TextView) findViewById(R.id.TimePickerText);
    }
    @OnClick(R.id.TimePickerBtn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.TimePickerBtn:
                DialogFragment newfragment = new TimePickerFragment();
                newfragment.show(getSupportFragmentManager(),"timePicker");
                break;
        }
    }
}
