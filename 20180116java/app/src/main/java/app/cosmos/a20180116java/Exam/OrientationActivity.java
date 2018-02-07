package app.cosmos.a20180116java.Exam;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.cosmos.a20180116java.R;

public class OrientationActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        showToast("onCreate 호출됨");
/*        editText = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString(); // 버튼을 클릭했을 때 사용자가 입력한 값을 name 변수에 할당
                Toast.makeText(getApplicationContext(), "입력된 값을 변수에 저장했습니다 : " + name , Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState !=null) // 이 화면이 초기화될 때 name 변수의 값 복원
        {
            name = savedInstanceState.getString("name");
            Toast.makeText(getApplicationContext(), "값을 복원했습니다 : "+name,Toast.LENGTH_SHORT).show();
        }*/

    }
/*    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name); // name 변수의 값 저장
        showToast("순서는??");
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){ // 가로 방향 전환 시 처리
            showToast("방향 : ORIENTATION_LANDSCAPE");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){ // 세로 방향 전환 시 처리
            showToast("방향 : ORIENTATION_PORTRAIT");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy 호출됨");
    }

    public void showToast(String data)
    {
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
    }
}
