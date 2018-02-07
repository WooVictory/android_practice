package app.cosmos.a20180116java.Exam;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressExamActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    ProgressDialog dialog;
    private int brightness = 100;
    @BindView(R.id.seekBarText)
    TextView seekBarText;
    @BindView(R.id.showing_seekBar)
    Button showing_seekBar;
    @BindView(R.id.seekBarPanel)
    LinearLayout seekBarPanel;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_exam);
        ButterKnife.bind(this);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // 시크바의 값이 바뀔 때마다 호출됨
                setBrightness(i);
                // 화면 밝기를 지정하는 메소드
                seekBarText.setText("시크바의 값의 : "+i);
                // 시크바에 설정한 리스너는 시크바의 값이 바뀔 때마다 onProgressChanged() 메소드가 호출되도록
                // 되어 있으므로 메소드 안에서 화면 밝기를 지정하는 setBrightness()메소드를 호출한 후 텍스트뷰에 현재 밝기 수준을
                // 텍스트로 표시한다.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    private void setBrightness(int value)
    {
        if(value < 10) {
            value = 10;
        }else if(value > 10)
        {
            value = 100;
        }
        brightness = value;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value / 100;
        getWindow().setAttributes(params);
        /*FIXME
        화면의 밝기는 윈도우 매니저를 이용해 설정할 수 있는데, getWindow() 메소드를 이용해 참조한 객체의 윈도우 관련 정보를
        getAttributes()를 이용해 확인하거나 새로 설정할 수 있습니다.
        화면의 밝기를 설정하는 속성은 screenBrightness이며 getAttributes() 메소드를 이용해 참조한 속성 정보에 새로운 값을 지정한 후
        setAttributes() 메소드를 이용해 설정한다.
        * */
    }
    @OnClick({R.id.showing_btn, R.id.closing_btn,R.id.showing_seekBar})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.showing_btn:
                dialog = new ProgressDialog(getApplicationContext());
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다.");
                dialog.show();
                break;
            case R.id.closing_btn:
                if(dialog!=null)
                {
                    dialog.dismiss();
                }
                break;
            case R.id.showing_seekBar:
                seekBarPanel.setVisibility(View.VISIBLE);
        }
    }
}
