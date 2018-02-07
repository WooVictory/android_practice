package app.cosmos.a20180116java.Four;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-01-25.
 */

public class FirstFragment extends Fragment {
    @BindView(R.id.text1)
    TextView textView1;
    public FirstFragment(){ // 프래그먼트가 복원될 때 빈 생성자 호출 반드시 필요

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this,view);
        // inflate : xml을 객체화해서 사용
        // 그리고 view. 을 찍고 사용한다.
        // 이유는 액티비티와 다르게 setContentView가 없어서 어떠한 뷰에서 findViewById를 하거나 다른 동작을 할 때 사용하기 위함(그래서 view.을 사용)
        if(getArguments() !=null)
        { // Bundle 객체로 전달 받은 값이 있다면 텍스트 뷰에 추가
            textView1.setText(getArguments().getString("title")+"Fragment");
        }
        return view;
    }
}
