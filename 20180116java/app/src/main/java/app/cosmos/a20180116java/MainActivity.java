package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.cosmos.a20180116java.DataOrTimeExam.DatePickerExamActivity;
import app.cosmos.a20180116java.DataOrTimeExam.TimePickerExamActivity;
import app.cosmos.a20180116java.Exam.AnimationExamActivity;
import app.cosmos.a20180116java.Exam.DialogExamActivity;
import app.cosmos.a20180116java.Exam.ExamActivity;
import app.cosmos.a20180116java.Exam.FragmentExamActivity;
import app.cosmos.a20180116java.Exam.Main3Activity;
import app.cosmos.a20180116java.Exam.MoneyUnitActivity;
import app.cosmos.a20180116java.Exam.OrientationActivity;
import app.cosmos.a20180116java.Exam.ProgressExamActivity;
import app.cosmos.a20180116java.Exam.ToastExamActivity;
import app.cosmos.a20180116java.FontExam.FontExamActivity;
import app.cosmos.a20180116java.Four.FragmentActivity;
import app.cosmos.a20180116java.Four.ViewPager.ViewPagerActivity;
import app.cosmos.a20180116java.MenuExam.MenuActivity;
import app.cosmos.a20180116java.TabExam.TabExamActivity;
import app.cosmos.a20180116java.WebViewExam.WebViewActivity;

public class MainActivity extends AppCompatActivity {

    Button next_btn = null;
    EditText editText = null;
    Button Cal_btn =null;
    Button go;
    Button spinnerExam;
    Button threeBtn;
    Button examBtn;
    Button orientationBtn;
    Button toast_btn;
    Button dialog_btn;
    Button progress_btn;
    Button anim_btn;
    Button fragment_btn;
    Button main3_btn;
    Button fragment_go_btn;
    Button page_btn;
    Button menu_btn;
    Button font_btn;
    Button tab_exam_btn;
    Button web_view_btn;
    Button spinner2_btn;
    Button gird_btn;
    Button DateBtn;
    Button TimeBtn;
    Button moneyUnitBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next_btn = (Button) findViewById(R.id.next_btn);
        editText = (EditText) findViewById(R.id.editText);
        Cal_btn = (Button) findViewById(R.id.Cal_btn);
        go = (Button) findViewById(R.id.go) ;
        spinnerExam = (Button) findViewById(R.id.spinnerExam);
        threeBtn = (Button) findViewById(R.id.three_btn);
        examBtn = (Button) findViewById(R.id.exam_btn);
        orientationBtn = (Button) findViewById(R.id.orientation_btn);
        toast_btn = (Button) findViewById(R.id.toast_btn);
        dialog_btn = (Button) findViewById(R.id.dialog_btn);
        progress_btn = (Button) findViewById(R.id.progress_btn);
        anim_btn = (Button) findViewById(R.id.anim_btn);
        fragment_btn = (Button) findViewById(R.id.fragment_btn);
        main3_btn = (Button) findViewById(R.id.main3_btn);
        fragment_go_btn = (Button) findViewById(R.id.fragment_go_btn);
        page_btn = (Button) findViewById(R.id.page_btn);
        menu_btn = (Button) findViewById(R.id.menu_btn);
        font_btn = (Button) findViewById(R.id.font_btn);
        tab_exam_btn = (Button) findViewById(R.id.tab_exam_btn);
        web_view_btn = (Button) findViewById(R.id.web_view_btn);
        spinner2_btn = (Button) findViewById(R.id.spinner2_btn);
        gird_btn = (Button) findViewById(R.id.gird_btn);
        DateBtn = (Button) findViewById(R.id.DateBtn);
        TimeBtn = (Button) findViewById(R.id.TimeBtn);
        moneyUnitBtn = (Button) findViewById(R.id.moneyUnitBtn);
        next_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("key",editText.getText().toString());
                startActivity(intent);

            }
        });

        Cal_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalActivity.class);
                startActivity(intent);
            }
        });
        go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageSelectActivity.class);
                startActivity(intent);
            }
        });
        spinnerExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SpinnerActivity.class);
                startActivity(intent);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        examBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ExamActivity.class));
            }
        });
        orientationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OrientationActivity.class));
            }
        });
        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ToastExamActivity.class));
            }
        });
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DialogExamActivity.class));
            }
        });
        progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProgressExamActivity.class));
            }
        });
        anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AnimationExamActivity.class));
            }
        });
        fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FragmentExamActivity.class));
            }
        });
        main3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main3Activity.class));
            }
        });
        fragment_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FragmentActivity.class));
            }
        });
        page_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
            }
        });
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
        });
        font_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FontExamActivity.class));
            }
        });
        tab_exam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TabExamActivity.class));
            }
        });
        web_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });
        spinner2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Spinner2Activity.class));
            }
        });
        gird_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GridViewActivity.class));
            }
        });
        DateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DatePickerExamActivity.class));
            }
        });
        TimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TimePickerExamActivity.class));
            }
        });
        moneyUnitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MoneyUnitActivity.class));
            }
        });
    }
}
