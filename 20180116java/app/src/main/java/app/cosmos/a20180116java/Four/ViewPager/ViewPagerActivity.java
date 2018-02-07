package app.cosmos.a20180116java.Four.ViewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.first_pager_btn)
    Button first_pager_btn;
    @BindView(R.id.second_pager_btn)
    Button second_pager_btn;
    @BindView(R.id.third_pager_btn)
    Button third_pager_btn;
    @BindView(R.id.viewPager_content)
    ViewPager viewPager_content;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        /*FIXME
        tab 사용시 tabLayout에 탭을 생성해줌
        * */
        tabLayout.addTab(tabLayout.newTab().setText("1번 Tab"));
        tabLayout.addTab(tabLayout.newTab().setText("2번 Tab"));
        tabLayout.addTab(tabLayout.newTab().setText("3번 Tab"));

        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        // 페이지어답터를 생성하고 매개변수로 프래그먼트 매니저와 tabLayout의 tab 갯수를 넘겨준다.
        viewPager_content.setAdapter(pagerAdapter);
        // viewPager의 어답터를 설정한다.
        viewPager_content.setCurrentItem(0);
        // 최초 실행시 보여질 페이지의 포지션 값 설정

        viewPager_content.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // 탭과 페이지를 서로 연동
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 탭 클릭시 이벤트 부여
            @Override
            public void onTabSelected(TabLayout.Tab tab) { // 해당 탭 선택
                viewPager_content.setCurrentItem(tab.getPosition());
                // 탭 선택 시 뷰페이저에 탭카운트에 해당하는 포지션의 프래그먼트 호출
                /*FIXME
                내가 이해한 것으로는 지금
                탭이랑 뷰 페이저를 서로 연동시킨 다음에 탭 클릭시 이벤트를 부여했다.
                그리고 탭 선택시 탭에 해당되는 포지션을 얻어온다.
                예를 들어서, 첫 번째 탭을 선택했을 경우 얻어온 position은 0이다
                0을 viewPager_content.setCurrentItem(0)처럼 넣어준다.
                그러면 자동으로 PageAdapter에 있는 getItem에 내가 위에서 넣은 tab의 포지션 값을 넣어주고
                switch case문에 의해서 0일 때는 첫 번째 페이지를 호출해준다.

                이게 다른 tab의 포지션일 때도 동일하다
                * */



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { // 비선택

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { // 재선택

            }
        });

    }
    @OnClick({R.id.first_pager_btn,R.id.second_pager_btn,R.id.third_pager_btn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.first_pager_btn:
                viewPager_content.setCurrentItem(0);
                break;
            case R.id.second_pager_btn:
                viewPager_content.setCurrentItem(1);
                break;
            case R.id.third_pager_btn:
                viewPager_content.setCurrentItem(2);
                break;
        }
    }

}
