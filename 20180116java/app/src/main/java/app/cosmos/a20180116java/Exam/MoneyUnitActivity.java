package app.cosmos.a20180116java.Exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoneyUnitActivity extends AppCompatActivity {

    @BindView(R.id.wonEdit)
    EditText wonEdit;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    // 이 부분이 EditText에 입력되는 부분을 원화 단위로 글자를 변경시켜주는 부분이다.
    // 소수점이나 다른 단위가 필요하면 이 부분을 변경하면 된다.
    private String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_unit);
        ButterKnife.bind(this);

        wonEdit.addTextChangedListener(new TextWatcher() {
            /*FIXME
            * EditText의 글자 변화를 감지한다.
            * */
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence.toString())&& !charSequence.toString().equals(result))
                {
                    /*FIXME
                    !TextUtils.isEmpty(charSequence.toString()) 이 부분은 EditText가 비어있지 않을 때만 실행한다는 것입니다.
                    !charSequence.toString().equals(result) 이 조건은
                    TextWatcher는 계속해서 EditText를 검사하게 되는데, 그 때마다 메소드를 반복 실행합니다.
                    아직 변경이 된 부분이 없는데, 반복적으로 포맷 변경을 하고 setText를 하는 동작은 불필요하기 때문에
                    이전의 결과값과 동일하면 실행시키지 않습니다. 
                    * */
                    result = decimalFormat.format(Double.parseDouble(charSequence.toString().replaceAll(",","")));
                    wonEdit.setText(result);
                    wonEdit.setSelection(result.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
