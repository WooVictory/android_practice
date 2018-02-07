package app.cosmos.a20180116java.Exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PageSlidingExamActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    Animation translateLeftAnim; // 오른쪽에서 왼쪽으로 이동하는 애니메이션 객체
    Animation translateRightAnim; // 왼쪽에서 오른쪽으로 이동하는 애니메이션 객체
    @BindView(R.id.page)
    LinearLayout page;
    @BindView(R.id.btn)
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_sliding_exam);
        ButterKnife.bind(this);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left); // 오른쪽에서 왼쪽으로
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right); // 왼쪽에서 오른쪽으로

        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);

    }
    @OnClick(R.id.btn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.btn :
                if(isPageOpen){
                    page.startAnimation(translateRightAnim);
                }else {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeftAnim);
                }
                break;
        }
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{

        /*FIXME
        서브 화면이 보이거나 보이지 않게 되는 시점은 애니메이션이 끝나는 시점이어야 한다.
        그렇다면 애니메이션이 끝나는 시점을 알아야 할 텐데, 애니메이션이 끝나는 시점은
        AnimationListener 인터페이스를 구현한 객체를 Animation 객체의 setAnimationListener() 메소드를 설정하면 알 수 있다.
        AnimationListener를 구현하는 SlidingPageAnimationListener 클래스를 정의한 후 이 클래스의 인스턴스 객체를
        생성하여 Animation 객체에 설정하였다. 이 AnimationListener에는 onAnimationEnd() 메소드가 정의되어 있으며
        애니메이션이 끝날 때 자동으로 호출된다.
        * */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);

                btn.setText("Open");
                isPageOpen=false;
            }else {
                btn.setText("Close");
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
/*FIXME
1. 처음으로 버튼을 클릭한 이벤트가 먼저 실행된다.
그러면 버튼을 눌렀을 때, isPageOpen이 false인 상태이므로 else 문에 걸린 분기가 이루어진다.
gone으로 감춰져 있던 뷰를 보여주고 translateLeftAnim 애니메이션을 시작한다.
그러면 오른쪽에서 왼쪽으로 애니메이션이 보여지고 종료된다. 그러면 종료되는 시점에 AnimationListener에 있는 onAnimationEnd이 호출된다.
근데 translateLeftAnim.setAnimationListener(animationListener); 을 통해서 animationListener를 달아줬다.
그러면 isPageOpen이 false 인 상태이므로 else 문에 걸린 분기가 이루어지게 되고 버튼의 text를 close로 바꿔주고 isPageOpen을 true로 바꿔준다.

2. 또 버튼을 클릭할 때는 이미 뷰가 보여진 상태이고 버튼도 Close라는 text로 있는 상태이고, isPageOpen도 true 상태이다.
그리고 위의 과정과 똑같은 과정이 반복된다.

이 일련의 과정들이 빠르게 진행되어서 한번에 일어나는 것처럼 보인다.
* */