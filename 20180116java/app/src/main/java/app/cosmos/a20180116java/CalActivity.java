package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalActivity extends AppCompatActivity {




    TextView textNum;
    Button oneBtn;
    Button twoBtn;
    Button ThreeBtn;
    Button plusBtn;
    Button minusBtn;
    Button resultBtn;
    Button cancelBtn;

    String currentnum1;
    String currentnum2;
    String resultNum;


    int value;
    int PLUS = 0;
    int MINUS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        textNum = (TextView) findViewById(R.id.textNum);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        ThreeBtn = (Button) findViewById(R.id.ThreeBtn);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        resultBtn = (Button)findViewById(R.id.resultBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);


        plusBtn.setOnClickListener(mListener);
        minusBtn.setOnClickListener(mListener);
        resultBtn.setOnClickListener(mListener);
        cancelBtn.setOnClickListener(mListener);




    }

    Button.OnClickListener mListener = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.plusBtn:
                    currentnum1 = textNum.getText().toString();
                    Log.v("542",currentnum1);
                    textNum.setText("");
                    value = PLUS;
                    break;
                case R.id.minusBtn:
                    currentnum1 = textNum.getText().toString();
                    textNum.setText("");
                    value = MINUS;
                    break;
                case R.id.cancelBtn:
                    textNum.setText("");
                    break;
                case R.id.resultBtn:
                    if(value == PLUS)
                    {
                        currentnum2 = textNum.getText().toString();
                        textNum.setText("" + (Integer.parseInt(currentnum1) + Integer.parseInt(textNum.getText().toString())));
                    }else  if(value == MINUS)
                    {
                        currentnum2 = textNum.getText().toString();
                        textNum.setText("" + (Integer.parseInt(currentnum1) - Integer.parseInt(textNum.getText().toString())));
                    }
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    resultNum = textNum.getText().toString();
                    intent.putExtra("result",resultNum);
                    startActivity(intent);
                    Log.v("550",resultNum);
                    break;

            }
        }
    };

    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.oneBtn:
                textNum.setText(textNum.getText().toString()+1);
                Log.v("546",textNum.toString());
                break;
            case R.id.twoBtn:
                textNum.setText(textNum.getText().toString()+2);
                break;
            case R.id.ThreeBtn:
                textNum.setText(textNum.getText().toString()+3);
                break;
        }
    }
}
