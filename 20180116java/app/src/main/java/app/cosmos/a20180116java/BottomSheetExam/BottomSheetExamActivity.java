package app.cosmos.a20180116java.BottomSheetExam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetExamActivity extends AppCompatActivity {

    @BindView(R.id.bottom_toolbar)
    Toolbar bottom_toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_exam);
        ButterKnife.bind(this);

        setSupportActionBar(bottom_toolbar);
        setTitle("Bottom Sheet Dialog Example");

    }
    @OnClick(R.id.fab)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.fab:
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.getInstance();
                bottomSheetDialog.show(getSupportFragmentManager(),"bottomSheet");
        }
    }
}
