package app.cosmos.a20180116java.Four.ViewPager;

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

public class ThirdPage extends Fragment {
    @BindView(R.id.viewpager_text3)
    TextView textView3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_content,container,false);
        ButterKnife.bind(this,view);
        textView3.setText("3번 Page");

        return view;
    }
}