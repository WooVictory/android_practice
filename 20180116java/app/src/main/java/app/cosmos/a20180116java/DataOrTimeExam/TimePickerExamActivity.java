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
    TimpickerFragment 클래스를 만든다.
    그리고 DialogFragment()를 상속받고 TimePickerDialog.OnTimeSetListener 인터페이스를 구현한다.
    * */
    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

        /*FIXME
        * 그리고 오버라이드해야 할 함수들을 오버라이드한다.
        * 여기서 오버라이드해서 사용할 함수들은
        * onCreateDialog와 onTimeSet 함수이다.
        * */
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            /*FIXME
            * onCreateDialog는 Dialog창을 만들 수 있도록 해준다.
            * 일단, Calnedar 객체를 만든다.
            * 그리고 TimePickerDialog를 위한 시간과 분 정보를 받아온다.
            * Dialog를 반환해야 하므로
            * return 값으로 TimePickerDialog 객체를 만들어서 반환해준다.
            * */
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT,this,hour,minute, android.text.format.DateFormat.is24HourFormat(getContext()));
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            /*FIXME
            * onCreateDialog에서 Calendar를 통해서 가지고 온 시간 정보를
            * onTimeSet에서 받아서 TextView에 설정한다.
            * */
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

        /*FIXME
        * 여기는 ButterKnife를 사용하지 않았음.
        * 왜냐하면 static으로 선언이 안되서 일단 이렇게 했음
        * */
        TimePickerText = (TextView) findViewById(R.id.TimePickerText);
    }
    @OnClick(R.id.TimePickerBtn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.TimePickerBtn:
                /*FIXME
                * 버튼 클릭시
                * DialogFragment를 TimePickerFragment() 클래스로부터 객체인 newfragment를 생성한다.
                * 다이얼로그인 newfragment.show()를 통해서 다이얼로그를 띄운다.
                * 타입은 DialogFragment이지만, TimePickerFragment()로부터 만들었기 때문에
                * TimePicker가 다이얼로그 형태로 화면에 보여진다.
                * */
                DialogFragment newfragment = new TimePickerFragment();
                newfragment.show(getSupportFragmentManager(),"timePicker");
                break;
        }
    }
}
