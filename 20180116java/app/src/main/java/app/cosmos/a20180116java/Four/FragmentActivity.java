package app.cosmos.a20180116java.Four;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.first_fragment_btn)
    Button first_btn;
    @BindView(R.id.second_fragment_btn)
    Button second_btn;
    @BindView(R.id.third_fragment_btn)
    Button third_btn;
    @BindView(R.id.fragment_container)
    FrameLayout fragment_container;
    @BindView(R.id.edit_fragment)
    EditText edit_fragment;
    @BindView(R.id.tag)
    Button tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);


        if(savedInstanceState == null)
        {
            Bundle bundle = new Bundle(); // 번들 객체를 생성
            bundle.putString("title",first_btn.getText().toString()); // 번들 객체에 title이라는 키 값으로 first_btn의 text 값인 1번을 value로 담는다.
            AddFragmenet(new FirstFragment(),bundle,"first"); // 그리고 AddFragment를 호출하면서 FirstFragment를 생성하고 번들과 tag를 매개변수로 넘겨준다.
        }

        /*FIXME
        savedInstanceState 동일한 액티비티가 재실행될 때 저장한 값이 있는지 판단
        여기서는 다루지 않음. 그래도 최초 실행되는 것이기 때문에 당연히 저장된 값은 없다.
        그리고 여기서는 처음에 아무런 값도 없을 때 FirstFragment를 달기 위해서 먼저 다는 것이다.
        * */
    }
    @OnClick({R.id.first_fragment_btn,R.id.second_fragment_btn,R.id.third_fragment_btn,R.id.tag})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.first_fragment_btn:
                Bundle bundle = new Bundle();
                bundle.putString("title","First");
                ReplaceFragment(new FirstFragment(),bundle,"first");
                //AddFragmenet(new FirstFragment(), bundle, "first",getSupportFragmentManager().findFragmentById(R.id.fragment_container));
                /*FIXME
                1. 번들 객체 생성
                2. 번들에 title이라는 키 값으로 버튼의 text 값인 first를 value로 번들에 저장
                3. 함수를 호출하면서 매개변수로 프래그먼트 객체를 생성하고 번들 객체를 넘기고 tag로 first를 넘긴다.
                * */
                break;
            case R.id.second_fragment_btn:
                Bundle bundle2 = new Bundle();
                bundle2.putString("title","Second");
                ReplaceFragment(new SecondFragment(),bundle2,"second");
                //AddFragmenet(new SecondFragment(), bundle2, "second",getSupportFragmentManager().findFragmentById(R.id.fragment_container));
                break;
            case R.id.third_fragment_btn:
                Bundle bundle3 = new Bundle();
                bundle3.putString("title",third_btn.getText().toString());
                ReplaceFragment(new ThirdFragment(),bundle3,"third");
                //AddFragmenet(new ThirdFragment(), bundle3, "third",getSupportFragmentManager().findFragmentById(R.id.fragment_container));
                break;
            case R.id.tag:
                Log.v("847",edit_fragment.getText().toString());
                TagFragment(edit_fragment.getText().toString());


        }
    }

    public void AddFragmenet(Fragment fragment, Bundle bundle, String tag, Fragment fragment2)
    {
        FragmentManager fm = getSupportFragmentManager(); // 프래그먼트 매니저 객체를 생성
        FragmentTransaction transaction = fm.beginTransaction(); // 트랜잭션 객체를 생성, 프래그먼트 매니저 클래스를 통해 해당 트랜잭션을 수행하겠다는 의미
        transaction.remove(fragment2); // 기존 프래그먼트 제거
        fragment.setArguments(bundle); // bundle 객체를 넘겨준다.
        transaction.add(R.id.fragment_container,fragment,tag); // 새로운 프래그먼트 추가
        transaction.addToBackStack(null); // 백스텍에 저장
        transaction.commit(); // 완료
    }
    public void AddFragmenet(Fragment fragment, Bundle bundle, String tag)
    { // 오버라이딩하여 최초에 추가될 프래그먼트 생성함수
        FragmentManager fm = getSupportFragmentManager(); // 프래그먼트 매니저 객체 생성
        FragmentTransaction transaction = fm.beginTransaction(); // 트랜잭션 객체 생성, 프래그먼트 매니저 클래스를 통해 해당 트랜잭션을 수행하겠다는 의미
        fragment.setArguments(bundle); // 인자로 들어온 번들 객체를 넘겨준다.
        transaction.add(R.id.fragment_container,fragment,tag); // fragment_container에 fragment와 tag를 추가한다.
        transaction.commit(); // 완료
    }
    public void TagFragment(String tag)
    {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment !=null) {
            transaction.attach(fragment);
            //transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    public void ReplaceFragment(Fragment fragment, Bundle bundle, String tag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment.setArguments(bundle); // 해당하는 프래그먼트의 Arguments에 bundle을 저장한다.
        transaction.replace(R.id.fragment_container,fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
