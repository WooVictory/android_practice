package app.cosmos.a20180116java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Spinner2Activity extends AppCompatActivity {

    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.spinner2_textView)
    TextView spinner2_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);
        ButterKnife.bind(this);

        final String[] items = {"mike","angel","crow","john","ginnie","sally","cohen","rice","lee","kim","park"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                spinner2_textView.setText(items[position]);
                Toast.makeText(getApplicationContext(),items[position]+"선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinner2_textView.setText(" ");
            }
        });

    }
}
