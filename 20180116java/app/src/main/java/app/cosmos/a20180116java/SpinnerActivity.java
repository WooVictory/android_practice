package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.spinner1)
    Spinner spinner1; // xml 상에서 스피너 목록이나 만듦
    @BindView(R.id.spinner2)
    Spinner spinner2; // 자바 코드 상에서 스피너 목록을 만듦
    @BindView(R.id.spinner3)
    Spinner spinner3;
    @BindView(R.id.spinner4)
    Spinner spinner4;
    @BindView(R.id.submit)
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);

        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    public void addItemsOnSpinner2(){ // 자바 코드 상에서 스피너
        List<String> list = new ArrayList<>();
        list.add("1994년");
        list.add("1995년");
        list.add("1996년");

        List<String> list2 = new ArrayList<>();
        list2.add("1월");
        list2.add("2월");
        list2.add("3월");
        list2.add("4월");
        list2.add("5월");
        list2.add("6월");

        List<String> list3 = new ArrayList<>();
        list3.add("21일");
        list3.add("22일");
        list3.add("23일");
        list3.add("24일");
        list3.add("25일");
        list3.add("26일");
        list3.add("27일");
        // 리스트를 이용해서 스피너에 값들을 넣고 있다.



        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,list);
        // 앞에서 만든 리스트를 support_simple_spinner_dropdown_item 이 레이아웃을 기반으로 ArrayAdapter인 dataAdapter1를 만든다.
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 스피너를 드롭 다운 형식으로 해줌
        spinner2.setAdapter(dataAdapter1);
        // setAdapter를 통해 스피너에 리스트를 담고 있는 어답터를 연결시킴
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 스피너를 드롭 다운 형식으로 해줌
        spinner3.setAdapter(dataAdapter2);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 스피너를 드롭 다운 형식으로 해줌
        spinner4.setAdapter(dataAdapter3);



    }

    public void addListenerOnSpinnerItemSelection(){
/*        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            ListPopupWindow window = (ListPopupWindow)popup.get(spinner1);
            window.setHeight(700); //pixel
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListenser());
    }

    public void addListenerOnButton()
    { // 이거로 생년월일 스피너 구현하면 된다.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "OnClickListener : " +
                        "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                        "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()) +
                        "\nSpinner 3 : " + String.valueOf(spinner3.getSelectedItem()) +
                        "\nSpinner 4 : " + String.valueOf(spinner4.getSelectedItem()),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), SpinnerResultActivity.class);
                intent.putExtra("sp1 key",String.valueOf(spinner1.getSelectedItem()));
                Log.v("433",String.valueOf(spinner2.getSelectedItemPosition()));
                intent.putExtra("sp2 key",String.valueOf(spinner2.getSelectedItem()));
                intent.putExtra("sp3 key",String.valueOf(spinner3.getSelectedItem()));
                intent.putExtra("sp4 key",String.valueOf(spinner4.getSelectedItem()));
                Log.v("129",String.valueOf(spinner4.getSelectedItem()));
                Log.v("129",String.valueOf(spinner3.getSelectedItem()));

                startActivity(intent);
            }
        });
    }
}
