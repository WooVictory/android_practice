package app.cosmos.a20180116java.Exam;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastExamActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_exam);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn,R.id.btn2,R.id.btn3})
    void click(View view)
    {
        switch (view.getId()){
            case R.id.btn :
                try {
                    Toast toastView = Toast.makeText(this, "위치가 바뀐 토스트 메시지입니다.",Toast.LENGTH_SHORT);
                    int xOffset = Integer.parseInt(editText.getText().toString());
                    int yOffset = Integer.parseInt(editText2.getText().toString());

                    toastView.setGravity(Gravity.TOP | Gravity.TOP, xOffset,yOffset);
                    // 첫 번째 파라미터를 Gravity.TOP로 설정하였으므로 위치를 설정하는 기준을 TOP로 한 것이다.
                    // CENTER로 바꾸면 위치를 설정하는 기준을 가운데로 하고 두 번째와 세 번째 파라미터의 값을 이용하여 조정하게 된다.
                    toastView.show();
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                break;
            case R.id.btn2 :
                LayoutInflater inflater = getLayoutInflater(); // 레이아웃 인플레이터 객체 참조
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));
                //
                TextView text = (TextView) findViewById(R.id.text);
                Toast toast = new Toast(this);
                text.setText("모양 바꾼 토스트");
                toast.setGravity(Gravity.CENTER, 0, -100);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                break;
            case R.id.btn3 :
                Snackbar.make(view, "스낵바입니다.",Snackbar.LENGTH_LONG).show();
                break;
        }


    }
}
/*FIXME
액티비티를 위해 만든 XML 레이아웃 파일은 setContentView() 메소드를 사용해
액티비티에 설정된다. setContentView() 메소드를 호출하면 XML 레이아웃 파일의 내용을 읽어
메모리에 객체로 만든 후 액티비티에 설정하는 과정을 거친다. 하지만 토스트만을 위한 레이아웃을 정의한다면
이 레이아웃은 액티비티를 위한 것이 아니기 때문에 LayoutInflater 객체를 사용해 직접 메모리에 객체화해야 한다.
* */