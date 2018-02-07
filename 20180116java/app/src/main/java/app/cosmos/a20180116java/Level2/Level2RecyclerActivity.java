package app.cosmos.a20180116java.Level2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Level2RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.level2_edit)
    EditText level2_edit;
    @BindView(R.id.level2_recycler)
    RecyclerView level2_recycler;
    private Level2Adapter level2Adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Level2_itemData> level2_itemDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_recycler);
        ButterKnife.bind(this);

        level2_recycler.setHasFixedSize(true);
        // 사이즈 고정
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        level2_recycler.setLayoutManager(layoutManager);
        // 레이아웃 지정

        level2_itemDatas = new ArrayList<Level2_itemData>();
        // 사용자 정의 데이터 배열 생성

        level2_itemDatas.add(new Level2_itemData("a 검색"));
        level2_itemDatas.add(new Level2_itemData("b 검색"));
        level2_itemDatas.add(new Level2_itemData("c 검색"));
        level2_itemDatas.add(new Level2_itemData("d 검색"));
        level2_itemDatas.add(new Level2_itemData("e 검색"));
        level2_itemDatas.add(new Level2_itemData("f 검색"));
        level2_itemDatas.add(new Level2_itemData("g 검색"));
        level2_itemDatas.add(new Level2_itemData("gedsd 검색"));
        level2_itemDatas.add(new Level2_itemData("gada 검색"));
        level2_itemDatas.add(new Level2_itemData("gee 검색"));
        level2_itemDatas.add(new Level2_itemData("gfa 검색"));
        level2_itemDatas.add(new Level2_itemData("gqwe 검색"));
        // 데이터 넣음


        level2Adapter = new Level2Adapter(level2_itemDatas,clickEvent);
        level2_recycler.setAdapter(level2Adapter);

        level2_edit.addTextChangedListener(new TextWatcher() {
            // editText에 값이 입력되는 경우 입력 값의 유효성을 검증하여 입력할 지 말지를 결정
            // 값이 입력될 때 무언가를 해주고 싶을 때 사용
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력하기 전에 호출됨

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // EditText에 변화가 있을 때

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력이 끝났을 때
                String text = level2_edit.getText().toString().toLowerCase();
                // toLowerCase는 대문자를 소문자로 변환
                level2Adapter.filter(text);
                // 입력받은 텍스트를 바로 level2Adapter의 filter함수의 매개변수로 전달
            }
        });

    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int itemPosition = level2_recycler.getChildPosition(view);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(Level2RecyclerActivity.this);
            dialog.setMessage("해당 항목을 삭제하시겠습니까?");
            dialog.setCancelable(true);
            dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    level2_itemDatas.remove(itemPosition);
                    level2Adapter.notifyDataSetChanged();


                }
            });

            dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    return;
                }
            });

            AlertDialog alert = dialog.create();
            alert.show();
        }
    };
}
