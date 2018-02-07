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
    private String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_unit);
        ButterKnife.bind(this);

        wonEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence.toString())&& !charSequence.toString().equals(result))
                {
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
