package app.cosmos.a20180116java.Exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class ExamActivity extends AppCompatActivity {

    @BindView(R.id.view)
    View view;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 키 입력의 경우 이와 같은 메소드를 재정의하여 처리할 수 있다.
        // KeyCode는 어떤 키가 사용되는지 구별할 때 사용되고
        // KeyEvent는 키 입력 이벤트에 대한 정보를 알고 싶을 때 사용한다.
        // 하드웨어 Back 버튼을 누르는 경우 onBackPressed() 메소드만 다시 정의하면 간단하게 이벤트를 처리할 수 있다.
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(getApplicationContext(), "시스템 [Back] 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        ButterKnife.bind(this);

        final GestureDetector detector;
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨.");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨.");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨.");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨:"+v+","+v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨.");
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }
    @OnTouch(R.id.view)
    boolean onTouch(View view, MotionEvent motionEvent)
    {
        int action = motionEvent.getAction();

        float curX = motionEvent.getX();
        float curY = motionEvent.getY();

        if(action == MotionEvent.ACTION_DOWN)
        {
            println("손가락 눌림 : " + curX + "," + curY);
        }else if(action == MotionEvent.ACTION_MOVE)
        {
            println("손가락 움직임 : " + curX + "," + curY);
        }else if(action == MotionEvent.ACTION_UP)
        {
            println("손가락 뗌 : " + curX + "," + curY);
        }

        return true;

    }

    public void println(String data)
    {
        textView.append(data + "\n");
    }

}
