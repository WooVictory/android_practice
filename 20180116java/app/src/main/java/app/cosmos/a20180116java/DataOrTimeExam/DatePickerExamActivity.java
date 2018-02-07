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


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @RequiresApi(api = Build.VERSION_CODES.N)
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), android.app.AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
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
        }

    }
}
