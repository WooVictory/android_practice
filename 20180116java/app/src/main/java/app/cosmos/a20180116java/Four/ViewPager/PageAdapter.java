package app.cosmos.a20180116java.Four.ViewPager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sec on 2018-01-25.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    Context context;

    public PageAdapter(FragmentManager fm,int tabCount)
    {
        super(fm);
        this.tabCount = tabCount;
        // 생성자를 통해 초기화한다.
    }
    @Override
    public Fragment getItem(int position) {
        // tab 사용 시 int tabCount 추가해서 사용
        // tab  사용 시 tabCount도 객체 생성시 받아와야 합니다.
        // 각 페이지의 포지션마다 어떤 프래그먼트를 보여줄 것인지
        switch (position)
        {
            case 0:
                return new FirstPage();
            case 1:
                return new SecondPage();
            case 2:
                return new ThirdPage();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
