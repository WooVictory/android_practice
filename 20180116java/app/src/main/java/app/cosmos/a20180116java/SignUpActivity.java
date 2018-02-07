package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {


    @BindView(R.id.editId)
    EditText editId;
    @BindView(R.id.editPwd)
    EditText editPwd;
    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.editMajor)
    EditText editMajor;
    @BindView(R.id.radioGroup1)
    RadioGroup rg1;
    @BindView(R.id.radioGroup2)
    RadioGroup rg2;
    @BindView(R.id.spinner)
    Spinner spinner;



    String id;
    String pwd;
    String name;
    String major;
    RadioButton part;
    RadioButton gender;
    long cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        final ArrayList<String> year_list = new ArrayList<>();
        year_list.add("1");
        year_list.add("2");
        year_list.add("3");
        year_list.add("4");
        year_list.add("5");
        year_list.add("6");
        year_list.add("7");
        year_list.add("8");
        year_list.add("9");
        year_list.add("10");
        year_list.add("11");
        year_list.add("12");

        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, year_list);
        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "선택된 아이템:" +spinner.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                cnt = spinner.getItemIdAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @OnClick({R.id.submitBtn, R.id.resetBtn})
    void Click(View view)
    {
        switch (view.getId())
        {
            case R.id.submitBtn :

                part = (RadioButton) findViewById(rg1.getCheckedRadioButtonId());
                gender = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
                /*FIXME
                유효성 검사*/
                if(editId.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "아이디 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editPwd.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "비밀번호 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editName.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "이름 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editMajor.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "전공 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(part == null)
                {
                    Toast.makeText(getApplicationContext(), "파트 선택해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(gender == null)
                {
                    Toast.makeText(getApplicationContext(), "성별 선택해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                rg1.getCheckedRadioButtonId();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                Intent getData = getIntent();
                intent.putExtra("id",editId.getText().toString());
                intent.putExtra("pwd",editPwd.getText().toString());
                intent.putExtra("name",editName.getText().toString());
                intent.putExtra("major",editMajor.getText().toString());
                intent.putExtra("part",part.getText().toString());
                intent.putExtra("gender",gender.getText().toString());
                intent.putExtra("select img",getData.getExtras().getString("select img"));
                intent.putExtra("item",cnt);
                Log.v("417",String.valueOf(cnt));
                startActivity(intent);

            case R.id.resetBtn :
                editId.setText(" ");
                editPwd.setText(" ");
                editName.setText(" ");
                editMajor.setText(" ");
                rg1.clearCheck();
                rg2.clearCheck();
                break;
        }
    }
}
