package app.cosmos.a20180116java.BottomSheetExam;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-02-07.
 */

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    @BindView(R.id.plusLo)
    LinearLayout plusLo;
    @BindView(R.id.searchLo)
    LinearLayout searchLo;
    @BindView(R.id.settingsLo)
    LinearLayout settingsLo;
    @BindView(R.id.refreshLo)
    LinearLayout refreshLo;
    Context context;
    public static BottomSheetDialog getInstance(){
        return new BottomSheetDialog();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog,container,false);
        ButterKnife.bind(this,view);
        view.setOnClickListener(this);
        plusLo.setOnClickListener(this);
        searchLo.setOnClickListener(this);
        settingsLo.setOnClickListener(this);
        refreshLo.setOnClickListener(this);
        return view;

    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plusLo:
                Log.v("930","확인");
                showToast("Plus");
                break;
            case R.id.refreshLo:
                showToast("Refresh");
                break;
            case R.id.settingsLo:
                showToast("Settings");
                break;
            case R.id.searchLo:
                showToast("Search");
                break;
        }
        dismiss();
    }

    public void showToast(String data)
    {
        Toast.makeText(getContext(),data,Toast.LENGTH_LONG).show();
    }
}
