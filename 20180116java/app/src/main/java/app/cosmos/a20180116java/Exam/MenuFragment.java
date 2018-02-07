package app.cosmos.a20180116java.Exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-01-25.
 */

public class MenuFragment extends Fragment {
    @BindView(R.id.menu_fragment_btn)
    Button menu_fragment_btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this,rootView);

        menu_fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentExamActivity fragmentExamActivity = (FragmentExamActivity) getActivity();
                fragmentExamActivity.onFragmentChanged(1);
            }
        });
        return rootView;
    }
}