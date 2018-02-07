package app.cosmos.a20180116java.FontExam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main4Activity extends FontExamActivity {
    //

    @Nullable
    @BindView(R.id.main4_text)
    TextView main4_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);


    }
}
