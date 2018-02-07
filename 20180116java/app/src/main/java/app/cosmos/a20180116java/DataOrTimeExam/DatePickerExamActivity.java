package app.cosmos.a20180116java.DataOrTimeExam;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatePickerExamActivity extends AppCompatActivity {

    @BindView(R.id.DatePickerBtn)
    Button DatePickerBtn;
    public static TextView SelectedDateText;
    public static int Datemonth;
    public static int Dateday;
    public static int Dateyear;

    /* FIXME
    * 날짜를 띄우는 다이얼로그를 만든다.
    * DatePickerFragment라는 클래스를 만들고 Dialog를 상속받고 DatePickerDiaolg.OnDateSetListener 인터페이스를 구현한다.
    * TimePicker를 만든 것과 똑같은 방법으로 진행한다.
    * */

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @RequiresApi(api = Build.VERSION_CODES.N)
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            /*FIXME
            * 다이얼로그를 만들 때 Calendar 객체를 만들어서 원하는 정보인
            * 년,월,일 정보를 받아온다.
            * */
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            /*FIXME
            * 그리고 반환할 때 DatePickerDialog 객체를 만들면서 정보들을 함께 넣어준다.
            * 테마는 지정할 수 있음*/
            return new DatePickerDialog(getActivity(), android.app.AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            /*FIXME
            가지고 온 데이터를 TextView에 설정한다.
            month는 처음이 0으로 되어있으므로 +1을 설정한다.
            * */
            Datemonth= month;
            Dateyear = year;
            Dateday = day;
            SelectedDateText.setText("Selected Date : "+(month+1)+"-"+day+"-"+year);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_exam);
        ButterKnife.bind(this);

        SelectedDateText = (TextView)findViewById(R.id.SelectedDateText);
    }

    @OnClick({R.id.DatePickerBtn,R.id.DatePickerSubmitBtn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.DatePickerBtn:
                DialogFragment newfragment = new DatePickerFragment();
                newfragment.show(getSupportFragmentManager(),"datePicker");
                break;
            case R.id.DatePickerSubmitBtn:
                Intent intent = new Intent(getApplicationContext(), PickerResultActivity.class);
                intent.putExtra("year",Dateyear);
                Log.v("906",String.valueOf(Dateyear));
                intent.putExtra("month",Datemonth+1);
                Log.v("906",String.valueOf(Datemonth+1));
                intent.putExtra("day",Dateday);
                Log.v("906",String.valueOf(Dateday));
                startActivity(intent);
                /*FIXME
                DatePickerDialog로부터 날짜 값을 받아서 다른 액티비티로 넘기기 위한 작업
                * */
        }

    }
}
