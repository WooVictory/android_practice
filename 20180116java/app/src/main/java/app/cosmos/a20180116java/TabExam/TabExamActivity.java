package app.cosmos.a20180116java.TabExam;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabExamActivity extends AppCompatActivity {

    @BindView(R.id.TabExam_toolbar)
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_exam);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        /*FIXME
        xml에서 정의한 Toolbar 객체는 코드에서 setSupportActionBar() 메소드를 사용해
        액션바로 설정해야 한다. 이 메소드는 액티비티에 디폴트로 만들어진 액션바가 없을 경우에만 동작하므로
        액션바가 없는 스타일로 바꿔야한다. (사용하기 위해서는)
        * */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.TabExam_container,fragment1).commit();

        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                // 선택되는 탭의 위치를 보여줄 수 있다.
                // 탭이 선택될 때마다 이 메소드가 호출된다.
                // 뷰페이저를 쓰는 경우와 아닌 경우의 차이점을 볼 수 있다.
                // 프레임 레이아웃을 쓸 경우에는 tab의 포지션을 얻어와서
                // Toast로 선택된 탭이 어떤 탭인지 확인할 수 있다.
                Toast.makeText(getApplicationContext(), (position)+1+"탭이 선택되었습니다.",Toast.LENGTH_SHORT).show();

                /*FIXME
                Fragment 객체인 selected를 만들고
                탭이 선택된 위치에 따라서 위에서 만든 프래그먼트 객체를 할당하고 있다.

                * */
                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
                }else if(position == 1){
                    selected = fragment2;
                }else if(position == 2){
                    selected = fragment3;
                }

                fragmentManager.beginTransaction().replace(R.id.TabExam_container,selected).commit();
                // 위치에 따라서 선택된 프래그먼트의 객체를 프레임 레이아웃인 TabExam_container에 붙인 후 commit()을 한다.
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
