package app.cosmos.a20180116java.Exam;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-01-25.
 */

public class MainFragment extends Fragment{
    @BindView(R.id.main_fragment_btn)
    Button main_fragment_btn;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container,false);
        ButterKnife.bind(this,rootView);

        main_fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentExamActivity fragmentExamActivity = (FragmentExamActivity) getActivity();
                fragmentExamActivity.onFragmentChanged(0);
            }
        });
        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        showToast("onAttach");
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        showToast("onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        showToast("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        showToast("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onStart() {
        showToast("onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        showToast("onResume");
        super.onResume();
    }
    /*  @OnClick(R.id.main_fragment_btn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.main_fragment_btn :
                FragmentExamActivity fragmentExamActivity = (FragmentExamActivity) getActivity();
                fragmentExamActivity.onFragmentChanged(0);
        }
    }*/

    @Override
    public void onPause() {
        showToast("onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        showToast("onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        showToast("onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        showToast("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        showToast("onDetach");
        super.onDetach();
    }

    public void showToast(String data)
    {
        Toast.makeText(this.getContext(), data, Toast.LENGTH_SHORT).show();
    }
}
