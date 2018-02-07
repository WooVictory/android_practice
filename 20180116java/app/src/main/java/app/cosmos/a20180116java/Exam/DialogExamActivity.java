package app.cosmos.a20180116java.Exam;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogExamActivity extends AppCompatActivity {

    @BindView(R.id.dialog_textView)
    TextView dialog_textView;
    @BindView(R.id.show_btn)
    Button show_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_exam);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.show_btn)
    void click(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 대화상자를 만들기 위한 빌더 객체 생성
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까??");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "예, 버튼을 눌렀습니다.";
                dialog_textView.setText(message);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "아니오, 버튼을 눌렀습니다.";
                dialog_textView.setText(message);
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "취소 버튼을 눌렀습니다.";
                dialog_textView.setText(message);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
