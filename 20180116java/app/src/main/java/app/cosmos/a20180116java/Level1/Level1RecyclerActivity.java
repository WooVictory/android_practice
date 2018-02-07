package app.cosmos.a20180116java.Level1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Level1RecyclerActivity extends AppCompatActivity {


    @BindView(R.id.add_edit)
    EditText add_edit;
    @BindView(R.id.add_btn)
    Button add_btn;
    @BindView(R.id.level1_recycler)
    RecyclerView level1_recycler;
    private ArrayList<Level1_ItemData> itemDatas;
    private Level1Adapter level1Adapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_recycler);
        ButterKnife.bind(this);

        level1_recycler.setHasFixedSize(true); // recycler 뷰의 사이즈를 고정
        layoutManager = new LinearLayoutManager(this); // 리니어 레이아웃 매니저
        layoutManager.setOrientation(LinearLayout.VERTICAL); // 방향을 수직으로
        level1_recycler.setLayoutManager(layoutManager); // 리사이클러뷰의 레이아웃 매니저를 이 리니어 레이아웃 매니저로 설정

        itemDatas = new ArrayList<Level1_ItemData>();
        // 사용자 정의 데이터를 가진 ArrayList

        level1Adapter = new Level1Adapter(itemDatas, clickEvent);
        // itemDatas와 clickEvent를 Level1Adapter의 매개변수로 넘겨주면서 호출하고 있다.
        level1_recycler.setAdapter(level1Adapter);

    }

    @OnClick(R.id.add_btn)
    void click()
    {
        if(add_edit.getText().length() == 0)
        {
            Toast.makeText(getApplicationContext(), "내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
        }else
        {
            itemDatas.add(new Level1_ItemData(add_edit.getText().toString()));
            // add_edit이라는 EditText에 입력한 내용을 추가 버튼을 누르면 리사이클러뷰에 추가할 수 있다.
            level1Adapter.notifyDataSetChanged();
            // 추가 버튼을 누르고 추가될 때마다 갱신할 수 있음
            add_edit.setText("");
            // 추가할 때마다 editText 빈칸으로 초기화
        }
    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        // 해당 항목에 대한 클릭 이벤트를 만들어줌
        @Override
        public void onClick(View view) {
            final int itemPosition = level1_recycler.getChildPosition(view);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(Level1RecyclerActivity.this);
            dialog.setMessage("해당 항목을 삭제하시겠습니까?");
            dialog.setCancelable(true);
            dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    itemDatas.remove(itemPosition);
                    level1Adapter.notifyDataSetChanged();

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
