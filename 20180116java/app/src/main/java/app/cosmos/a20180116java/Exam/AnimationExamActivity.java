package app.cosmos.a20180116java.Exam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationExamActivity extends AppCompatActivity {

    @BindView(R.id.anim_text)
    TextView anim_text;
    @BindView(R.id.start_btn)
    Button start_btn;
    Animation flowAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_exam);
        ButterKnife.bind(this);

        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);
        // 애니메이션 객체를 로딩
        // AnimationUtils 클래스의 loadAnimation() 메소드를 사용해서 메모리에 객체로 로딩할 수 있다.
        // 이 객체를 이용해 뷰에 애니메이션을 적용하고 싶을 때는 단순히 startAnimation() 메소드를 호출하는 것만으로 충분합니다.
        // 이 때 단순히 설정만 하고자 한다면 setAnimation() 메소드를 사용한 후 Animation 객체의 start() 메소드로 실행한다.
        // 뷰 객체에 애니메이션을 적용함과 동시에 애니메이션을 시작하고 싶다면 startAnimation() 메소드를 사용한다.
        flowAnim.setAnimationListener(new Animation.AnimationListener() {
            // 애니메이션 리스너 설정하여 종료되는 시점 확인
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "애니메이션 종료됨", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @OnClick({R.id.start_btn,R.id.page_sliding_btn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.start_btn :
                anim_text.startAnimation(flowAnim);
                break;
            case R.id.page_sliding_btn:
                startActivity(new Intent(getApplicationContext(), PageSlidingExamActivity.class));
        }
        anim_text.startAnimation(flowAnim);
    }
}
