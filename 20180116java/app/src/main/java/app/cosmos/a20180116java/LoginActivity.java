package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.loginId)
    EditText loginId;
    @BindView(R.id.loginPwd)
    EditText loginPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Toast.makeText(getApplicationContext() , "로그인 해주세요.",Toast.LENGTH_SHORT).show();


    }

    @OnClick({R.id.signBtn,R.id.loginBtn})
    void Click(View v){
        switch (v.getId())
        {
            case R.id.signBtn :
                Intent intent1 = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent1);
                break;
            case R.id.loginBtn:
                if (loginId.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "아이디 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(loginPwd.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "비밀번호 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                String inputId = loginId.getText().toString();
                String inputPwd = loginPwd.getText().toString();
                Intent getData = getIntent();
                String testId = getData.getExtras().getString("id");
                String testPwd = getData.getExtras().getString("pwd");


                if(inputId.equals(testId) && inputPwd.equals(testPwd))
                {
                    Log.v("id",inputId);
                    Log.v("pwd",inputPwd);
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                    Intent getData2 = getIntent();
                    Intent intent2 = new Intent(getApplicationContext(), ImageResultActivity.class);
                    intent2.putExtra("id",getData2.getExtras().getString("id"));
                    intent2.putExtra("pwd",getData2.getExtras().getString("pwd"));
                    intent2.putExtra("name",getData2.getExtras().getString("name"));
                    intent2.putExtra("major",getData2.getExtras().getString("major"));
                    intent2.putExtra("part",getData2.getExtras().getString("part"));
                    intent2.putExtra("gender",getData2.getExtras().getString("gender"));
                    intent2.putExtra("select img",getData2.getExtras().getInt("select img"));
                    Log.v("1031",getData2.getExtras().getString("id"));
                    Log.v("1031",getData2.getExtras().getString("pwd"));
                    Log.v("1031",getData2.getExtras().getString("name"));
                    Log.v("1031",getData2.getExtras().getString("major"));
                    Log.v("1031",getData2.getExtras().getString("part"));
                    Log.v("1031",getData2.getExtras().getString("gender"));
                    Log.v("1031",String.valueOf(getData2.getExtras().getInt("select img")));

                    startActivity(intent2);
                }else
                {
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                }

        }

    }
}
