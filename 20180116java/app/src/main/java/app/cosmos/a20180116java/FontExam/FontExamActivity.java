package app.cosmos.a20180116java.FontExam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FontExamActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.font_text)
    TextView font_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_exam);
        ButterKnife.bind(this);

        font_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main4Activity.class));
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }


}
